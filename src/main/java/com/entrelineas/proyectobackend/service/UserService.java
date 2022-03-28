package com.entrelineas.proyectobackend.service;

import com.entrelineas.proyectobackend.entity.User;

public interface UserService {

    User save(User user);

    User findByUsername(String username);
}
