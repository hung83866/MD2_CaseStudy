package com.company.service.Service;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Services;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServiceServiceIMPL implements IService{
    public static String path = "D:\\module2\\LapTrinhDaLuong\\CaseStudy-Md2-QlyQuanNet\\src\\com\\company\\data\\Services";
    public static List<Services> servicesList = new ConfigReadAndWriteFile<Services>().readFromFile(path);
    @Override
    public List<Services> findAll() {
        new ConfigReadAndWriteFile<Services>().writeToFile(path,servicesList);
        return servicesList;
    }

    @Override
    public void save(Services services) {
        servicesList.add(services);
        new ConfigReadAndWriteFile<Services>().writeToFile(path,servicesList);
    }
}
