package com.kilogod.code.controller;

import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.config.JWTToken;
import com.kilogod.code.config.LogoutToken;
import com.kilogod.code.domain.dto.UserDTO;
import com.kilogod.code.domain.vo.UserInfoVO;
import com.kilogod.code.domain.vo.UserVO;
import com.kilogod.code.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import java.util.Map;

/**
 * @author anding
 * @description
 */
@Api(tags = "登录")
@RestController
public class LoginController {
    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private IUserService userService;

    @ApiOperation("登录接口")
    @PostMapping("/login")
    public ResultData login(@RequestBody UserDTO userDTO) {
        ResultData rc = new ResultData();
        try {
            UserVO loginInfo = userService.getLoginInfo(userDTO);
            rc.setData(loginInfo);
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
        } catch (Exception e) {
            rc.setError("用户名或密码错误！");
        }
        return rc;
    }

    @ApiOperation("管理员登录接口")
    @PostMapping("/adminlogin")
    public ResultData adminlogin(@RequestBody UserDTO userDTO) {
        ResultData rc = new ResultData();
        try {
            UserVO loginInfo = userService.adminlogin(userDTO);
            rc.setData(loginInfo);
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
        } catch (Exception e) {
            rc.setError("用户名或密码错误！");
        }
        return rc;
    }

    @ApiOperation(value = "注销登录token信息")
    @GetMapping(value = "/logoutToken")
    public ResultData logoutToken(HttpServletRequest request) {
        ResultData rc = new ResultData();
        try {
            String header = request.getHeader(AUTHORIZATION);
            if (StringUtils.isBlank(header)) {
                throw new ValidationException("token为空！");
            }
            LogoutToken.addQueue(header.split(" ")[1]);
            rc.setData(header);
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
        } catch (Exception e) {
            rc.setError("token为空！");
        }
        return rc;
    }

    @PostMapping("/checkToken")
    @ApiOperation("验证token信息")
    public ResultData checkToken(@RequestBody Map<String,String> map){
        ResultData rc = new ResultData();
        try{
            UserInfoVO userinfo = JWTToken.verifyToken(map.get("token"));
            if (userinfo==null){
                rc.setError("token有误！");
                return rc;
            }
            boolean b = userService.checkUserInfo(userinfo);
            if (!b){
                rc.setError("token有误！");
            }else{
                rc.setData(true);
            }
        }catch(Exception e){
            rc.setError(e.getMessage());
        }
        return rc;
    }
}
