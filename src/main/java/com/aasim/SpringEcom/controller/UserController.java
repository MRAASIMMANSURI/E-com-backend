package com.aasim.SpringEcom.controller;

import com.aasim.SpringEcom.model.User;
import com.aasim.SpringEcom.service.JwtService;
import com.aasim.SpringEcom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/")
public class UserController {

    @Autowired
     private UserService service;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @PostMapping("/register")
    public User register(@RequestBody User user){

        return service.savaUser(user);
    }
    @GetMapping("/getUser")
    public List<User> getAllUser(){
        return  service.getAllUser();
    }
    @PostMapping("/login")
    public String login(@RequestBody User user){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        else
            return "Login Failed";
    }
}
