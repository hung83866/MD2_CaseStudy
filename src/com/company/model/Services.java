package com.company.model;

import java.io.Serializable;

public class Services implements Serializable {
    private int id;
    private String name;
    private long price;
    private int number;
    public static long total = 0;

    public Services(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }
    public Services(int id, String name, long price, int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
    }
    public Services(int id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number=0;
        total+=this.getMoneyService();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Services() {
    }

    public Services(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Services(long price, int number) {
        this.price = price;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number += number;
    }
    public long getMoneyService(){
        return this.price*this.number;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
