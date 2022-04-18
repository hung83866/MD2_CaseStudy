package com.company.view;

import com.company.Admin;
import com.company.LoginMain;
import com.company.Main;
import com.company.config.ConfigReadAndWriteFile;
import com.company.controlled.AdminController;
import com.company.model.User;
import com.company.service.Admin.AdminServiceIMPL;
import com.company.service.login.LoginServiceIMPL;
import com.company.service.user.UserServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class AdminView {
    Scanner scanner = new Scanner(System.in);
    AdminController adminController = new AdminController();
    List<User> userList = UserServiceIMPL.userList;

    public void showListUser() {
        if (userList.size() == 0) {
            System.out.println("Chưa có thông tin! , 1.Thêm người dùng! , 2.Quit! ");
            int key1 = scanner.nextInt();
            scanner.nextLine();
            switch (key1) {
                case 1:
                    new AdminView().addUser();
                    break;
                case 2:
                    new Admin();
                    break;
            }
        } else {
            System.out.println(adminController.findAll());
            System.out.println(" Nhập phím 0 để QUIT!");
            int key1 = scanner.nextInt();
            scanner.nextLine();
            switch (key1) {
                case 0:
                    new Admin();
                    break;
                default:
                    break;
            }
        }
    }

    public void addUser() {
        boolean check = true;
        List<User> userList = LoginServiceIMPL.userList;
        System.out.println("Nhập tên người dùng: ");
        String userName = scanner.nextLine();
        int size = userList.size();
        for (int i = 0; i < size; i++) {
            if (userList.get(i).getUserName().equals(userName)) {
                System.out.println("Tên đã có người sử dụng!");
                check = false;
                new Admin();
            }
        }
        if (check) {
            System.out.println(" Nhập mật khẩu: ");
            String password = scanner.nextLine();
            User user = new User(userName, password);
            adminController.seve(user);
            System.out.println("Tạo tài khoản thành công!");
            new Admin();
        }
    }

    public void editPasswordByName() {
        System.out.println(" Nhập tên người dùng: ");
        String userName = scanner.nextLine();
        if (userName.equalsIgnoreCase("q")){
            new Admin();
        }
        boolean check = true;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(userName)) {
                check = false;
                System.out.println(" Nhập mật khẩu: ");
                String password = scanner.nextLine();
                User user = new User(userName, password);
                adminController.edit(user);
                System.out.println("Sửa thành công!");
                System.out.println(" Nhập : 0.Quit! , 1.tiếp tục sửa!");
                int backMenu2 = scanner.nextInt();
                scanner.nextLine();
                switch (backMenu2) {
                    case 0:
                        new Admin();
                        break;
                    case 1:
                        editPasswordByName();
                        break;
                }
            }
        }
        if (check) {
            System.out.println("Tên người dùng không tồn tại!");
            editPasswordByName();
        }
    }

    public void deleteUserByName() {
        System.out.println(" Nhập tên người dùng: ");
        String userName = scanner.nextLine();
        boolean check = true;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(userName)) {
                check = false;
                adminController.delete(userName);
                System.out.println(" Xóa thành công !");
                System.out.println(" Nhập : 0.Quit! , 1.tiếp tục xóa!");
                int backMenu2 = scanner.nextInt();
                scanner.nextLine();
                switch (backMenu2) {
                    case 0:
                        new Admin();
                        break;
                    case 1:
                        deleteUserByName();
                        break;
                }
            }
        }
        if (check) {
            System.out.println("Tên người dùng không tồn tại!");
            deleteUserByName();
        }
    }

    public void logOut() {
        new Main();
    }
}
