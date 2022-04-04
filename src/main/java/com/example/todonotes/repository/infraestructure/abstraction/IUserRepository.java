package com.example.todonotes.repository.infraestructure.abstraction;

import com.example.todonotes.repository.Entities.UserEntity;

/**
 * Interface to be implemented by the repository class related with the users.
 */
public interface IUserRepository {
    
     /**
     * Get user data.
     * @param userName whose data will be fetched.
     * @return data of the user.
     */
    UserEntity getUser(String userName);

}
