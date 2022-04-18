package com.company;

import com.company.view.ServiceView;

import java.util.Scanner;

public class ServicesMain {
    public ServicesMain() {
        System.out.println("1. Danh sách dịch vụ");
        System.out.println("2. Thêm dịch vụ");
        System.out.println("3. Sửa dịch vụ");
        System.out.println("4. xóa dịch vụ");
        System.out.println("5. Quit");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        scanner.nextLine();
        switch (key){
            case 1:
                new ServiceView().showList();
                break;
            case 2:
                new ServiceView().addService();
                break;
            case 3:
            case 4:
            case 5:
                new ServiceView().quit();
                break;
        }
    }

    public static void main(String[] args) {
        new ServicesMain();
    }
}
