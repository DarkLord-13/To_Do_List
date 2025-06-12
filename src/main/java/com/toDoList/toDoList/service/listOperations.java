package com.toDoList.toDoList.service;

import com.toDoList.toDoList.entity.listItem;
import com.toDoList.toDoList.repository.listRepository;
import org.springframework.stereotype.Service;

@Service
public class listOperations{
    private listRepository repo;

    public String addItem(String item){
        listItem listItem = repo.save(new listItem(item));

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
            listItem item = repo.findById(id).orElseThrow();
            item.setTaskName(newItem);
            repo.save(item);
            return "Item updated successfully";
        }
        else{
            return "Item not found";
        }
    }

    
}
