package com.company.service.login;

import com.company.Admin;
import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Login;
import com.company.model.User;
import com.company.service.user.UserServiceIMPL;

import java.util.List;

public class LoginServiceIMPL implements ILoginService{
    public static List<User> userList = UserServiceIMPL.userList;
    public static String PATH1 = "D:\\module2\\LapTrinhDaLuong\\CaseStudy-Md2-QlyQuanNet\\src\\com\\company\\data\\Admin";
    public static List<User> userList1 = new ConfigReadAndWriteFile<User>().readFromFile(PATH1);
    @Override
    public boolean login(Login login1) {
        boolean check1 = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(login1.getUserName())){
                if (userList.get(i).getPassword().equals(login1.getPassword())){
                    check1 = true;
                }
            }
        }
        return check1;
    }

    @Override
    public boolean admin(Login login) {
        boolean check = false;
        for (int i = 0; i < userList1.size(); i++) {
            if (userList1.get(i).getUserName().equals(login.getUserName())){
                if (userList1.get(i).getPassword().equals(login.getPassword())){
                    check = true;
                }
            }
        }
        return check;
    }
}
