package com.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.entity.User;
import com.userservice.repository.UserRepository;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/{id}")
    public ResponseEntity<User> getUser (@PathVariable long id) {
        return userRepository.findById(id)
        		.map(user -> ResponseEntity.ok().body(user))
        		.orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
    	return userRepository.save(user);
    }
	
}
