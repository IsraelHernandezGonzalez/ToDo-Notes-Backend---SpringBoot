package com.example.todo.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.todo.models.request.AddTodoRequestModel;
import com.example.todo.models.response.TodoResponseModel;
import com.example.todo.services.infraestructure.abstraction.IToDoService;
import com.example.todo.services.infraestructure.concrete.ToDoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
}