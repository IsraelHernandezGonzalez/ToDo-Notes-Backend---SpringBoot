package com.example.todo.services.infraestructure.concrete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.models.request.AddTodoRequestModel;
import com.example.todo.models.response.TodoResponseModel;
import com.example.todo.repository.Entities.TodoEntity;
import com.example.todo.repository.infraestructure.abstraction.ITodoRepository;
import com.example.todo.services.infraestructure.abstraction.IToDoService;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ToDoService implements IToDoService {

    private final ITodoRepository todoRepository;

    @Autowired
    public ToDoService(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    
    public List<TodoResponseModel> GetToDoByUser(String user) {
        List<TodoResponseModel> listTodoResponseModel = new ArrayList<TodoResponseModel>();
        List<TodoEntity> listTodoEntity;

        listTodoEntity = todoRepository.GetToDo(user);

        for (TodoEntity todoEntity : listTodoEntity) {
            listTodoResponseModel.add(new TodoResponseModel(todoEntity.getId()
                , todoEntity.getPriority()
                , todoEntity.getGroup()
                , todoEntity.getToDoNote()));
        }
        
        return listTodoResponseModel;
    }

    public boolean AddTodo(String user, AddTodoRequestModel todoToAdd) {

        TodoEntity todoEntity = new TodoEntity(-1
            , todoToAdd.getPriority()
            , todoToAdd.getGroup()
            , todoToAdd.getNote());

        return todoRepository.AddToDo(user, todoEntity);
    }
}
