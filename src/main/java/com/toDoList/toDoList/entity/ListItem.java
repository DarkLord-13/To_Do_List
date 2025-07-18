package com.toDoList.toDoList.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "list_items", schema = "todo")
public class ListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto generated
    private Long id;

    @Column(name = "task_description", nullable = false) // user input
    private String taskName;

    @Column(name = "task_status", nullable = false) // by-default as "in-progress"
    private String taskStatus = "in-progress";

    @Column(name = "task_created_at", nullable = false, updatable = false)
    private String taskCreatedAt = java.time.LocalDateTime.now().toString();

    @Column(name = "task_updated_at", nullable = false)
    private String taskUpdatedAt = java.time.LocalDateTime.now().toString();

    public ListItem(String taskName){
        this.taskName = taskName;
    }
}
