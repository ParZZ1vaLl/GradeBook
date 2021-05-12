package com.gradecom.gradebook.model;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

public class Classwork{
    private Integer id;
    private Calendar data;
    private Map<User, Grade> grades;
    private Gradebook gradebook;

    public Classwork(Integer id, Calendar data, Map<User, Grade> grades, Gradebook gradebook) {
        this.id = id;
        this.data = data;
        this.grades = grades;
        this.gradebook = gradebook;
    }

    public Classwork(Gradebook gradebook) {
        this.data = Calendar.getInstance();
        this.grades = new LinkedHashMap<>();
        this.gradebook = gradebook;
        gradebook.getUsers().forEach(u -> grades.put(u, null));
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Map<User, Grade> getGrades() {
        return grades;
    }

    public void setGrades(Map<User, Grade> grades) {
        this.grades = grades;
    }

    public Gradebook getGradebook() {
        return gradebook;
    }

    public void setGradebook(Gradebook gradebook) {
        this.gradebook = gradebook;
    }
    
    @Override
    public String toString(){
        return data.getTime().toString().substring(4 ,11) + data.getTime().toString().substring(24 ,29);
    }
    
    @Override
    public int hashCode(){
        return id;
    }  
    
}
