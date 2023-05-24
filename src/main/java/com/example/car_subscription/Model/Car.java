package com.example.car_subscription.Model;

public class Car {

    // attributes
    private int car_id;
    private String vin;
    private String model;
    private String brand;
    private String plate;
    private String feature_level;
    private int steelprice;
    private int reg_fee;
    private int co2;
    private int isFaulty;
    private int isRented;



    // constructor
    public Car(int car_id, String vin, String model, String brand, String plate, String feature_level,
               int steelprice, int reg_fee, int co2, int isFaulty, int isRented) {
        this.car_id = car_id;
        this.vin = vin;
        this.model = model;
        this.brand = brand;
        this.plate = plate;
        this.feature_level = feature_level;
        this.steelprice = steelprice;
        this.reg_fee = reg_fee;
        this.co2 = co2;
        this.isFaulty = isFaulty;
        this.isRented = isRented;
    }

    // empty constructor
    public Car() {

    }

    // getter
    public int getCar_id() {
        return car_id;
    }

    public String getVin() {
        return vin;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getPlate() {
        return plate;
    }

    public String getFeature_level() {
        return feature_level;
    }

    public int getSteelprice() {
        return steelprice;
    }

    public int getReg_fee() {
        return reg_fee;
    }

    public int getCo2() {
        return co2;
    }

    public int getIsFaulty() {
        return isFaulty;
    }

    public int getIsRented() {
        return isRented;
    }

    // setter
    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setFeature_level(String feature_level) {
        this.feature_level = feature_level;
    }

    public void setSteelprice(int steelprice) {
        this.steelprice = steelprice;
    }

    public void setReg_fee(int reg_fee) {
        this.reg_fee = reg_fee;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public void setFaulty(int faulty) {
        isFaulty = faulty;
    }

    public void setRented(int rented) {
        isRented = rented;
    }

    // toString to CarTests
    @Override
    public String toString() {
        return "Car:\ncar_id = " + getCar_id() + "\ncar_vin: " + getVin() + "\ncar_model: " + getModel()
                + "\ncar_brand: " + getBrand() + "\ncar_plate: " + getPlate() +
                "\ncar_feature_level: " + getFeature_level() + "\ncar_steelprice: " + getSteelprice() +
                "\ncar_reg_fee: " + getReg_fee() + "\ncar_co2: " + getCo2() +
                "\ncar_faulty: " + getIsFaulty() + "\ncar_rented: " + getIsRented();
    }
}
