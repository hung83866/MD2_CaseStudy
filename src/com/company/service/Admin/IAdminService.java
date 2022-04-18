package com.company.service.Admin;

import com.company.model.User;
import com.company.service.IServiceGereric;

public interface IAdminService extends IServiceGereric<User> {
    void edit(User user);
    void delete(String name);
}
