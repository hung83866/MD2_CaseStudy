package com.company.controlled;

import com.company.model.Login;
import com.company.service.login.LoginServiceIMPL;

public class LoginControlled {
    LoginServiceIMPL loginServiceIMPL = new LoginServiceIMPL();
    public boolean login(Login login){
        return loginServiceIMPL.login(login);
    }
    public boolean admin(Login login){
        return loginServiceIMPL.admin(login);
    }
}
