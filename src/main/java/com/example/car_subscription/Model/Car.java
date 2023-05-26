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
    private boolean faulty;
    private boolean rented;

    private String answer;

    private int rentedCar;

    private int notRentedCar;

    // convert isFaulty
    public String convertFaulty() {
        if (faulty == true) {
            return "Ja";
        } else if (!faulty) {
            return "Nej";
        }
        return answer;
    }

    public String convertRented() {
        if (rented == true) {
            return "Ja";
        } else if (!rented) {
            return "Nej";
        }
        return answer;
    }



    // constructor
    public Car(int car_id, String vin, String model, String brand, String plate, String feature_level,
               int steelprice, int reg_fee, int co2, boolean faulty, boolean rented, String answer) {
        this.car_id = car_id;
        this.vin = vin;
        this.model = model;
        this.brand = brand;
        this.plate = plate;
        this.feature_level = feature_level;
        this.steelprice = steelprice;
        this.reg_fee = reg_fee;
        this.co2 = co2;
        this.faulty = faulty;
        this.rented = rented;
        this.answer = answer;
    }

    // constructor for rentedCar and notRentedCar
    public Car(int rentedCar, int notRentedCar) {
        this.rentedCar = rentedCar;
        this.notRentedCar = notRentedCar;
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

    public boolean isFaulty() {
        return faulty;
    }

    public boolean isRented() {
        return rented;
    }

    public String getAnswer() {
        return answer;
    }

    public int getRentedCar() {
        return rentedCar;
    }

    public int getNotRentedCar() {
        return notRentedCar;
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

    public void setFaulty(boolean faulty) {
        this.faulty = faulty;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setRentedCar(int rentedCar) {
        this.rentedCar = rentedCar;
    }

    public void setNotRentedCar(int notRentedCar) {
        this.notRentedCar = notRentedCar;
    }

    // toString to CarTests
    @Override
    public String toString() {
        return "Car:\ncar_id = " + getCar_id() + "\ncar_vin: " + getVin() + "\ncar_model: " + getModel()
                + "\ncar_brand: " + getBrand() + "\ncar_plate: " + getPlate() +
                "\ncar_feature_level: " + getFeature_level() + "\ncar_steelprice: " + getSteelprice() +
                "\ncar_reg_fee: " + getReg_fee() + "\ncar_co2: " + getCo2() +
                "\ncar_faulty: " + isFaulty() + "\ncar_rented: " + isRented();
    }
}
