package com.example.todonotes.models.request;

import io.swagger.annotations.ApiModel;

@ApiModel("Login parameters")
public class LoginRequestModel {
    private String userName;
    private String password;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
