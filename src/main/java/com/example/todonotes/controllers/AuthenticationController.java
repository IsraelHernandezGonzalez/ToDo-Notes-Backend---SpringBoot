package com.example.todonotes.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.todonotes.models.request.LoginRequestModel;
import com.example.todonotes.models.response.LoginResponseModel;
import com.example.todonotes.services.infraestructure.abstraction.IAuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthenticationController {

    @Autowired
    private final IAuthenticationService authenticationService;

    public AuthenticationController(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authentication/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestModel loginRequestModel) throws Exception {
        final LoginResponseModel loginResponseModel = this.authenticationService.login(loginRequestModel.getUserName(), loginRequestModel.getPassword());

	    return ResponseEntity.ok(loginResponseModel);
	}
    
}
