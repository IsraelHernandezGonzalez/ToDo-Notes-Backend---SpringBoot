package com.example.todonotes.repository.infraestructure.abstraction;

import java.util.List;

import com.example.todonotes.repository.Entities.TodoEntity;

/**
 * Interface to be implemented by the repository class related with the ToDo notes.
 */
public interface ITodoRepository {

    /**
     * Gets the list of ToDo note of an user.
     * @param user whose list of ToDo notes is going to fetch.
     * @return List of ToDo notes of the specified user.
     */
    List<TodoEntity> getToDo(String user);

    /**
     * Adds a ToDo note of an user.
     * @param todoEntity
     * @return true, if ToDo was added correctly, otherwise, false is returned.
     */
    boolean addToDo(TodoEntity todoEntityAdd);
    
    /**
     * Updates a ToDo note.
     * @param todoToUpdate
     * @return true, if the ToDo was updated correctly, otherwise, false is returned.
     */
    boolean updateTodo(TodoEntity todoToUpdate);

    /**
     * Deletes a ToDo note.
     * @param id identifier of ToDo note to remove.
     * @return true, if the ToDo note was deleted correctly, otherwise, false is returned.
     */
    boolean deleteTodo(Long id);

}
