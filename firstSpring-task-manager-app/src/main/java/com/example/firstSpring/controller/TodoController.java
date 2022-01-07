package com.example.firstSpring.controller;

import com.example.firstSpring.entity.TodoEntity;
import com.example.firstSpring.repository.TodoRepo;
import com.example.firstSpring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;

@RestController
@RequestMapping("/todos")
public class TodoController extends BaseController {
    @Autowired
    private TodoService _todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo, @RequestParam Long userId) {
        try {
           return ResponseEntity.ok(_todoService.createTodo(todo, userId));
        }

        catch (Exception e) {
          return returnBadRequestWithBody(e);
        }
    }


    @PostUpdate
    public ResponseEntity changeTodoCompleteStatus(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(_todoService.changeTodoCompleted(id));
        }

        catch (Exception e) {
           return returnBadRequestWithBody(e);
        }
    }
}
