package com.company.model;

import com.company.config.ConfigReadAndWriteFile;
import com.company.service.Service.ServiceServiceIMPL;

import java.io.Serializable;
import java.util.List;

public class Orders implements Serializable {
    private long startTime;
    private long endTime;
    private List<Services> services;
    public static String path = "D:\\module2\\LapTrinhDaLuong\\CaseStudy-Md2-QlyQuanNet\\src\\com\\company\\data\\Services";
    public static List<Services> servicesList = new ConfigReadAndWriteFile<Services>().readFromFile(path);
    public Orders() {
    }

    public Orders(long startTime, long endTime,List<Services> services) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.services = services;
    }

    public Orders(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }
    public long getMoneyTime(){
        return (this.endTime-this.startTime)/360;
    }
    public long getTotal(){return this.getMoneyTime()+Services.total;}
    @Override
    public String toString() {
        return "Orders{" +
                " TimeTotal = "+(this.endTime-this.startTime)/3600000+"h"+
                ", TimeMoney = "+this.getMoneyTime()+"VND"+
                ", services=" + services +
                '}';
    }
}
