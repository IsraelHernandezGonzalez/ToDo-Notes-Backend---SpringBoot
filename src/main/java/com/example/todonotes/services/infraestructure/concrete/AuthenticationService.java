package com.example.todonotes.services.infraestructure.concrete;

import com.example.todonotes.services.infraestructure.abstraction.IAuthenticationService;

import org.springframework.stereotype.Service;

/**
 * Implementation of the logic for the control of user authentication exposed by IAuthenticationService.
 */
@Service
public class AuthenticationService implements IAuthenticationService {

    @Override
    public boolean login(String user, String password) {

        if (user.equals("demo") && password.equals("demo")) {
            return true;
        }

        return false;
    }
    
}
