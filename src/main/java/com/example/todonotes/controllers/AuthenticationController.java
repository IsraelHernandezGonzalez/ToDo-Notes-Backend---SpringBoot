package com.example.todonotes.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.todonotes.models.request.LoginRequestModel;
import com.example.todonotes.services.infraestructure.abstraction.IAuthenticationervice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthenticationController {

    @Autowired
    private final IAuthenticationervice authenticationService;

    public AuthenticationController(IAuthenticationervice authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/Authentication/Login")
	public boolean login(@RequestBody LoginRequestModel loginModel) {
	    return this.authenticationService.login(loginModel.getUser(), loginModel.getPassword());
	}
    
}