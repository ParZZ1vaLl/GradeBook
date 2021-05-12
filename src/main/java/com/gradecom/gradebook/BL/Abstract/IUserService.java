package com.gradecom.gradebook.BL.Abstract;

import com.gradecom.gradebook.model.User;

public interface IUserService {
    
    User getByLogin(String login);

    boolean checkPassword(User user, String password);
}
