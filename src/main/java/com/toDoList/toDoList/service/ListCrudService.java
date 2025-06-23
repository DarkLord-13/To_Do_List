package com.toDoList.toDoList.service;

import com.toDoList.toDoList.dto.ListDto;
import com.toDoList.toDoList.entity.ListItem;
import com.toDoList.toDoList.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListCrudService {

    @Autowired
    private ListRepository repo;

    public String addItem(String item){
        ListItem listItem = repo.save(new ListItem(item));

        return "New Task added: " + listItem.getId();
    }

    public String deleteItem(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);

            return "Task deleted successfully";
        }
        else{
            return "Task not found";
        }
    }

    public String updateTask(ListDto listDto){
        Long id = listDto.getId();

        if(repo.existsById(id)){
            ListItem item = repo.findById(id).orElseThrow();

            if(listDto.getTaskName() != null){
                item.setTaskName(listDto.getTaskName());
            }

            if(listDto.getTaskStatus() != null){
                item.setTaskStatus(listDto.getTaskStatus());
            }

            repo.save(item);

            return "Task updated successfully";
        }
        else{
            return "Task not found";
        }
    }

//    public String updateTaskStatus(Long id, String taskStatus){
//
//        Optional<ListItem> optionalListItem = repo.findById(id);
//        if(optionalListItem.isPresent()){
//            ListItem item = optionalListItem.get();
//            item.setTaskStatus(taskStatus);
//
//            return "Task status updated successfully";
//        }
//        else{
//            return "Task not found";
//        }
//    }
}
