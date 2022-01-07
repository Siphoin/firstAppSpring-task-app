package com.example.firstSpring.models;

import com.example.firstSpring.entity.TodoEntity;
import com.example.firstSpring.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserModel {

    private Long _id;

    private String _username;

    public List<TodoModel> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoModel> todos) {
        this.todos = todos;
    }

    private List<TodoModel>  todos;

    public UserModel() {
    }

    public UserModel(Long id, String username, List<TodoEntity> todos) {
        _id = id;
        _username = username;
        setTodos(todos.stream().map(TodoModel::toModel).collect(Collectors.toList()));
    }


    public Long getId() {
        return _id;
    }

    public String getUsername() {
        return _username;
    }

    public void setId(Long _id) {
        this._id = _id;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public static UserModel toModel(UserEntity userEntity) {
        UserModel model = new UserModel(userEntity.getId(), userEntity.getUsername(), userEntity.getTodos());
        return model;
    }
}
