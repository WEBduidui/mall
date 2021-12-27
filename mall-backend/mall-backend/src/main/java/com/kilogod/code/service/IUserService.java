package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.User;
import com.kilogod.code.domain.dto.UserDTO;
import com.kilogod.code.domain.dto.UserPwdDTO;
import com.kilogod.code.domain.dto.UserQueryDTO;
import com.kilogod.code.domain.dto.UserResetPwdDTO;
import com.kilogod.code.domain.vo.UserInfoVO;
import com.kilogod.code.domain.vo.UserVO;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface IUserService extends IService<User> {

    /**
     * 注册用户
     *
     * @param dto 用户
     * @return int
     * @throws ValidationException
     */
    int register(UserDTO dto) throws ValidationException;

    /**
     * @Author anding
     * @Param [dto]
     * @return int
     * @Description 重置密码
     **/
    int resetPwd(UserResetPwdDTO dto) throws ValidationException;

    /**
     * @param userDTO
     * @return
     * @throws ValidationException
     *  管理员登录
     */
    UserVO adminlogin(UserDTO userDTO) throws ValidationException;

    /**
    * 添加用户
    *
    * @param user 用户
    * @return int
    * @throws ValidationException
    */
    int insert(User user) throws ValidationException;

    /**
    * 删除用户
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改用户
    *
    * @param user 用户
    * @return int
    * @throws ValidationException
    */
    int updateData(User user) throws ValidationException;

    /**
     * 查询用户分页数据
     * @return List<User>
     */
    List<User> getList() throws ValidationException;

    /**
    * 批量删除用户
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;


    UserVO getLoginInfo(UserDTO userDTO) throws ValidationException;
    boolean checkUserInfo(UserInfoVO userInfo);

    List<User> getList(UserQueryDTO dto) throws ValidationException;

    User getUserById(String id) throws ValidationException;

    int updatePwd(UserPwdDTO dto) throws ValidationException;
}
