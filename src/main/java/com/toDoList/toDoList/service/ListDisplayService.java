package com.toDoList.toDoList.service;

import com.toDoList.toDoList.dto.ListDto;
import com.toDoList.toDoList.entity.ListItem;
import com.toDoList.toDoList.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListDisplayService {

    @Autowired
    ListRepository repo;

    public List<ListDto> displayAllLTasks(){
        List<ListItem> allTasks = repo.findAll();
        List<ListDto> allMappedTasks = new ArrayList<>();

        for(ListItem item: allTasks){
            allMappedTasks.add(new ListDto(item.getId(), item.getTaskName(), item.getTaskStatus()));
        }

        return allMappedTasks;
    }

    public List<ListDto> displayStatusSpecificTasks(String taskStatus){
        List<ListItem> allTasks = repo.findByTaskStatus(taskStatus);
        List<ListDto> allMappedTasks = new ArrayList<>();

        for(ListItem item: allTasks){
            allMappedTasks.add(new ListDto(item.getId(), item.getTaskName(), item.getTaskStatus()));
        }

        return allMappedTasks;
    }
}
