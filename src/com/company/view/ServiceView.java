package com.company.view;

import com.company.LoginMain;
import com.company.ServicesMain;
import com.company.controlled.ServiceController;
import com.company.model.Services;
import com.company.service.Service.ServiceServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class ServiceView {
    Scanner scanner = new Scanner(System.in);
    List<Services> servicesList = ServiceServiceIMPL.servicesList;
    ServiceController serviceController = new ServiceController();
    public void showList(){
        System.out.println(serviceController.showListSeevice());
        new ServicesMain();
    }
    public void addService(){
        while (true){
            int id;
            if (servicesList.size()==0){
                id = 1;
            }else {
                id= servicesList.get(servicesList.size()-1).getId()+1;
            }
            System.out.println("Nhập tên dịch vụ:");
            String name = scanner.nextLine();
            System.out.println("Nhập giá dịch vụ:");
            long price = scanner.nextInt();
            scanner.nextLine();
            Services services = new Services(id,name,price);
            serviceController.addService(services);
            System.out.println("Nhập bất kì để tiếp tục hoặc Q để QUIT");
            String key = scanner.nextLine();
            if (key.equalsIgnoreCase("q")){
                new ServicesMain();
            }
        }
    }
    public void quit(){
        new LoginMain();
    }
}
