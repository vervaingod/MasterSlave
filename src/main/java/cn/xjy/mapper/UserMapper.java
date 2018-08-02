package cn.xjy.mapper;


import cn.xjy.model.UserDO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: UserMapper
 * Function: 用户相关操作
 * date: 2018年7月18日
 *
 * @author 许嘉阳
 * @version 1
 */
@Component(value = "userMapper")
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    List<UserDO> selectAllUser();
}