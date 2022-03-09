package com.example.todonotes.services.infraestructure.abstraction;

/**
 * Interface associated with the management of user authentication.
 */
public interface IAuthenticationervice {
    
    /**
     * Checks if an user is a valid user in the system.
     * @param user alias in the system.
     * @param password of the user in the system.
     * @return true, the user exists in the suystem and his/her password is correct, otherwise, false is returned.
     */
    boolean login(String user, String password);
}
