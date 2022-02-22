package com.example.todo.services.infraestructure.abstraction;

import java.util.List;

import com.example.todo.models.request.AddTodoRequestModel;
import com.example.todo.models.response.TodoResponseModel;

public interface IToDoService {

    /**
     * Gets the list of ToDo notes of an user.
     * @param user
     * @return List of ToDo notes of the specified user.
     */
    List<TodoResponseModel> GetToDoByUser(String user);

    /**
     * Adds a ToDo note to the group of ones of an user.
     * @param user
     * @param todoToAdd ToDo to be added.
     * @return true, if ToDo was added correctly, otherwise, false is returned.
     */
    boolean AddTodo(String user, AddTodoRequestModel todoToAdd);
    
}
