package com.company.view;

import com.company.Main;
import com.company.config.ConfigReadAndWriteFile;
import com.company.controlled.UserControlled;
import com.company.model.User;
import com.company.service.login.LoginServiceIMPL;
import com.company.service.user.UserServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class UserView {
    Scanner scanner = new Scanner(System.in);
    UserControlled userControlled = new UserControlled();
    List<User> userList = UserServiceIMPL.userList;
    public void addUser() {
        boolean check = true;
        System.out.println(" Nhập tên người dùng : ");
        String userName = scanner.nextLine();
        int size = userList.size();
        for (int i = 0; i < size; i++) {
            if (userList.get(i).getUserName().equals(userName)) {
                System.out.println("Tên người dùng đã được sử dụng!");
                check = false;
                new Main();
            }
        }
        if (check) {
            System.out.println(" Nhập Mật khẩu : ");
            String password = scanner.nextLine();
            User user = new User(userName, password);
            userControlled.createUser(user);
            System.out.println("Tạo tài khoản thành công!");
            new Main();
        }
    }
}
