package com.example.login_register.service;

import com.example.login_register.entity.User;
import com.example.login_register.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public String findUserPasswordByUserName(String username) {
        return userMapper.findUserPasswordByUserName(username);
    }

    public String userNameIsExist(String username) {
        return userMapper.userNameIsExist(username);
    }

    public void addUser(String username, String password) {
        userMapper.adduser(username, password);
    }

    public List<User> getAll() {
        List<User> users = userMapper.getAll();
        return users;
    }
}
