package com.example.firstSpring.service;

import com.example.firstSpring.entity.TodoEntity;
import com.example.firstSpring.entity.UserEntity;
import com.example.firstSpring.models.TodoModel;
import com.example.firstSpring.repository.TodoRepo;
import com.example.firstSpring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
   private TodoRepo _todoRepo;

    @Autowired
    private UserRepo _userRepo;

    public TodoModel createTodo (TodoEntity todo, Long userId) {
        UserEntity user = _userRepo.findById(userId).get();
        todo.setUser(user);

        return saveTodo(todo);
    }

    public TodoModel changeTodoCompleted(Long id) {
           TodoEntity todo = _todoRepo.findById(id).get();

           boolean newStatus = !todo.isCompleted();
           todo.setCompleted(newStatus);

        return saveTodo(todo);
    }

    private TodoModel saveTodo(TodoEntity todo) {
        return TodoModel.toModel(_todoRepo.save(todo));
    }



}
