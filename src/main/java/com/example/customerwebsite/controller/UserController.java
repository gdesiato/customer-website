package com.example.customerwebsite.controller;

import com.example.customerwebsite.model.User;
import com.example.customerwebsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public User getUser(Authentication authentication) {
        return (User) authentication.getPrincipal();
    }

    @GetMapping("/register")
    public String showRegistrationForm(WebRequest webRequest, Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    // Create the POST /register method. In this method,
    // you will take in a user object then utilize your UserService to verify and persist it
    // (with an encoded password!) to the database.
    @PostMapping("/register")
    public String registerUserAccount(){

        return "";
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
}
