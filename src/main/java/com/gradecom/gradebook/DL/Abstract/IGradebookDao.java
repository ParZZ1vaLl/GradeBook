package com.gradecom.gradebook.DL.Abstract;

import com.gradecom.gradebook.model.Gradebook;
import com.gradecom.gradebook.model.User;
import java.util.Collection;
import java.util.List;

public interface IGradebookDao {

    Collection<Gradebook> getAll();

    void create(Gradebook gradebook);

    void delete(int Id);
    
    Gradebook read(int Id);
    
    Collection<Gradebook> readByUser(User user);
}
