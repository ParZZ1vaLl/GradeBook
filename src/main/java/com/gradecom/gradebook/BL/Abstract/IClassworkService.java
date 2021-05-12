package com.gradecom.gradebook.BL.Abstract;

import com.gradecom.gradebook.model.Classwork;
import java.util.Collection;

public interface IClassworkService {
    
    Classwork get(int Id);
    
    Collection<Classwork> getByGB(int Id);
    
    void Save(Classwork cw);
}
