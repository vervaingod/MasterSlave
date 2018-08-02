package cn.xjy.service;


import cn.xjy.model.UserDO;

import java.util.List;

/**
 * ClassName: UserService
 * Function: User接口
 * date: 2018年7月18日
 *
 * @author 许嘉阳
 * @version 1
 */
public interface UserService {
    int addUser(UserDO userDO);

    int updateUser(UserDO userDO);

    List<UserDO> findAllUser(int pageNum, int pageSize);

    int deleteUserById(int id);

    UserDO selectUserById(int id);

    boolean hasMatchUser(String userName, String phone);
}
