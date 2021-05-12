package com.gradecom.gradebook.BL.Implementation;

import com.gradecom.gradebook.BL.Abstract.IGradebookService;
import com.gradecom.gradebook.DL.Abstract.IDaoFactory;
import com.gradecom.gradebook.model.Gradebook;
import com.gradecom.gradebook.model.User;
import java.util.Collection;

public class GradebookService implements IGradebookService{

    IDaoFactory daoFactory;
    
    public GradebookService(IDaoFactory dao) {
        this.daoFactory = dao;
    }
    
    @Override
    public Gradebook get(int Id) {
        return daoFactory.getGradebookDao().read(Id);
    }

    @Override
    public Collection<Gradebook> getByUser(User user) {
        return daoFactory.getGradebookDao().readByUser(user);
    }
    
}
