package com.project.SIAP.security.service;


import com.project.SIAP.security.dto.UserDto;
import com.project.SIAP.security.entities.User;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}
