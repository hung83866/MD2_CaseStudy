package com.company.controlled;

import com.company.model.User;
import com.company.service.user.UserServiceIMPL;

import java.util.List;

public class UserControlled {
    UserServiceIMPL userServiceIMPL = new UserServiceIMPL();
    public List<User> showListUser(){
        return userServiceIMPL.findAll();
    }
    public void createUser(User user){userServiceIMPL.save(user);}
}
