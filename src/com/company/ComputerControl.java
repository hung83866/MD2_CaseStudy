package com.company;

import com.company.view.ComputerView;

import java.util.Scanner;

public class ComputerControl {
    public ComputerControl() {
        System.out.println("1. Các máy đang Online");
        System.out.println("2. Các máy đang Offline");
        System.out.println("3. thông tin máy chạm");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        sc.nextLine();
        switch (key){
            case 1:
                new ComputerView().computerOnline();
                break;
            case 2:
                new ComputerView().computerOffLine();
                break;
            case 3:
                new ComputerView().showListComputer();
                break;
        }
    }

    public static void main(String[] args) {
        new ComputerControl();
    }
}
