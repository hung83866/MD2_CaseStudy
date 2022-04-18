package com.company;

import com.company.view.ComputerView;

import java.util.Scanner;

public class LoginMain {
    public LoginMain() {
        System.out.println("1. Hiển thị danh sách máy có trong quán");
        System.out.println("2. Thêm một máy mới vào danh sách");
        System.out.println("3. Sửa đổi thông tin của máy");
        System.out.println("4. Xóa 1 máy khỏi danh sách");
        System.out.println("5. Thêm dịch vụ ");
        System.out.println("6. Chỉnh sửa tính tiền theo giờ");
        System.out.println("7. Tính tiền");
        System.out.println("8. Quản lý tài khoản đăng nhập");
        System.out.println("9. Doanh Thu");
        System.out.println("0. Đăng xuất");
        Scanner scanner = new Scanner(System.in);
        int choose =scanner.nextInt();
        switch (choose){
            case 0:
                new ComputerView().logOut();
                break;
            case 1:
                new ComputerControl();
                break;
            case 2:
                new ComputerView().addComputer();
                break;
            case 3:
                new ComputerView().modifyNameComputerByID();
                break;
            case 4:
                new ComputerView().deleteComputerByID();
                break;
            case 5:
                new ServicesMain();
                break;
            case 6:
            case 7:
                new Money();
            case 8:
            case 9:
            default:
                break;
        }
    }

    public static void main(String[] args) {
        new LoginMain();
    }
}
