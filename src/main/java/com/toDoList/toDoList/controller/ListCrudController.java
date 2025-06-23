package com.toDoList.toDoList.controller;


import com.toDoList.toDoList.dto.ListDto;
import com.toDoList.toDoList.service.ListCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class ListCrudController {

    @Autowired
    ListCrudService listCrudService;

    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody String newTask){
        return new ResponseEntity<>(listCrudService.addItem(newTask), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateTask(@RequestBody ListDto listDto){

        return new ResponseEntity<>(listCrudService.updateTask(listDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long deleteId){
        return new ResponseEntity<>(listCrudService.deleteItem(deleteId), HttpStatus.OK);
    }


}
