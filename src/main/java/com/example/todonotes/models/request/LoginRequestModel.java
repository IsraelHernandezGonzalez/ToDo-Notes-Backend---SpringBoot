package com.example.todonotes.models.request;

public class LoginRequestModel {
    private String user;
    private String password;


    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}