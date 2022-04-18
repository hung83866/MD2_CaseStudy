package com.company.controlled;

import com.company.model.User;
import com.company.service.Admin.AdminServiceIMPL;

import java.util.List;

public class AdminController {
    AdminServiceIMPL adminServiceIMPL = new AdminServiceIMPL();
    public List<User> findAll(){return adminServiceIMPL.findAll();}
    public void seve(User user){adminServiceIMPL.save(user);}
    public void delete(String name){adminServiceIMPL.delete(name);}
    public void edit(User user){adminServiceIMPL.edit(user);}

}
