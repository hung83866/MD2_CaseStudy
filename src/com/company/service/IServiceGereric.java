package com.company.service;

import java.util.List;

public interface IServiceGereric<T> {
    List<T> findAll();
    void save(T t);
}
