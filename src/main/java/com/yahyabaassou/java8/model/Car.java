package com.yahyabaassou.java8.model;

public class Car {

    private String brand;
    private String model;
    private double maxSpeed;
    private String country;

    public Car(String brand, String model, double maxSpeed, String country) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.country = country;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public String getCountry() {
        return country;
    }

}
