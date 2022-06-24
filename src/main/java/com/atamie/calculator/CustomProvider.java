package com.atamie.calculator;

public class CustomProvider {
    private String airtime_service;
    private String shortname;

    private int biller;
    private int product;

    private String name;
    private String [] plan;

    public void setPlan(String[] plan) {
        this.plan = plan;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getName() {
        return name;
    }

    public String[] getPlan() {
        return plan;
    }

    public String getShortname() {
        return shortname;
    }

    public int getBiller() {
        return biller;
    }

    public int getProduct() {
        return product;
    }

    public String getAirtime_service() {
        return airtime_service;
    }

    public void setAirtime_service(String airtime_service) {
        this.airtime_service = airtime_service;
    }

    public void setBiller(int biller) {
        this.biller = biller;
    }

    public void setProduct(int product) {
        this.product = product;
    }

}
