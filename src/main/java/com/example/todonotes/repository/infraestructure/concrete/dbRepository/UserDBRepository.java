package com.example.todonotes.repository.infraestructure.concrete.dbRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.todonotes.repository.Entities.UserEntity;
import com.example.todonotes.repository.infraestructure.abstraction.IUserRepository;

import org.springframework.stereotype.Repository;

import lombok.extern.java.Log;

@Repository
@Log
public class UserDBRepository implements IUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDBRepository() {
        log.info("User DB repository running.");
    }

    @Override
    public UserEntity getUser(String userName) {
                
        UserEntity userEntity = (UserEntity)entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.userName = :userName")
                                    .setParameter("userName", userName)
                                    .getSingleResult();


        return userEntity;
    }


}
