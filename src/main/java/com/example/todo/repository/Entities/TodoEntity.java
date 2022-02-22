package com.example.todo.repository.Entities;

public class TodoEntity {
    private int id;
    private String priority;
    private String group;
    private String todoNote;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getToDoNote() {
        return this.todoNote;
    }

    public void setToDoNote(String todoNote) {
        this.todoNote = todoNote;
    }    

    public TodoEntity(int id, String priority, String group, String todoNote) {
        this.id = id;
        this.priority = priority;
        this.group = group;
        this.todoNote = todoNote;
    }
}
