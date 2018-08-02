package cn.xjy.service.impl;

import cn.xjy.common.datasource.TargetDataSource;
import cn.xjy.mapper.UserMapper;
import cn.xjy.model.UserDO;
import cn.xjy.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static cn.xjy.common.constant.DataSourceConstant.READ_DATASOURCE_KEY;


/**
 * ClassName: UserServiceImpl
 * Function: 用戶操作
 * date: 2018年7月18日
 *
 * @author 许嘉阳
 * @version 1
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;// 这里会报错，但是并不会影响

    @Override
    @Transactional
    @TargetDataSource
    public int addUser(UserDO userDO) {

        return userMapper.insertSelective(userDO);
    }

    @Override
    @Transactional
    @TargetDataSource
    public int updateUser(UserDO userDO) {

        return userMapper.updateByPrimaryKeySelective(userDO);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数 pageSize 每页显示的数据条数
     */
    @Override
    @TargetDataSource(dataSource = READ_DATASOURCE_KEY)
    public List<UserDO> findAllUser(int pageNum, int pageSize) {
        // 将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }

    @Override
    @Transactional
    @TargetDataSource
    public int deleteUserById(int id) {

        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UserDO selectUserById(int id) {

        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean hasMatchUser(String userName, String phone) {
        return true;
    }
}
