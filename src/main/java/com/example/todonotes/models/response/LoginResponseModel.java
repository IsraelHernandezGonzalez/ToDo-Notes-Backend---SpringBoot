package com.example.todonotes.models.response;

import java.io.Serializable;

public class LoginResponseModel implements Serializable {

	private final String userName;
	private final String jwttoken;

	public LoginResponseModel(String userName, String jwttoken) {
		this.userName = userName;
		this.jwttoken = jwttoken;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getToken() {
		return this.jwttoken;
	}
    
}
