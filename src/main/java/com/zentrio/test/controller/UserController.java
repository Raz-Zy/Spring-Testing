package com.zentrio.test.controller;


import com.zentrio.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/test")
@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    @Operation(summary="connect with user table")
    public String test(){
        return "Hello, " + userRepository.getUserName();
    }

    @GetMapping
    @Operation(summary="string only")
    public String hello(){
        return "Hello, Hi bye bye";
    }
}
