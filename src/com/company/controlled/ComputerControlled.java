package com.company.controlled;

import com.company.model.Computer;
import com.company.model.Services;
import com.company.service.computer.ComputerServiceIMPL;

import java.util.List;

public class ComputerControlled {
    ComputerServiceIMPL computerServiceIMPL = new ComputerServiceIMPL();
    public List<Computer>  showListComputer(){
       return computerServiceIMPL.findAll();
    }
    public void save(Computer computer){
        computerServiceIMPL.save(computer);
    }
    public void modifyNameComputerByID(Computer computer){
        computerServiceIMPL.modifyNameComputerByID(computer);
    }
    public void deleteComputerByID(int id){
        computerServiceIMPL.deleteComputerByID(id);
    }
    public void addServiceByID(int idC,int idS, int num ){
        computerServiceIMPL.addServiceByID(idC,idS,num);
    }
    public void OnComputer(int id){computerServiceIMPL.OnComputerByID(id);}
    public void OffComputer(int id){computerServiceIMPL.OffComputerByID(id);}
    public List<Services> clone(List<Services> services){return computerServiceIMPL.clone(services);}
}
