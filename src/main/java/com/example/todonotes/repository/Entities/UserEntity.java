package com.example.todonotes.repository.Entities;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "todo_users")
public class UserEntity {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id")
    private Long userId;
    
    @NotNull
	@Column(name = "user_name", unique = true)
    private String userName;

    @NotNull
    @Column(name = "user_password")
    private String password;

}
