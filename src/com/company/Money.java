package com.company;

import com.company.view.ComputerView;

import java.util.Scanner;

public class Money {
    public Money() {
        System.out.println("1. Tính tiền");
        System.out.println("2. Thêm dịch vụ");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        scanner.nextLine();
        switch (key){
            case 1:
            case 2:
                new ComputerView().addServices();
                break;
        }
    }

    public static void main(String[] args) {
        new Money();
    }
}
