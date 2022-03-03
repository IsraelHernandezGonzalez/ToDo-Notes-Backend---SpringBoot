package com.example.todo.repository.infraestructure.abstraction;

import java.util.List;

import com.example.todo.repository.Entities.TodoEntity;

/**
 * Interface to be implemented by the repository class related with the ToDo notes.
 */
public interface ITodoRepository {

    /**
     * Gets the list of ToDo note of an user.
     * @param user
     * @return List of ToDo notes of the specified user.
     */
    List<TodoEntity> GetToDo(String user);

    /**
     * Adds a ToDo note of an user.
     * @param user
     * @param todoEntity
     * @return true, if ToDo was added correctly, otherwise, false is returned.
     */
    boolean AddToDo(String user, TodoEntity todoEntityAdd);
    
    /**
     * Updates a ToDo note.
     * @param user
     * @param todoToUpdate
     * @return true, if the ToDo was updated correctly, otherwise, false is returned.
     */
    boolean UpdateTodo(String user, TodoEntity todoToUpdate);

    /**
     * Deletes a ToDo note.
     * @param user
     * @param id
     * @return true, if the ToDo note was deleted correctly, otherwise, false is returned.
     */
    boolean DeleteTodo(String user, int id);

}
