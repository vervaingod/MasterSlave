package cn.xjy.controller;

import cn.xjy.model.UserDO;
import cn.xjy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: UserController
 * Function: 用户相关操作
 * date: 2018年7月18日
 *
 * @author 许嘉阳
 * @version 1
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/users1", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public List<UserDO> findAllUser(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        logger.info("开始查询用户列表信息1");
        return userService.findAllUser(1, 10);
    }

    @RequestMapping(value = "/users2/{pageNum}/{pageSize}", produces = {
            "application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public List<UserDO> findAllUser2(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        logger.info("开始查询用户列表信息2");
        return userService.findAllUser(1, 10);
    }

    @RequestMapping(value = "/users3/{pageNum}/{pageSize}", produces = {
            "application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public List<UserDO> findAllUser3(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
                                     @RequestParam("sort") String sort) {
        logger.info("开始查询用户列表信息3");
        return userService.findAllUser(1, 10);
    }

    @RequestMapping(value = "/users", produces = {
            "application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public int insertUser(@RequestBody UserDO userDO) {
        logger.info("插入用户信息");
        return userService.addUser(userDO);
    }

    @RequestMapping(value = "/users/{userId}", produces = {
            "application/json;charset=UTF-8"}, method = RequestMethod.PUT)
    public int updateUser(@PathVariable int userId, @RequestBody UserDO userDO) {
        logger.info("修改用户信息");
        return userService.updateUser(userDO);
    }

    @RequestMapping(value = "/users/{userId}", produces = {
            "application/json;charset=UTF-8"}, method = RequestMethod.DELETE)
    public int deleteUser(@PathVariable("userId") int userId) {
        logger.info("删除用户信息");
        return userService.deleteUserById(userId);
    }
}