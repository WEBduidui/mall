package com.kilogod.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.config.annotation.validateuser.ValidateUser;
import com.kilogod.code.domain.User;
import com.kilogod.code.domain.dto.UserDTO;
import com.kilogod.code.domain.dto.UserPwdDTO;
import com.kilogod.code.domain.dto.UserQueryDTO;
import com.kilogod.code.domain.dto.UserResetPwdDTO;
import com.kilogod.code.domain.vo.UserInfoVO;
import com.kilogod.code.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author Anding
 * @since
 */
@Slf4j
@Api(tags = {"用户"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "注册用户")
    public ResultData register(@RequestBody UserDTO dto){
        ResultData rc = new ResultData();
        try {
            rc.setData(userService.register(dto));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @PutMapping("/updatePwd")
    @ApiOperation(value = "修改密码")
    public ResultData updatePwd(@RequestBody UserPwdDTO dto, @ValidateUser UserInfoVO vo){
        ResultData rc = new ResultData();
        try {
            dto.setUserId(vo.getId());
            rc.setData(userService.updatePwd(dto));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @PutMapping("/resetPwd")
    @ApiOperation(value = "重置密码")
    public ResultData resetPwd(@RequestBody UserResetPwdDTO dto){
        ResultData rc = new ResultData();
        try {
            rc.setData(userService.resetPwd(dto));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @GetMapping("/getUserById")
    @ApiOperation(value = "通过id查询用户")
    public ResultData getUserById(@RequestParam String id){
        ResultData rc = new ResultData();
        try {
            rc.setData(userService.getUserById(id));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @PostMapping("/insert")
    @ApiOperation(value = "新增用户")
    public ResultData insert(@RequestBody User user){
        ResultData rc = new ResultData();
        try {
            rc.setData(userService.insert(user));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除用户")
    public ResultData delete(@RequestParam String id){
        ResultData rc = new ResultData();
        try {
            rc.setData(userService.delete(id));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新用户")
    public ResultData update(@RequestBody User user){
        ResultData rc = new ResultData();
        try {
            rc.setData(userService.updateData(user));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询用户分页数据")
    public ResultData<PageInfo<User>> getList(UserQueryDTO dto){
        ResultData rc = new ResultData();
        try {
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<User> list = userService.getList(dto);
            PageInfo<User> data = new PageInfo<>(list);
            rc.setData(data);
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }


    @PostMapping("/batchDelete")
    @ApiOperation(value = "批量删除用户")
    public ResultData batchDelete(@RequestBody List<Integer> ids) {
        ResultData rc = new ResultData();
        try {
            rc.setData(userService.batchDelete(ids));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

}
