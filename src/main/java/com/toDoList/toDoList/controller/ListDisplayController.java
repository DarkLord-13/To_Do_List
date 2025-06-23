package com.toDoList.toDoList.controller;

import com.toDoList.toDoList.dto.ListDto;
import com.toDoList.toDoList.service.ListDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("task/display")
public class ListDisplayController {

    @Autowired
    ListDisplayService listDisplayService;

    @GetMapping
    public ResponseEntity<List<ListDto>> displayAllLTasks(){
        return new ResponseEntity<>(listDisplayService.displayAllLTasks(), HttpStatus.OK);
    }

    @GetMapping("{taskStatus}")
    public ResponseEntity<List<ListDto>> displayStatusSpecificTasks(@PathVariable("taskStatus") String taskStatus){
        return new ResponseEntity<>(listDisplayService.displayStatusSpecificTasks(taskStatus), HttpStatus.OK);
    }
}
