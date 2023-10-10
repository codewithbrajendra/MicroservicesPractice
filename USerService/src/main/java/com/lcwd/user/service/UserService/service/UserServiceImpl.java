package com.lcwd.user.service.UserService.service;

import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public User createUser(User user) {
        if(user != null) {
            String userId = UUID.randomUUID().toString();
            user.setUserId(userId);
            User createdUser = userRepositories.save(user);
            return createdUser;
        }
        return null;
    }

    @Override
    public User findByUserId(String userId) {
        if(userId != null) {
            User user = userRepositories.findByUserId(userId);
            return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositories.findAll();
    }
}
