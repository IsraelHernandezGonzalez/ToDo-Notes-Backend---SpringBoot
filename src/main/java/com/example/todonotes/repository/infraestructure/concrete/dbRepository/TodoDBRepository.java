package com.example.todonotes.repository.infraestructure.concrete.dbRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.todonotes.repository.Entities.TodoEntity;
import com.example.todonotes.repository.Entities.UserEntity;
import com.example.todonotes.repository.infraestructure.abstraction.ITodoRepository;
import com.example.todonotes.repository.infraestructure.abstraction.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.java.Log;

@Repository
@Log
public class TodoDBRepository implements ITodoRepository  {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private IUserRepository userRepository;


    public TodoDBRepository() {
        log.info("Todo DB repository running.");
    }

    private Long getUserId(String userName) {

        UserEntity userEntity = userRepository.getUser(userName);

        return userEntity.getUserId();
    }

    @Override
    public List<TodoEntity> getToDo(String userName) {

        Long userId = getUserId(userName);
        List<TodoEntity> list = (List<TodoEntity>) entityManager.createQuery("SELECT n FROM TodoEntity n WHERE n.user.userId = :userId", TodoEntity.class)
                                    .setParameter("userId", userId)
                                    .getResultList();                                   

        return list;
    }

    @Override
    public boolean addToDo(TodoEntity todoEntityAdd) {

        entityManager.persist(todoEntityAdd);

        return true;
    }

    @Override
    public boolean updateTodo(TodoEntity todoToUpdate) {
        
        
        entityManager.persist(todoToUpdate);

        return true;
    }

    @Override
    public boolean deleteTodo(Long id) {

        TodoEntity todoEntity = entityManager.find(TodoEntity.class, id);

        entityManager.remove(todoEntity);
        
        // entityManager.createQuery("DELETE FROM TodoNotes n WHERE n.id = :id")
        //     .setParameter("id", id)
        //     .executeUpdate();                                    

        return true;
    }
    
}
