package com.gradecom.gradebook.DL.Abstract;

import com.gradecom.gradebook.model.User;

public interface IUserDao {
    User getByLogin(String login);
}
