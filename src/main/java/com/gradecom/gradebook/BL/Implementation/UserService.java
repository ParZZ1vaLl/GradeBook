package com.gradecom.gradebook.BL.Implementation;

import com.gradecom.gradebook.BL.Abstract.IUserService;
import com.gradecom.gradebook.DL.Abstract.IDaoFactory;
import com.gradecom.gradebook.model.User;

public class UserService implements IUserService {

    IDaoFactory daoFactory;
    
    public UserService(IDaoFactory dao) {
        this.daoFactory = dao;
    }

    @Override
    public User getByLogin(String login) {
        return daoFactory.getUserDao().getByLogin(login);
    }

    @Override
    public boolean checkPassword(User user, String password) {
        return user.getPassword().equals(password);
    }
    
}
