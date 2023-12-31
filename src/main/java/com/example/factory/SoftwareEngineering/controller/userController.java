package com.example.factory.SoftwareEngineering.controller;

import com.example.factory.SoftwareEngineering.entity.userDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.factory.SoftwareEngineering.services.userService;
import com.example.factory.SoftwareEngineering.repository.userRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:8081/")

public class userController {
    private userService userService;

    @Autowired
    private userRepository userRepository;
    @Autowired
    public void userController(userService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody userDetails request) {
        userDetails user = userRepository.findByUsername(request.getUsername());
        if(user == null){
            return ResponseEntity.ok(userService.createUser(request.getFirstname(), request.getLastname(), request.getUsername(), request.getPasswordHash()));
        }else{
            return ResponseEntity.badRequest().body("Username already taken");
        }
    }

    @GetMapping("/getUsers")
    public List<userDetails> loginUser(){
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody userDetails request){
        userDetails user = userRepository.findByUsernameAndPasswordHash(request.getUsername(),
                userService.hashString(request.getPasswordHash()));
        if(user != null){
            return ResponseEntity.ok("Authorization Successful " + user.getUserId());
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }
}
