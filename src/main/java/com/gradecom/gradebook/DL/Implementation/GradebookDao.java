package com.gradecom.gradebook.DL.Implementation;

import com.gradecom.gradebook.DL.Abstract.IGradebookDao;
import com.gradecom.gradebook.model.Gradebook;
import com.gradecom.gradebook.model.User;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

public class GradebookDao implements IGradebookDao{
    protected DataBase database;

    public GradebookDao(DataBase database) {
        this.database = database;
    }
    @Override
    public Collection<Gradebook> getAll() {
        return database.gradebooks.values();
    }

    @Override
    public void create(Gradebook arg0) {
        int maxId = database.gradebooks.keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        arg0.setId(maxId + 1);
        database.gradebooks.put(maxId+1, arg0);}

    @Override
    public void delete(int arg0) {
        database.gradebooks.remove(arg0);
    }

    @Override
    public Gradebook read(int arg0) {
        return database.gradebooks.get(arg0);
    }

    @Override
    public Collection<Gradebook> readByUser(User arg0) {
        return database.gradebooks.values().stream()
                .filter(i -> (Objects.equals(i.getTeacher(), arg0)) | (i.getUsers().contains(arg0)))
                .collect(Collectors.toCollection(HashSet::new));
    }
}
