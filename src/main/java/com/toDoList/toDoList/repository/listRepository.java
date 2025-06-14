package com.toDoList.toDoList.repository;

import com.toDoList.toDoList.entity.listItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface listRepository extends JpaRepository<listItem, Long>{

    List<listItem> findByTaskStatus(String status);
}
