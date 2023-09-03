package com.zhuang.docker.controller;

import cn.hutool.core.util.IdUtil;
import com.zhuang.docker.entity.UserDTO;
import com.zhuang.docker.service.UserService;
import com.zhuang.docker.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import com.zhuang.docker.entity.User;

import javax.annotation.Resource;
import java.util.Random;

/**
 * description: UserController
 * date: 2023/3/31 13:26
 * author: Zhuang
 * version: 1.0
 */
@Api(description = "用户User接口")
@RestController
@Slf4j
public class UserController {
    @Resource
    private UserServiceImpl userService;

    @ApiOperation("数据库新增3条记录")
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public void addUser() {
        for (int i = 1; i <= 3; i++) {
            User user = new User();

            user.setUsername("zk" + i);
            user.setPassword(IdUtil.simpleUUID().substring(0, 6));
            user.setSex((byte) new Random().nextInt(2));

            userService.addUser(user);
            userService.showUsers();
        }
    }

    @ApiOperation("删除1条记录")
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        userService.showUsers();
    }


    @ApiOperation("修改1条记录")
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public void updateUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.updateUser(user);
        userService.showUsers();
    }

    @ApiOperation("查询1条记录")
    @RequestMapping(value = "/user/find/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable Integer id) {
        userService.showUsers();
        return userService.findUserById(id);
    }
}

