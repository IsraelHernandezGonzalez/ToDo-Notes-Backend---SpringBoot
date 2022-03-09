package com.example.todonotes.models.request;

public class AddTodoRequestModel {
    private String priority;
    private String group;
    private String note;

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

    public AddTodoRequestModel(String priority, String group, String note) {        
        this.priority = priority;
        this.group = group;
        this.note = note;
    }
}
