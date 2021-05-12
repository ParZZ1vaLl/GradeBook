package com.gradecom.gradebook.DL.Implementation;

import com.gradecom.gradebook.DL.Abstract.IClassworkDao;
import com.gradecom.gradebook.model.Classwork;
import com.gradecom.gradebook.model.Gradebook;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

public class ClassworkDao implements IClassworkDao{
    protected DataBase database;

    public ClassworkDao(DataBase database) {
        this.database = database;
    }
    
    
    @Override
    public Collection<Classwork> getAll() {
        return database.classworks.values();
    }

    @Override
    public void create(Classwork arg0) {
        int maxId = database.classworks.keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        arg0.setId(maxId + 1);
        database.classworks.put(maxId+1, arg0);
    }

    @Override
    public void delete(int arg0) {
        database.classworks.remove(arg0);
    }

    @Override
    public Classwork read(int arg0) {
        return database.classworks.get(arg0);
    }


    @Override
    public Collection<Classwork> readByGradebook(Gradebook arg0) {
        return database.classworks.values()
                .stream()
                .filter(i->Objects.equals(i.getGradebook(), arg0))
                .collect(Collectors.toCollection(HashSet::new));}
    
}
