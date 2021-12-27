package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.config.JWTToken;
import com.kilogod.code.domain.Admin;
import com.kilogod.code.domain.User;
import com.kilogod.code.domain.dto.UserDTO;
import com.kilogod.code.domain.dto.UserPwdDTO;
import com.kilogod.code.domain.dto.UserQueryDTO;
import com.kilogod.code.domain.dto.UserResetPwdDTO;
import com.kilogod.code.domain.vo.UserInfoVO;
import com.kilogod.code.domain.vo.UserVO;
import com.kilogod.code.mapper.AdminMapper;
import com.kilogod.code.mapper.UserMapper;
import com.kilogod.code.redis.Redis;
import com.kilogod.code.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Anding
 * @since
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper mapper;

    @Resource
    private AdminMapper adminMapper;

    @Autowired
    private Redis redis;

    @Override
    public int register(UserDTO dto) throws ValidationException {
        if (StringUtils.isBlank(dto.getPhone())){
            throw new ValidationException(ResultCode.PARAMS_IS_NOT_NULL);
        }
        User phone = mapper.selectOne(new QueryWrapper<User>().eq("phone", dto.getPhone()));
        if (phone!=null){
            throw new ValidationException(ResultCode.phone_IS_EXIST);
        }

        User exUser=new User();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (StringUtils.isBlank(dto.getPassword())){
            exUser.setPassword(encoder.encode("123456"));
        }else{
            exUser.setPassword(encoder.encode(dto.getPassword()));
        }
        exUser.setPhone(dto.getPhone());
        exUser.setIsVip("1");
        exUser.setIsAgent("0");
        exUser.setInUse("1");
        exUser.setRoleId(0);
        exUser.setIntegral(0);
        exUser.setAmount(new BigDecimal(0));
        int insert = mapper.insert(exUser);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int resetPwd(UserResetPwdDTO dto) throws ValidationException {
        if (StringUtils.isBlank(dto.getCode())){
            throw new ValidationException(ResultCode.PARAMS_IS_NOT_NULL);
        }
        String code = redis.get("resetpwd-"+dto.getPhone());
        if (!dto.getCode().equals(code)){
            throw new ValidationException(ResultCode.MSG_CODE_ERROR);
        }
        User user=new User();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (StringUtils.isBlank(dto.getNewpwd())){
            user.setPassword(encoder.encode("123456"));
        }else{
            user.setPassword(encoder.encode(dto.getNewpwd()));
        }

        int phone = mapper.update(user, new QueryWrapper<User>().eq("phone", dto.getPhone()));
        return phone;
    }

    @Override
    public UserVO adminlogin(UserDTO userDTO) throws ValidationException {
        if (StringUtils.isBlank(userDTO.getPhone())||StringUtils.isBlank(userDTO.getPassword())){
            throw new ValidationException(ResultCode.PARAMS_IS_NOT_NULL);
        }
        Admin admin = adminMapper.selectOne(new QueryWrapper<Admin>().eq("phone", userDTO.getPhone()));
        if ("".equals(admin)||admin==null){
            throw new ValidationException(ResultCode.USERID_USERPASSWORD_FAIL);
        }
        String role = admin.getRole();
        if (!"2".equals(role)){
            throw new ValidationException(ResultCode.AUTH_NOT_ENOUGH);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean matches = encoder.matches(userDTO.getPassword(), admin.getPassword());
        if (!matches){
            throw new ValidationException(ResultCode.USERID_USERPASSWORD_FAIL);
        }
        UserInfoVO userInfo=new UserInfoVO();
        userInfo.setId(admin.getId());
        userInfo.setUsername(admin.getUsername());
        userInfo.setPhone(admin.getPhone());
        userInfo.setAmount(new BigDecimal(admin.getRole()));
        userInfo.setRole("2");

        String token = JWTToken.createToken(userInfo);
        UserVO userVO=new UserVO();
        userVO.setToken(token);
        userVO.setDeadline(JWTToken.getDeadline(token));
        userVO.setUserInfo(userInfo);
        return userVO;
    }

    @Override
    public int insert(User user) throws ValidationException {
        int insert = mapper.insert(user);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<User>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(User user) throws ValidationException {
        int i = mapper.updateById(user);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<User> getList() throws ValidationException {
        List<User> lists = mapper.selectList(new QueryWrapper<User>());
        if (CollectionUtils.isEmpty(lists)){
            throw new ValidationException(ResultCode.QUERY_IS_NULL);
        }
        return lists;
    }

    @Override
    public int batchDelete(List<Integer> ids) throws ValidationException {
        int i = mapper.deleteBatchIds(ids);
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public UserVO getLoginInfo(UserDTO userDTO) throws ValidationException {
        if (StringUtils.isBlank(userDTO.getPhone())||StringUtils.isBlank(userDTO.getPassword())){
            throw new ValidationException(ResultCode.PARAMS_IS_NOT_NULL);
        }
        User user = mapper.selectOne(new QueryWrapper<User>().eq("phone", userDTO.getPhone()));
        if ("".equals(user)||user==null){
            throw new ValidationException(ResultCode.USERID_USERPASSWORD_FAIL);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean matches = encoder.matches(userDTO.getPassword(), user.getPassword());
        if (!matches){
            throw new ValidationException(ResultCode.USERID_USERPASSWORD_FAIL);
        }
        UserInfoVO userInfo=new UserInfoVO();
        userInfo.setId(user.getId());
        userInfo.setUsername(user.getUsername());
        userInfo.setPhone(user.getPhone());
        userInfo.setAmount(user.getAmount());
        userInfo.setRole("1");

        String token = JWTToken.createToken(userInfo);
        UserVO userVO=new UserVO();
        userVO.setToken(token);
        userVO.setDeadline(JWTToken.getDeadline(token));
        userVO.setUserInfo(userInfo);

        return userVO;
    }

    @Override
    public boolean checkUserInfo(UserInfoVO userInfo) {
        if ("1".equals(userInfo.getRole())){
            User user = mapper.selectOne(new QueryWrapper<User>().eq("id", userInfo.getId()).eq("phone", userInfo.getPhone()));
            if (user==null){
                return false;
            }
        }else if ("2".equals(userInfo.getRole())){
            Admin admin = adminMapper.selectOne(new QueryWrapper<Admin>().eq("id", userInfo.getId()).eq("phone", userInfo.getPhone()));
            if (admin==null){
                return false;
            }
        }
        return true;
    }

    @Override
    public List<User> getList(UserQueryDTO dto) throws ValidationException {
        List<User> users = mapper.selectList(new QueryWrapper<User>()
                .like(StringUtils.isNotBlank(dto.getUsername()),"username",dto.getUsername())
                .like(StringUtils.isNotBlank(dto.getPhone()),"phone",dto.getPhone()));
        if (CollectionUtils.isEmpty(users)){
            throw new ValidationException(ResultCode.QUERY_FAIL);
        }
        return users;
    }

    @Override
    public User getUserById(String id) throws ValidationException {
        User ex = mapper.selectOne(new QueryWrapper<User>().eq("id", id));
        if (ex==null){
            throw new ValidationException(ResultCode.QUERY_FAIL);
        }
        return ex;
    }

    @Override
    public int updatePwd(UserPwdDTO dto) throws ValidationException {
        User user = mapper.selectOne(new QueryWrapper<User>().eq("id", dto.getUserId()));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean matches = encoder.matches(dto.getOldpwd(), user.getPassword());
        if (!matches){
            throw new ValidationException(ResultCode.USERID_USERPASSWORD_FAIL);
        }
        User exUser=new User();
        exUser.setId(dto.getUserId());
        exUser.setPassword(encoder.encode(dto.getNewpwd()));
        int update = mapper.updateById(exUser);
        if (update<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return update;
    }
}
