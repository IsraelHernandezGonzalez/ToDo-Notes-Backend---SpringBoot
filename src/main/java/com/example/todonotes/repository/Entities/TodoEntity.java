package com.example.todonotes.repository.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "todo_notes")
public class TodoEntity {
      
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "todo_id")
    private Long id;
        
    @ManyToOne
	@JoinColumn(name="user_id")
    private UserEntity user;

    @NotNull
	@Column(name = "todo_priority")
    private String priority;
    
    @NotNull
	@Column(name = "todo_group")    
    private String group;

    @NotNull
	@Column(name = "todo_note")    
    private String note;

    public TodoEntity(Long id, String priority, String group, String note) {
        this.setId(id);
        this.setPriority(priority);
        this.setGroup(group);
        this.setNote(note);
    }

}
