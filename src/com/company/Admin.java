package com.company;

import com.company.view.AdminView;
import com.company.view.LoginView;
import com.company.view.UserView;

import java.util.Scanner;

public class Admin {
    public Admin() {
        System.out.println("1. Danh sách tài khoản!");
        System.out.println("2. Thêm tài khoản!");
        System.out.println("3. Sửa tài khoản!");
        System.out.println("4. Xóa tài khoản");
        System.out.println("5. Đăng xuất");
        Scanner scanner = new Scanner(System.in);
        int choose =scanner.nextInt();
        switch (choose){
            case 1:
                new AdminView().showListUser();
                break;
            case 2:
                new AdminView().addUser();
                break;
            case 3:
                new AdminView().editPasswordByName();
                break;
            case 4:
                new AdminView().deleteUserByName();
                break;
            case 5:
                new AdminView().logOut();
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
