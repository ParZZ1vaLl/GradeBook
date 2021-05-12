package com.gradecom.gradebook.BL.Abstract;

import com.gradecom.gradebook.model.Grade;
import java.util.Collection;

public interface IGradeService {
    
    Grade get(int Id);
    
    Collection<Grade> getAll();
}
