package com.example.todo.services.infraestructure.concrete;

import com.example.todo.services.infraestructure.abstraction.IAuthenticationervice;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationervice {

    @Override
    public boolean login(String user, String password) {

        if (user.equals("demo") && password.equals("demo")) {
            return true;
        }

        return false;
    }
    
}
