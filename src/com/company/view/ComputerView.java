package com.company.view;

import com.company.ComputerControl;
import com.company.LoginMain;
import com.company.Main;
import com.company.config.ConfigReadAndWriteFile;
import com.company.controlled.ComputerControlled;
import com.company.model.Computer;
import com.company.model.ComputerStatus;
import com.company.model.Orders;
import com.company.model.Services;
import com.company.service.Service.ServiceServiceIMPL;
import com.company.service.computer.ComputerServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputerView {
    Scanner scanner = new Scanner(System.in);
    ComputerControlled computerControlled = new ComputerControlled();
    List<Computer> computerList = ComputerServiceIMPL.computerList;
    public void logOut() {
        new Main();
    }

    public void computerOnline() {
        boolean check = true;
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).getComputerStatus() == ComputerStatus.AVAIABLE) {
                System.out.println(computerList.get(i));
                check = false;
            }
        }
        if (check) {
            System.out.println("không có máy nào đang ONLINE!");
            new ComputerControl();
        }
        new ComputerControl();
    }

    public void computerOffLine() {
        boolean check = true;
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).getComputerStatus() == ComputerStatus.DISABLE) {
                System.out.println(computerList.get(i));
                check = false;
            }
        }
        if (check) {
            System.out.println("không có mày nào đang OFFLINE!");
            new ComputerControl();
        }
        System.out.println("chọn:, 1.Mở máy! , 0.Quit! ");
        int key1 = scanner.nextInt();
        scanner.nextLine();
        switch (key1) {
            case 1:
                controlComputerOffline();
                break;
            case 0:
                new LoginMain();
                break;
        }
    }

    public void controlComputerOffline() {
        System.out.println("Nhập ID của máy muốn bật : (0.QUIT)");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (id == 0) {
            new LoginMain();
        }
        boolean check = true;
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).getComputerStatus() == ComputerStatus.DISABLE&&computerList.get(i).getId()==id) {
                check = false;
                computerControlled.OnComputer(id);
                System.out.println("Bật máy thành công!");
                controlComputerOffline();
            }
        }
        if (check) {
            System.out.println("máy đang online hoặc không tồn tại!");
            computerOffLine();
        }
    }

    public void showListComputer() {
        System.out.println(computerControlled.showListComputer());
        if (computerList.size() == 0) {
            System.out.println("Chưa có thông tin! , 1.Thêm Máy tính mới! , 2.Quit! ");
            int key1 = scanner.nextInt();
            scanner.nextLine();
            switch (key1) {
                case 1:
                    addComputer();
                    break;
                case 2:
                    new LoginMain();
                    break;
            }
        } else {
            while (true) {
                boolean check = true;
                System.out.println(" Nhập ID của máy tính để xem thông tin chi tiết! hoặc 0.QUIT!");
                int computerNum = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < computerList.size(); i++) {
                    if (computerNum == computerList.get(i).getId()) {
                        computerList.get(i).getOrder().setEndTime(System.currentTimeMillis());
                        System.out.println(computerList.get(i).toString1());
                        check = false;
                    }
                }
                if (check) {
                    System.out.println(" Máy tính không tồn tại!");
                }
                if (computerNum == 0) {
                    new LoginMain();
                }
            }
        }
    }

    public void addComputer() {
         String path = "D:\\module2\\LapTrinhDaLuong\\CaseStudy-Md2-QlyQuanNet\\src\\com\\company\\data\\Services";
         List<Services> servicesList = new ConfigReadAndWriteFile<Services>().readFromFile(path);
        List<Services> arr = new ArrayList<>(servicesList);
        while (true) {
            int id;
            if (computerList.size() == 0) {
                id = 1;
            } else {
                id = computerList.get(computerList.size() - 1).getId() + 1;
            }
            System.out.println(" Nhập tên của máy tính mới!");
            String name = scanner.nextLine();
            Computer computer = new Computer(id, name,new Orders(0,0,arr));
            computerControlled.save(computer);
            System.out.println(" Nhập phím bất kì để tiếp tục, hoặc Q để QUIT!");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("q")) {
                new LoginMain();
            }
        }
    }

    public void modifyNameComputerByID() {
        while (true) {
            System.out.println("Nhập ID của máy: (0=QUIT)");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id == 0) {
                new LoginMain();
            }
            boolean check = true;
            for (int i = 0; i < computerList.size(); i++) {
                if (computerList.get(i).getId() == id) {
                    System.out.println("Nhập tên mới cho máy tình!");
                    String name = scanner.nextLine();
                    Computer computer = new Computer(id, name);
                    computerControlled.modifyNameComputerByID(computer);
                    System.out.println("Sửa tên thành công!");
                    check = false;
                    System.out.println(" Nhập phím bất kì để tiếp tục, hoặc Q để QUIT!");
                    String backMenu = scanner.nextLine();
                    if (backMenu.equalsIgnoreCase("q")) {
                        new LoginMain();
                    }
                }
            }
            if (check) {
                System.out.println("ID Máy tính không tồn tại!");
                System.out.println(" Nhập phím bất kì để tiếp tục, hoặc Q để QUIT!");
                String backMenu = scanner.nextLine();
                if (backMenu.equalsIgnoreCase("q")) {
                    new LoginMain();
                }
            }
        }
    }

    public void deleteComputerByID() {
        while (true) {
            System.out.println("Nhập ID của máy : (0=QUIT)");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id == 0) {
                new LoginMain();
            }
            boolean check = true;
            for (int i = 0; i < computerList.size(); i++) {
                if (computerList.get(i).getId() == id) {
                    computerControlled.deleteComputerByID(id);
                    check = false;
                    System.out.println("Xóa máy chạm thành công!");
                    System.out.println(" Nhập phím bất kì để tiếp tục, hoặc Q để QUIT!");
                    String backMenu = scanner.nextLine();
                    if (backMenu.equalsIgnoreCase("q")) {
                        new LoginMain();
                    }
                }
            }
            if (check) {
                System.out.println("ID Máy tính không tồn tại!");
                System.out.println(" Nhập phím bất kì để tiếp tục, hoặc Q để QUIT!");
                String backMenu = scanner.nextLine();
                if (backMenu.equalsIgnoreCase("q")) {
                    new LoginMain();
                }
            }
        }
    }

    public void addServices() {
        while (true) {
            System.out.println(" Nhập ID của máy : (0=QUIT)");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id == 0) {
                new LoginMain();
            }
            boolean check = true;
            for (int i = 0; i < computerList.size(); i++) {
                if (computerList.get(i).getId() == id&&computerList.get(i).getComputerStatus()==ComputerStatus.AVAIABLE) {
                    check = false;
                    System.out.println(computerList.get(i).getOrder().getServices());
                    System.out.println("Nhập id của dịch vụ : ");
                    int idSercive = scanner.nextInt();
                    scanner.nextLine();
                    boolean check1 = true;
                    List<Services> services = computerList.get(i).getOrder().getServices();
                    for (int j = 0; j < services.size(); j++) {
                        if (services.get(j).getId() == idSercive) {
                            check1 = false;
                            System.out.println("Nhập Số lượng thêm : ");
                            int num = scanner.nextInt();
                            scanner.nextLine();
                            computerControlled.addServiceByID(id, idSercive, num);
                            System.out.println("Thêm thành công!");
                            System.out.println("Nhâp : 0.QUIT hoặc 1.Tiếp tục ");
                            int backMenu = scanner.nextInt();
                            scanner.nextLine();
                            switch (backMenu) {
                                case 0:
                                    new LoginMain();
                                    break;
                                case 1:
                                    addServices();
                                    break;
                            }
                        }
                    }
                    if (check1){
                        System.out.println("ID dịch vụ không tồn tại!");
                        new LoginMain();
                    }
                }
            }
            if (check) {
                System.out.println(" Máy tính không tồn tại hoặc đang tắt!");
            }
        }
    }

}
