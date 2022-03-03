package com.example.todo.repository.Entities;

public class TodoEntity {
    private int id;
    private String priority;
    private String group;
    private String note;

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

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }    

    public TodoEntity(int id, String priority, String group, String note) {
        this.setId(id);
        this.setPriority(priority);
        this.setGroup(group);
        this.setNote(note);
    }
}
