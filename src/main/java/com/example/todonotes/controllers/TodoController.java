package com.example.todonotes.controllers;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.logging.Logger;

import com.example.todonotes.models.request.AddTodoRequestModel;
import com.example.todonotes.models.request.UpdateTodoRequestModel;
import com.example.todonotes.models.response.TodoResponseModel;
import com.example.todonotes.services.infraestructure.abstraction.IToDoService;
import com.example.todonotes.services.infraestructure.concrete.ToDoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Api("ToDo Notes CRUD")
public class TodoController {
    
    private final IToDoService todoService;
    private final Logger logger =  Logger.getLogger(TodoController.class.getName());

    private String getCurrentUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }


    @Autowired    
    public TodoController(ToDoService todoService) {
        this.todoService = todoService;
    }
  
    @ApiOperation(value = "Get user's ToDo Notes")
    @GetMapping("/ToDo")
	public List<TodoResponseModel> getTodoList() {

        String userName = getCurrentUserName();

        return todoService.getToDoByUser(userName);
	}    

    @PostMapping("/ToDo")
    public boolean addTodo(@RequestBody AddTodoRequestModel todoToAdd) {    

        String userName = getCurrentUserName();

        return todoService.addTodo(userName, todoToAdd);
    }

    @DeleteMapping("/ToDo/{id}")
    public boolean deleteTodo(@PathVariable Long id) {    
        
        logger.info("deleteTodo(" + Long.toString(id) + ")");
        
        String userName = getCurrentUserName();
        
        return todoService.deleteTodo(userName, id);
    }

    @PutMapping("/ToDo")
    public boolean updateTodo(@RequestBody UpdateTodoRequestModel todoToUpdate) {

        logger.info("updateTodo(...)");
        
        String userName = getCurrentUserName();

        return todoService.updateTodo(userName, todoToUpdate);

    }
}