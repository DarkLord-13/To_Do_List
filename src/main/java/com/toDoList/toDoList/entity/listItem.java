package com.toDoList.toDoList.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "list_items", schema = "todo")
public class listItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto generated
    private Long id;

    @Column(name = "task_description", nullable = false) // user input
    private String taskName;

    @Column(name = "task_status", nullable = false) // by-default as "todo"
    private String taskStatus = "todo";

    @Column(name = "task_created_at", nullable = false)
    private String taskCreatedAt = java.time.LocalDateTime.now().toString();

    @Column(name = "task_updated_at", nullable = false)
    private String taskUpdatedAt = java.time.LocalDateTime.now().toString();

    public listItem(String taskName){
        this.taskName = taskName;
    }
}
