package com.entrelineas.proyectobackend.controller;

import com.entrelineas.proyectobackend.entity.User;
import com.entrelineas.proyectobackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<?> create (@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PostMapping("/users/login")
    public User user(@RequestBody User user) throws Exception {
        User userDB = userService.findByUsername(user.getUsername());
        if( userDB == null)
            throw new Exception();

        if(user.getPassword().equals(userDB.getPassword()))
            return userDB;

        throw  new Exception();
    }




}
