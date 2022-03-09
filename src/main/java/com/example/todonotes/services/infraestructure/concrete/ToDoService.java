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

/**
 * Implementation of the login of management of ToDo notes exposed by IToDoService.
 */
@Service
public class ToDoService implements IToDoService {

    private final ITodoRepository todoRepository;

    @Autowired
    public ToDoService(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    
    @Override
    public List<TodoResponseModel> getToDoByUser(String user) {
        List<TodoResponseModel> listTodoResponseModel = new ArrayList<TodoResponseModel>();
        List<TodoEntity> listTodoEntity;

        listTodoEntity = todoRepository.getToDo(user);

        for (TodoEntity todoEntity : listTodoEntity) {
            listTodoResponseModel.add(new TodoResponseModel(todoEntity.getId()
                , todoEntity.getPriority()
                , todoEntity.getGroup()
                , todoEntity.getNote()));
        }
        
        return listTodoResponseModel;
    }

    @Override
    public boolean addTodo(String user, AddTodoRequestModel todoToAdd) {

        TodoEntity todoEntity = new TodoEntity(-1
            , todoToAdd.getPriority()
            , todoToAdd.getGroup()
            , todoToAdd.getNote());

        return todoRepository.addToDo(user, todoEntity);
    }

    @Override
    public boolean updateTodo(String user, UpdateTodoRequestModel todoToUpdate) {

        TodoEntity todoEntity = new TodoEntity(todoToUpdate.getId()
            , todoToUpdate.getPriority()
            , todoToUpdate.getGroup()
            , todoToUpdate.getNote());

        return todoRepository.updateTodo(user, todoEntity);
    }

    @Override
    public boolean deleteTodo(String user, int id) {       
        return todoRepository.deleteTodo(user, id);
    }
}
