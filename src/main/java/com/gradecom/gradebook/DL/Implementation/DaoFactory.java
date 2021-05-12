package com.gradecom.gradebook.DL.Implementation;

import com.gradecom.gradebook.DL.Abstract.IClassworkDao;
import com.gradecom.gradebook.DL.Abstract.IDaoFactory;
import com.gradecom.gradebook.DL.Abstract.IGradeDao;
import com.gradecom.gradebook.DL.Abstract.IGradebookDao;
import com.gradecom.gradebook.DL.Abstract.IUserDao;

public class DaoFactory implements IDaoFactory{

    DataBase database;
    IClassworkDao classworkDao;
    IUserDao userDao;
    IGradeDao gradeDao;
    IGradebookDao gradebookDao;

    DaoFactory(DataBase database) {
        this.database = database;
        classworkDao = new ClassworkDao(database);
        userDao = new UserDao(database);
        gradeDao = new GradeDao(database);
        gradebookDao = new GradebookDao(database);
    }
    
    @Override
    public IClassworkDao getClassworkDao() {
        return classworkDao;
    }

    @Override
    public IUserDao getUserDao() {
        return userDao;
    }

    @Override
    public IGradeDao getGradeDao() {
        return gradeDao;
    }

    @Override
    public IGradebookDao getGradebookDao() {
        return gradebookDao;
    }
    
}
