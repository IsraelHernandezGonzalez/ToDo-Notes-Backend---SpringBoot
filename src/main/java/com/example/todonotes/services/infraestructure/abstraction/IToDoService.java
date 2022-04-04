package com.example.todonotes.services.infraestructure.abstraction;

import java.util.List;

import com.example.todonotes.models.request.AddTodoRequestModel;
import com.example.todonotes.models.request.UpdateTodoRequestModel;
import com.example.todonotes.models.response.TodoResponseModel;

/**
 * Interface associated with the management of ToDo notes.
 */
public interface IToDoService {

    /**
     * Gets the list of ToDo notes of an user.
     * @param user
     * @return List of ToDo notes of the specified user.
     */
    List<TodoResponseModel> getToDoByUser(String user);

    /**
     * Adds a ToDo note to the group of ones of an user.
     * @param todoToAdd ToDo note to add to the repository.
     * @return true, if the ToDo was added correctly, otherwise, false is returned.
     */
    boolean addTodo(String user, AddTodoRequestModel todoToAdd);

    /**
     * Updates a ToDo note.     
     * @param todoToUpdate ToDo note instance to update in repository.
     * @return true, if the ToDo was updated correctly, otherwise, false is returned.
     */
    boolean updateTodo(String user, UpdateTodoRequestModel todoToUpdate);

    /**
     * Deletes a ToDo note.     
     * @param id identifiar of ToDo note to remove.
     * @return true, if the ToDo note was deleted correctly, otherwise, false is returned.
     */
    boolean deleteTodo(String user, Long id);
    
}
