package com.example.firstSpring.models;


import com.example.firstSpring.entity.TodoEntity;

public class TodoModel {
    private Long _id;

    private String title;

    private boolean isCompleted;

    public TodoModel() {
    }

    public Long getId() {
        return _id;
    }

    public void setId(Long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public static TodoModel toModel(TodoEntity target) {
        TodoModel model = new TodoModel();

        model.setCompleted(target.isCompleted());
        model.setId(target.getId());
        model.setTitle(target.getTitle());

        return model;
    }


}
