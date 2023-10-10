package com.lcwd.user.service.UserService.controller;

import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        if(createdUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        if(userId != null) {
            User user = userService.findByUserId(userId);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
}
