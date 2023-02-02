package com.example.customerwebsite.repositories;

import com.example.customerwebsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}