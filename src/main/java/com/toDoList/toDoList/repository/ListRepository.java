package com.toDoList.toDoList.repository;

import com.toDoList.toDoList.entity.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ListRepository extends JpaRepository<ListItem, Long>{

    List<ListItem> findByTaskStatus(String status);
}
