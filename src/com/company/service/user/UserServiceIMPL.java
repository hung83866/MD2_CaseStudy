package com.company.service.user;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.User;

import java.util.List;

public class UserServiceIMPL implements IUserServer{
    public static String PATH = "D:\\module2\\LapTrinhDaLuong\\CaseStudy-Md2-QlyQuanNet\\src\\com\\company\\data\\Register";
    public static List<User> userList = new ConfigReadAndWriteFile<User>().readFromFile(PATH);
    @Override
    public List<User> findAll() {
        new ConfigReadAndWriteFile<User>().writeToFile(PATH,userList);
        return userList;
    }
    @Override
    public void save(User user) {
        userList.add(user);
        System.out.println(userList);
        new ConfigReadAndWriteFile<User>().writeToFile(PATH,userList);
    }
}
