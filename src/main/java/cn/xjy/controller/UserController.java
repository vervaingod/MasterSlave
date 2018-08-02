package cn.xjy.controller;

import cn.xjy.model.UserDO;
import cn.xjy.service.UserService;
import io.swagger.annotations.*;
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
@Api(value = "UserController")
public class UserController {
    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "查询用户列表信息1-参数", notes = "查询用户列表信息1-参数", produces = "application/json")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, paramType = "query", dataType = "int")})
    @RequestMapping(value = "/users1", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public List<UserDO> findAllUser(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        logger.info("开始查询用户列表信息1");
        return userService.findAllUser(1, 10);
    }

    @ApiOperation(value = "查询用户列表信息2-路径", notes = "查询用户列表信息2-路径", produces = "application/json")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, paramType = "path", dataType = "int")})
    @RequestMapping(value = "/users2/{pageNum}/{pageSize}", produces = {
            "application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public List<UserDO> findAllUser2(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        logger.info("开始查询用户列表信息2");
        return userService.findAllUser(1, 10);
    }

    @ApiOperation(value = "查询用户列表信息3-参数和路径", notes = "查询用户列表信息3-参数和路径", produces = "application/json")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "sort", value = "排序", required = false, paramType = "query", dataType = "String")})
    @RequestMapping(value = "/users3/{pageNum}/{pageSize}", produces = {
            "application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public List<UserDO> findAllUser3(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
                                     @RequestParam("sort") String sort) {
        logger.info("开始查询用户列表信息3");
        return userService.findAllUser(1, 10);
    }

    @ApiOperation(value = "插入用戶信息", notes = "插入用戶信息", produces = "application/json")
    @RequestMapping(value = "/users", produces = {
            "application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public int insertUser(@RequestBody @ApiParam(name = "userDO", value = "用户实体", required = true) UserDO userDO) {
        logger.info("插入用户信息");
        return userService.addUser(userDO);
    }

    @ApiOperation(value = "修改用戶信息", notes = "修改用戶信息", produces = "application/json")
    @RequestMapping(value = "/users/{userId}", produces = {
            "application/json;charset=UTF-8"}, method = RequestMethod.PUT)
    public int updateUser(@PathVariable int userId, @RequestBody @ApiParam(name = "userDO", value = "用户实体", required = true) UserDO userDO) {
        logger.info("修改用户信息");
        return userService.updateUser(userDO);
    }

    @ApiOperation(value = "删除用戶信息", notes = "删除用戶信息", produces = "application/json")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userId", value = "编号", required = true, paramType = "path", dataType = "int")
    })
    @RequestMapping(value = "/users/{userId}", produces = {
            "application/json;charset=UTF-8"}, method = RequestMethod.DELETE)
    public int deleteUser(@PathVariable("userId") int userId) {
        logger.info("删除用户信息");
        return userService.deleteUserById(userId);
    }
}