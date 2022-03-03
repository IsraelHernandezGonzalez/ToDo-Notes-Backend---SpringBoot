package com.example.todo.services.infraestructure.abstraction;

/**
 * Interface associated with the management of user authentication.
 */
public interface IAuthenticationervice {
    
    /**
     * Checks if an user is a valid user in the system.
     * @param user
     * @param password
     * @return true, the user exists in the suystem and his/her password is correct, otherwise, false is returned.
     */
    boolean login(String user, String password);
}
