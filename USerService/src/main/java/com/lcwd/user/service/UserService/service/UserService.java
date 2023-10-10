package com.lcwd.user.service.UserService.service;

import com.lcwd.user.service.UserService.entities.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);

    public User findByUserId(String userId);

    public List<User> getAllUsers();
}
