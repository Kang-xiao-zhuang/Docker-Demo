package com.zhuang.docker.service;

import com.zhuang.docker.entity.User;

/**
 * description: UserService
 * date: 2023/3/31 13:25
 * author: Zhuang
 * version: 1.0
 */
public interface UserService {

    void addUser(User user);

    User findUserById(Integer id);

    void deleteUser(Integer id);

    void updateUser(User user);

    void showUsers();
}

