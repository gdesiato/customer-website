package com.example.customerwebsite.controller;

import com.example.customerwebsite.model.Customer;
import com.example.customerwebsite.model.User;
import com.example.customerwebsite.repositories.CustomerRepository;
import com.example.customerwebsite.services.CustomerService;
import com.example.customerwebsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


@Controller
public class UserController implements ErrorController {

    @Autowired
    UserService userService;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/users")
    public User getUser(Authentication authentication) {
        return (User) authentication.getPrincipal();
    }

    @PostMapping("/users")
    public ResponseEntity<?> createNewUser(@RequestBody User userDetails) {
        try {
            return ResponseEntity.ok(userService.createNewUser(userDetails));
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/user-dashboard")
    public String showUserDashboard(Model model, String username) {
        User user = userService.getUser(username);
        model.addAttribute("user", user);
        return "user-dashboard";
    }

}
