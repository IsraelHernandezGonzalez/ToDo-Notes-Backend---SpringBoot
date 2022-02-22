package com.example.todo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AuthenticationController {

    @GetMapping("/Authentication/Login")
	public boolean login(@RequestParam(value = "user", defaultValue = "") String user
        , @RequestParam(value = "password", defaultValue = "") String password) {
		        
        if (user.equals("demo") && password.equals("demo")) {
            return true;
        }

        return false;
	}
    
}
