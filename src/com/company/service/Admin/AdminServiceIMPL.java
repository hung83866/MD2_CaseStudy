package com.company.service.Admin;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.User;
import com.company.service.user.UserServiceIMPL;

import java.util.List;

public class AdminServiceIMPL implements IAdminService{
    public static String PATH = "D:\\module2\\LapTrinhDaLuong\\CaseStudy-Md2-QlyQuanNet\\src\\com\\company\\data\\Register";
    public static List<User> userList = UserServiceIMPL.userList;
    @Override
    public List<User> findAll() {
        new ConfigReadAndWriteFile<User>().writeToFile(PATH,userList);
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);
        new ConfigReadAndWriteFile<User>().writeToFile(PATH,userList);
    }

    @Override
    public void edit(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (user.getUserName().equals(userList.get(i).getUserName())){
                userList.get(i).setPassword(user.getPassword());
            }
        }
        new ConfigReadAndWriteFile<User>().writeToFile(PATH,userList);
    }

    @Override
    public void delete(String name) {
        for (int i = 0; i < userList.size(); i++) {
            if (name.equals(userList.get(i).getUserName())){
                userList.remove(userList.get(i));
            }
        }
        new ConfigReadAndWriteFile<User>().writeToFile(PATH,userList);
    }
}
