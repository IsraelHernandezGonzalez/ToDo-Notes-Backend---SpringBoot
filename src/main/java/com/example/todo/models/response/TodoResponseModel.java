package com.example.todo.models.response;

public class TodoResponseModel {
    private int id;
    private String priority;
    private String group;
    private String todoNode;

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

    public String getTodoNote() {
        return this.todoNode;
    }

    public void setTodoNote(String todoNode) {
        this.todoNode = todoNode;
    }

    public TodoResponseModel(int id, String priority, String group, String todoNote) {
        this.id = id;
        this.priority = priority;
        this.group = group;
        this.todoNode = todoNote;
    }
}
