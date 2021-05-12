package com.gradecom.gradebook.BL.Implementation;

import com.gradecom.gradebook.BL.Abstract.IClassworkService;
import com.gradecom.gradebook.DL.Abstract.IDaoFactory;
import com.gradecom.gradebook.model.Classwork;
import java.util.Collection;

public class ClassworkService implements IClassworkService{

    IDaoFactory daoFactory;
    
    public ClassworkService(IDaoFactory dao) {
        this.daoFactory = dao;
    }
    
    @Override
    public Classwork get(int Id) {
        return daoFactory.getClassworkDao().read(Id);
    }

    @Override
    public Collection<Classwork> getByGB(int Id) {
        return daoFactory.getClassworkDao().readByGradebook(daoFactory.getGradebookDao().read(Id));
    }

    @Override
    public void Save(Classwork cw) {
        daoFactory.getClassworkDao().create(cw);
    }
    
}
