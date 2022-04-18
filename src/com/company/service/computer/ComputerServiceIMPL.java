package com.company.service.computer;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Computer;
import com.company.model.ComputerStatus;
import com.company.model.Services;

import java.util.List;

public class ComputerServiceIMPL implements IComputerService {
    public static String PATH = "D:\\module2\\LapTrinhDaLuong\\CaseStudy-Md2-QlyQuanNet\\src\\com\\company\\data\\computerList";
    public static List<Computer> computerList = new ConfigReadAndWriteFile<Computer>().readFromFile(PATH);
    @Override
    public List<Computer> findAll() {
        new ConfigReadAndWriteFile<Computer>().writeToFile(PATH, computerList);
        return computerList;
    }

    @Override
    public void save(Computer computer) {
        computerList.add(computer);
        new ConfigReadAndWriteFile<Computer>().writeToFile(PATH, computerList);
    }

    public void modifyNameComputerByID(Computer computer) {
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).getId() == computer.getId()) {
                computerList.get(i).setName(computer.getName());
            }
        }
    }

    public void deleteComputerByID(int id) {
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).getId() == id) {
                computerList.remove(computerList.get(i));
            }
        }
    }

    public void addServiceByID(int idC,int idS, int num) {
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).getId() == idC) {
                for (int j = 0; j < computerList.get(i).getOrder().getServices().size(); j++) {
                    if (computerList.get(i).getOrder().getServices().get(j).getId()==idS){
                        computerList.get(i).getOrder().getServices().get(j).setNumber(num);
                    }
                }
            }
        }
    }

    public void OnComputerByID(int id) {
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).getId() == id) {
                computerList.get(i).setComputerStatusAvaiable();
                computerList.get(i).getOrder().setStartTime(System.currentTimeMillis());
            }
        }
    }

    public void OffComputerByID(int id) {
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).getComputerStatus() == ComputerStatus.AVAIABLE) {
                if (computerList.get(i).getId() == id) {
                    computerList.get(i).setComputerStatusDisable();
                    computerList.get(i).getOrder().setEndTime(System.currentTimeMillis());
                }
            }
        }
    }
    public List<Services> clone(List<Services> services){
        List<Services> newA = null;
        newA.addAll(services);
        return newA;
    }
}
