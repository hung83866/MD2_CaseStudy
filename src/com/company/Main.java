package com.company;

import com.company.view.LoginView;
import com.company.view.UserView;

import java.util.Scanner;

public class Main {
public Main(){
    System.out.println("====================MY NAVBAR====================");
    System.out.println("1. Đăng ký!");
    System.out.println("2. Đăng nhập!");
    Scanner scanner = new Scanner(System.in);
    int choose =scanner.nextInt();
    switch (choose){
        case 1:
            new UserView().addUser();
            break;
        case 2:
            new LoginView().login();
            break;
    }
}
    public static void main(String[] args) {
	// write your code here
        new Main();
    }
}
