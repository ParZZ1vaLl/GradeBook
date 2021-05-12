package com.gradecom.gradebook.DL.Abstract;

public interface IDaoFactory {
    
    IClassworkDao getClassworkDao();
    
    IUserDao getUserDao(); 
    
    IGradeDao getGradeDao(); 
    
    IGradebookDao getGradebookDao(); 
}
