package com.example.todonotes.models.response;

import java.io.Serializable;

public class LoginResponseModel implements Serializable {

    // ????
	private static final long serialVersionUID = -8091879091924046844L;

	private final String jwttoken;

	public LoginResponseModel(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
    
}
