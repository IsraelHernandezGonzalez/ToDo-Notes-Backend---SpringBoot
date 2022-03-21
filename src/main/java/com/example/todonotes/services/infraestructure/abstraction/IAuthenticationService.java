package com.example.todonotes.services.infraestructure.abstraction;

import com.example.todonotes.models.response.LoginResponseModel;

/**
 * Interface associated with the management of user authentication.
 */
public interface IAuthenticationService {
    
    /**
     * Checks if an user is a valid user in the system.
     * @param user alias in the system.
     * @param password of the user in the system.
     * @return if the user and password are correct, an instance of LoginResponseModel with the response model is returned, otherwise null.
     */
    LoginResponseModel login(String userName, String password) throws Exception;
}
