package com.example.todonotes.controllers;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.example.todonotes.models.request.LoginRequestModel;
import com.example.todonotes.models.response.LoginResponseModel;
import com.example.todonotes.services.infraestructure.abstraction.IAuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
@Api("Authentication logic")
public class AuthenticationController {

    @Autowired
    private final IAuthenticationService authenticationService;

    public AuthenticationController(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @ApiOperation("Log in an user credentials")
    @PostMapping("/authentication/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestModel loginRequestModel) throws Exception {
        final LoginResponseModel loginResponseModel = this.authenticationService.login(loginRequestModel.getUserName(), loginRequestModel.getPassword());

	    return ResponseEntity.ok(loginResponseModel);
	}

}
