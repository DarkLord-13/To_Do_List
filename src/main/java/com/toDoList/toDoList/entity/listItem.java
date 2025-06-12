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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "task_completed", nullable = false, columnDefinition = "boolean default false")
    private boolean taskCompleted;

    public listItem(String taskName){
        this.taskName = taskName;
        this.taskCompleted = false;
    }
}
