package com.company.service;

import com.company.Admin;
import com.company.model.Login;
import com.company.model.User;

public interface ILoginGereric<T> {
    boolean login(Login login);
    boolean admin(Login login);
}
