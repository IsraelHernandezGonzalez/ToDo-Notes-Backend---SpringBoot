package com.example.todonotes.services.infraestructure.concrete;

import java.util.ArrayList;
import java.util.List;

import com.example.todonotes.models.request.AddTodoRequestModel;
import com.example.todonotes.models.request.UpdateTodoRequestModel;
import com.example.todonotes.models.response.TodoResponseModel;
import com.example.todonotes.repository.Entities.TodoEntity;
import com.example.todonotes.repository.infraestructure.abstraction.ITodoRepository;
import com.example.todonotes.services.infraestructure.abstraction.IToDoService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ToDoService implements IToDoService {

    private final ITodoRepository todoRepository;

    @Autowired
    public ToDoService(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    
    @Override
    public List<TodoResponseModel> GetToDoByUser(String user) {
        List<TodoResponseModel> listTodoResponseModel = new ArrayList<TodoResponseModel>();
        List<TodoEntity> listTodoEntity;

        listTodoEntity = todoRepository.GetToDo(user);

        for (TodoEntity todoEntity : listTodoEntity) {
            listTodoResponseModel.add(new TodoResponseModel(todoEntity.getId()
                , todoEntity.getPriority()
                , todoEntity.getGroup()
                , todoEntity.getNote()));
        }
        
        return listTodoResponseModel;
    }

    @Override
    public boolean AddTodo(String user, AddTodoRequestModel todoToAdd) {

        TodoEntity todoEntity = new TodoEntity(-1
            , todoToAdd.getPriority()
            , todoToAdd.getGroup()
            , todoToAdd.getNote());

        return todoRepository.AddToDo(user, todoEntity);
    }

    @Override
    public boolean UpdateTodo(String user, UpdateTodoRequestModel todoToUpdate) {

        TodoEntity todoEntity = new TodoEntity(todoToUpdate.getId()
            , todoToUpdate.getPriority()
            , todoToUpdate.getGroup()
            , todoToUpdate.getNote());

        return todoRepository.UpdateTodo(user, todoEntity);
    }

    @Override
    public boolean DeleteTodo(String user, int id) {       
        return todoRepository.DeleteTodo(user, id);
    }
}
