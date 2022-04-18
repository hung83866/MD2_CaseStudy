package com.company.controlled;

import com.company.model.Services;
import com.company.service.Service.ServiceServiceIMPL;

import java.util.List;

public class ServiceController {
    ServiceServiceIMPL serviceServiceIMPL = new ServiceServiceIMPL();
    public  List<Services> showListSeevice(){
        return serviceServiceIMPL.findAll();
    }
    public void addService(Services services){serviceServiceIMPL.save(services);}
}
