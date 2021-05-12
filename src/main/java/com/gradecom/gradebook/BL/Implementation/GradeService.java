package com.gradecom.gradebook.BL.Implementation;

import com.gradecom.gradebook.BL.Abstract.IGradeService;
import com.gradecom.gradebook.DL.Abstract.IDaoFactory;
import com.gradecom.gradebook.model.Grade;
import java.util.Collection;

public class GradeService implements IGradeService{

    IDaoFactory daoFactory;
    
    public GradeService(IDaoFactory dao) {
        this.daoFactory = dao;
    }
    
    @Override
    public Grade get(int Id) {
        return daoFactory.getGradeDao().read(Id);
    }

    @Override
    public Collection<Grade> getAll() {
        return daoFactory.getGradeDao().getAll();
    }
    
}
