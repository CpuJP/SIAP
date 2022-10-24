package com.project.SIAP.security.service;


import com.project.SIAP.security.entities.Role;

public interface RoleService {
    Role findByName(String name);
}
