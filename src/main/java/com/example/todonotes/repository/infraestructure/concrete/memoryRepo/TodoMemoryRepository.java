package com.example.todonotes.repository.infraestructure.concrete.memoryRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.function.Predicate;

import com.example.todonotes.repository.Entities.TodoEntity;
import com.example.todonotes.repository.infraestructure.abstraction.ITodoRepository;

import lombok.extern.java.Log;

/**
 * Implementation of the login associated with the ToDo notes repository in memory.
 */
// @Repository
@Log
public class TodoMemoryRepository implements ITodoRepository {
  
    private final Map<String, List<TodoEntity>> listUsersToDos;

    public TodoMemoryRepository() {

        listUsersToDos = new HashMap<String,List<TodoEntity>>();

        List<TodoEntity> listToDo =  new ArrayList<TodoEntity>(); 
        listToDo.add(new TodoEntity(1L, "1", "Group1", "Test ToDo 1")); 
        listToDo.add(new TodoEntity(2L, "2", "Group1", "Test ToDo 2")); 
        listToDo.add(new TodoEntity(3L, "3", "Group2", "Test ToDo 3")); 
        listToDo.add(new TodoEntity(4L, "2", "Group2", "Test ToDo 4")); 
        listToDo.add(new TodoEntity(5L, "1", "Group3", "Test ToDo 5"));   

        listUsersToDos.put("demo", listToDo);

        log.info("ToDo memory repository running.");
        
    }

    public List<TodoEntity> getToDo(String user) {

        if (this.listUsersToDos.containsKey(user) == false) {
            return new ArrayList<TodoEntity>();
        }

        return this.listUsersToDos.get(user);
    }

    public boolean addToDo(TodoEntity todoEntity) {

        List<TodoEntity> listToDo = null;

        for (String key : listUsersToDos.keySet()) {

            listToDo = listUsersToDos.get(key);

            for (TodoEntity itemTodoEntity : listToDo) {

                if (itemTodoEntity.getUser().getUserId() == todoEntity.getUser().getUserId()) {                    
                    
                    // Look for a new Id.
                    Long newId = 0L;

                    for (TodoEntity itemTodo : listToDo) {
                        if (itemTodo.getId() >= newId) {
                            newId = itemTodo.getId() + 1;
                        }
                    }

                    todoEntity.setId(newId);

                    return listToDo.add(todoEntity);
                }
            }
        }       

        return false;
    }

    @Override
    public boolean updateTodo(TodoEntity todoToUpdate) {
        
        List<TodoEntity> listToDo;

        for (String key : listUsersToDos.keySet()) {

            listToDo = listUsersToDos.get(key);

            for (TodoEntity todoEntity : listToDo) {

                if (todoEntity.getId() == todoToUpdate.getId()) {
                    todoEntity.setPriority(todoToUpdate.getPriority());
                    todoEntity.setGroup(todoToUpdate.getGroup());
                    todoEntity.setNote(todoToUpdate.getNote());
                    return true;
                }
            }

        }       

        return false;
    }

    @Override
    public boolean deleteTodo(Long id) {
        
        List<TodoEntity> listToDo;

        for (String key : listUsersToDos.keySet()) {

            listToDo = listUsersToDos.get(key);

            for (TodoEntity todoEntity : listToDo) {

                if (todoEntity.getId() == id) {
                    listToDo.remove(todoEntity);
                    return true;
                }
            }

        }

        // Predicate<TodoEntity> filter = item -> item.getId() == id;
        // return listToDo.removeIf(filter);

        return false;
    }
}
