package com.example.a448protoyypea;

public class Request {
    private String driver;
    private int lot;

    public Request(){


    }

    public Request(String d, int l){
        this.driver = d;
        this.lot = l;
    }

    public void setDriver(String d){
        this.driver = d;
    }

    public String getDriver() {
        return driver;
    }

    public void setLot(int l){
        this.lot = l;
    }

    public int getLot() {
        return lot;
    }
}
