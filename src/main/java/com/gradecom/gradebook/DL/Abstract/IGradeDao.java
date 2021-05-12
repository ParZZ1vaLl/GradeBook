package com.gradecom.gradebook.DL.Abstract;

import com.gradecom.gradebook.model.Grade;
import java.util.Collection;

public interface IGradeDao {
    
    Collection<Grade> getAll();

    void create(Grade grade);

    void delete(int Id);
    
    Grade read(int Id);
    
}
