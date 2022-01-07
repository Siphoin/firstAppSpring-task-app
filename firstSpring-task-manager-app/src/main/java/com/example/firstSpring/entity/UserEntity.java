package com.example.firstSpring.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long _id;

    private String username;

    @Column(name = "password")
    private String _password;

    public List<TodoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoEntity> todos) {
        this.todos = todos;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TodoEntity> todos;


    public UserEntity() {
    }

    public void setId (Long id) {
        _id = id;
    }

    public Long getId () {
        return _id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername () {
        return username;
    }

    public void setPassword(String password) {
        _password = password;
    }

    public String getPassword () {
        return _password;
    }
}
