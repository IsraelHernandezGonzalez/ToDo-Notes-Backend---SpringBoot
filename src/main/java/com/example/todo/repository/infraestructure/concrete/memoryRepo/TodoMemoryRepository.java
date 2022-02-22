package com.example.todo.repository.infraestructure.concrete.memoryRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.todo.repository.Entities.TodoEntity;
import com.example.todo.repository.infraestructure.abstraction.ITodoRepository;

import org.springframework.stereotype.Repository;

@Repository
public class TodoMemoryRepository implements ITodoRepository {
  
    private final Map<String, List<TodoEntity>> listUsersToDos;

    public TodoMemoryRepository() {

        listUsersToDos = new HashMap<String,List<TodoEntity>>();

        List<TodoEntity> listToDo =  new ArrayList<TodoEntity>(); 
        listToDo.add(new TodoEntity(1, "1", "Group1", "Test ToDo 1")); 
        listToDo.add(new TodoEntity(2, "2", "Group1", "Test ToDo 2")); 
        listToDo.add(new TodoEntity(3, "3", "Group2", "Test ToDo 3")); 
        listToDo.add(new TodoEntity(4, "2", "Group2", "Test ToDo 4")); 
        listToDo.add(new TodoEntity(5, "1", "Group3", "Test ToDo 5"));   

        listUsersToDos.put("demo", listToDo);
    }

    public List<TodoEntity> GetToDo(String user) {

        if (this.listUsersToDos.containsKey(user) == false) {
            return new ArrayList<TodoEntity>();
        }

        return this.listUsersToDos.get(user);
    }

    public boolean AddToDo(String user, TodoEntity todoEntity) {

        List<TodoEntity> listToDo = null;

        if (this.listUsersToDos.containsKey(user) == false) {
            listToDo = new ArrayList<TodoEntity>();
        } else {
            listToDo = this.listUsersToDos.get(user);
        }

        // Look for a new Id.
        int newId = 0;

        for (TodoEntity itemTodo : listToDo) {
            if (itemTodo.getId() > newId) {
                newId = itemTodo.getId() + 1;
            }
        }

        todoEntity.setId(newId);

        return listToDo.add(todoEntity);
    }
}
