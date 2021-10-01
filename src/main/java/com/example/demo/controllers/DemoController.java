package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    List<User> getUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(element -> users.add(element));
        users.forEach(element-> System.out.println(element.getTel()));
        return users;
    }

    @GetMapping("/user/{name}")
    ResponseEntity<User> getUser(@PathVariable String name){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(element -> users.add(element));
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getName().equals(name)){
                return ResponseEntity.ok(users.get(i));
            }
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user")
    String createUser(@RequestBody User user){
        userRepository.save(user);
        return "ok";
    }


}
