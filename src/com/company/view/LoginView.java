package com.company.view;

import com.company.Admin;
import com.company.LoginMain;
import com.company.Main;
import com.company.controlled.LoginControlled;
import com.company.model.Login;

import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);
    LoginControlled loginControlled = new LoginControlled();

    public void login() {
        System.out.println(" Nhập tên: ");
        String userName = scanner.nextLine();
        if (userName.equalsIgnoreCase("q")){
            new Main();
        }
        System.out.println(" Nhập mật khẩu : ");
        String password = scanner.nextLine();
        Login login = new Login(userName, password);
        if (loginControlled.login(login)) {

            System.out.println("====================== Chào mừng ông(bà) : " + userName + " to MENU ====================");
            new LoginMain();
        } else {
            if (loginControlled.admin(login)) {
                System.out.println("====================== Chào mừng admin : " + userName + " to MENU ADMIN ====================");
                new Admin();
            } else {
                System.out.println("sai thông tin đăng nhập!");
                login();
           }
        }
    }
}
