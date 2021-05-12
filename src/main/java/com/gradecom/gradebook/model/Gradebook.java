package com.gradecom.gradebook.model;

import java.util.List;

public class Gradebook {
    private Integer id;
    private String name;
    private List<User> users;
    private User teacher;

    public Gradebook(Integer id, String name, List<User> users, User teacher) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
    
    
 }
