package com.example.todonotes.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateTodoRequestModel {

    private Long id;    
    private String priority;
    private String group;
    private String note;
    
}
