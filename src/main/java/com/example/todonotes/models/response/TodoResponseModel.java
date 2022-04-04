package com.example.todonotes.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TodoResponseModel {

    private Long id;
    private String priority;
    private String group;
    private String note;

}
