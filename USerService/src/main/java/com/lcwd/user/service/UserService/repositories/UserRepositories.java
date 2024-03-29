package com.lcwd.user.service.UserService.repositories;

import com.lcwd.user.service.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User, String> {

    public User findByUserId(String userId);
}
