package com.project.SIAP.security.repository;

import com.project.SIAP.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    User findByUsername(String username);
    boolean existsByEmail(String email);
}