package com.example.car_subscription.Model;

import org.junit.jupiter.api.Test;

public class CarTests {
    Car car = new Car();
    @Test
    public void testCar() {
        // test setters
        car.setCar_id(1);
        car.setVin("112FBASDFG");
        car.setModel("Tesla");
        car.setBrand("V2");
        car.setPlate("AF54539");
        car.setFeature_level("Advanced");
        car.setSteelprice(8500);
        car.setReg_fee(1000);
        car.setCo2(0);
        car.setFaulty(false);
        car.setRented(false);

        // test getters
        assert car.getCar_id() == 1;
        assert car.getVin().equals("112FBASDFG");
        assert car.getModel().equals("Tesla");
        assert car.getBrand().equals("V2");
        assert car.getPlate().equals("AF54539");
        assert car.getFeature_level().equals("Advanced");
        assert car.getSteelprice() == 8500;
        assert car.getReg_fee() == 1000;
        assert car.getCo2() == 0;
        assert car.isFaulty() == false;
        assert car.isRented() == false;

        // Print out the car object to check the tests
        System.out.println(car.toString());
    }
}
