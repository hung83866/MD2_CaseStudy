package com.company.model;

import com.company.config.ConfigReadAndWriteFile;
import com.company.service.Service.ServiceServiceIMPL;

import java.io.Serializable;
import java.util.List;


public class Computer implements Serializable {
    private int id;
    private String name;
    private ComputerStatus computerStatus;
    private Orders order;
    public Computer() {
    }
    public Computer(int id, String name) {
        this.id = id;
        this.name = name;
        this.computerStatus = ComputerStatus.DISABLE;
        this.order  = new Orders(0,0);
    }
    public Computer(int id, String name,Orders order) {
        this.id = id;
        this.name = name;
        this.computerStatus = ComputerStatus.DISABLE;
        this.order  = order;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ComputerStatus getComputerStatus() {
        return computerStatus;
    }

    public void setComputerStatusAvaiable() {
        this.computerStatus = ComputerStatus.AVAIABLE;
    }
    public void setComputerStatusDisable(){this.computerStatus = ComputerStatus.DISABLE;}


    public String toString1() {
        if (computerStatus==ComputerStatus.DISABLE){
            return "Máy đang OFFLINE!";
        }
        return "Computer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", computerStatus=" + computerStatus +
                ", =" + order +
                '}';
    }
    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", computerStatus=" + computerStatus +
                '}';
    }
}
