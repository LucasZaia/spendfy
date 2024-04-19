package com.spendfy.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spendfy.api.models.User;
import com.spendfy.api.services.UserService;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/list")
    public ResponseEntity List(){
       return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping(value = "/add")
    public ResponseEntity Create(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok().body("Cadastro efetuado com sucesso!!");
    }
}
