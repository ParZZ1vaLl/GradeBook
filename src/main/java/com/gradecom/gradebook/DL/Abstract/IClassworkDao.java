package com.gradecom.gradebook.DL.Abstract;

import com.gradecom.gradebook.model.Classwork;
import com.gradecom.gradebook.model.Gradebook;
import java.util.Collection;

public interface IClassworkDao {
    
    Collection<Classwork> getAll();

    void create(Classwork classwork);

    void delete(int Id);
    
    Classwork read(int Id);
    
    Collection<Classwork> readByGradebook(Gradebook gradebook);
}
