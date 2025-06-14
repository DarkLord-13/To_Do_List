package com.toDoList.toDoList.service;

import com.toDoList.toDoList.entity.ListItem;
import com.toDoList.toDoList.repository.ListRepository;
import org.springframework.stereotype.Service;

@Service
public class ListOperations {
    private ListRepository repo;

    public String addItem(String item){
        ListItem listItem = repo.save(new ListItem(item));

        return "New item added: " + listItem.getId();
    }

    public String deleteItem(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Item deleted successfully";
        }
        else{
            return "Item not found";
        }
    }

    public String updateItem(Long id, String newItem) throws Exception{
        if(repo.existsById(id)){
            ListItem item = repo.findById(id).orElseThrow();
            item.setTaskName(newItem);
            repo.save(item);
            return "Item updated successfully";
        }
        else{
            return "Item not found";
        }
    }
}
