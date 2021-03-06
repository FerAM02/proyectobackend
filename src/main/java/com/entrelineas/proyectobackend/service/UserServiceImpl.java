package com.entrelineas.proyectobackend.service;

import com.entrelineas.proyectobackend.entity.User;
import com.entrelineas.proyectobackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
    return userRepository.findByUsername(username);
    }


}
