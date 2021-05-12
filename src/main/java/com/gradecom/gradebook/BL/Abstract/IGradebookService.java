package com.gradecom.gradebook.BL.Abstract;

import com.gradecom.gradebook.model.Gradebook;
import com.gradecom.gradebook.model.User;
import java.util.Collection;

public interface IGradebookService {
    
    Gradebook get(int Id);
    
    Collection<Gradebook> getByUser(User user);
}
