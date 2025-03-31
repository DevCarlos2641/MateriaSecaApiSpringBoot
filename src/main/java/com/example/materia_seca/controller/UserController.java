package com.example.materia_seca.controller;

import com.example.materia_seca.model.RequestUser;
import com.example.materia_seca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<?> getUser(@RequestBody RequestUser user){
        return service.verifiedUser(user);
    }

    @GetMapping
    public ResponseEntity<?> user(){
        return ResponseEntity.ok("Pass the user");
    }

    @GetMapping("/other")
    public ResponseEntity<?> userOther(){
        return ResponseEntity.ok("Security");
    }
}
