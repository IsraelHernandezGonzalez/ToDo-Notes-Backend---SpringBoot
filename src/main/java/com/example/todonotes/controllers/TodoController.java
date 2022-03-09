package com.example.todonotes.controllers;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.logging.Logger;

import com.example.todonotes.models.request.AddTodoRequestModel;
import com.example.todonotes.models.request.UpdateTodoRequestModel;
import com.example.todonotes.models.response.TodoResponseModel;
import com.example.todonotes.services.infraestructure.abstraction.IToDoService;
import com.example.todonotes.services.infraestructure.concrete.ToDoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TodoController {
    
    private final IToDoService todoService;

    @Autowired    
    public TodoController(ToDoService todoService) {
        this.todoService = todoService;
    }
  
    @GetMapping("/ToDo/{user}")
	public List<TodoResponseModel> getTodoList(@PathVariable String user) {
       return todoService.GetToDoByUser(user);
	}    

    @PostMapping("/ToDo/{user}")
    public boolean addTodo(@PathVariable String user, @RequestBody AddTodoRequestModel todoToAdd) {    
        return todoService.AddTodo(user, todoToAdd);
    }

    @DeleteMapping("/ToDo/{user}/{id}")
    public boolean deleteTodo(@PathVariable String user, @PathVariable int id) {    

        Logger.getLogger(TodoController.class.getName()).info("deleteTodo(" + Integer.toString(id) + ")");
        
        return todoService.DeleteTodo(user, id);
    }

    @PutMapping("/ToDo/{user}")
    public boolean updateTodo(@PathVariable String user, @RequestBody UpdateTodoRequestModel todoToUpdate) {

        Logger.getLogger(TodoController.class.getName()).info("updateTodo(...)");
        
        return todoService.UpdateTodo(user, todoToUpdate);

    }
}