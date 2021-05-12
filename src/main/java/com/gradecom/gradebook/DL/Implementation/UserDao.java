package com.gradecom.gradebook.DL.Implementation;

import com.gradecom.gradebook.DL.Abstract.IUserDao;
import com.gradecom.gradebook.model.User;

public class UserDao implements IUserDao{
    protected DataBase database;

    public UserDao(DataBase database) {
        this.database = database;
    }
    @Override
    public User getByLogin(String arg0) {
        return database.users.values()
                .stream()
                .filter(user -> user.getLogin().equals(arg0))
                .findFirst()
                .orElse(null);
    }
    
}
