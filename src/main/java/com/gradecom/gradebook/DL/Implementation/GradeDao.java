package com.gradecom.gradebook.DL.Implementation;

import com.gradecom.gradebook.DL.Abstract.IGradeDao;
import com.gradecom.gradebook.model.Grade;
import java.util.Collection;

public class GradeDao implements IGradeDao{
    protected DataBase database;

    public GradeDao(DataBase database) {
        this.database = database;
    }
    
    @Override
    public Collection<Grade> getAll() {
        return database.grades.values();
    }

    @Override
    public void create(Grade arg0) {
        int maxId = database.grades.keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        arg0.setId(maxId + 1);
        database.grades.put(maxId+1, arg0);}

    @Override
    public void delete(int arg0) {
        database.grades.remove(arg0);
    }

    @Override
    public Grade read(int arg0) {
        return database.grades.get(arg0);
    }
}
