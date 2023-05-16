package com.example.car_subscription.Repository;

import com.example.car_subscription.Model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSet;

public class CarRepoTests {
    private JdbcTemplate jdbcTemplate;
    private CarRepo carRepo;

    @BeforeEach
    public void setup() {
        // Set up the JdbcTemplate
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/car_subscription");
        dataSource.setUsername("root");
        dataSource.setPassword("sesame80");
        jdbcTemplate = new JdbcTemplate(dataSource);

        carRepo = new CarRepo(jdbcTemplate);
    }

    @Test
    public void testAddCar() {
        // Create a test car
        Car car = new Car();
        car.setVin("VIN123");
        car.setModel("Model1");
        car.setBrand("Brand1");
        car.setPlate("Plate1");
        car.setFeature_level("High");
        car.setSteelprice(1000);
        car.setReg_fee(50);
        car.setCo2(100);
        car.setFaulty(0);
        car.setRented(0);

        carRepo.addCar(car);

        String sql = "SELECT * FROM car WHERE vin = ?";
        ResultSetWrappingSqlRowSet rowSet = (ResultSetWrappingSqlRowSet) jdbcTemplate.queryForRowSet(sql, car.getVin());
        Car retrievedCar = mapRowSetToCar(rowSet);

        Assertions.assertEquals(car.getVin(), retrievedCar.getVin());
        Assertions.assertEquals(car.getModel(), retrievedCar.getModel());
        Assertions.assertEquals(car.getBrand(), retrievedCar.getBrand());
        Assertions.assertEquals(car.getPlate(), retrievedCar.getPlate());
        Assertions.assertEquals(car.getFeature_level(), retrievedCar.getFeature_level());
        Assertions.assertEquals(car.getSteelprice(), retrievedCar.getSteelprice());
        Assertions.assertEquals(car.getReg_fee(), retrievedCar.getReg_fee());
        Assertions.assertEquals(car.getCo2(), retrievedCar.getCo2());
        Assertions.assertEquals(car.isFaulty(), retrievedCar.isFaulty());
        Assertions.assertEquals(car.isRented(), retrievedCar.isRented());
    }

    private Car mapRowSetToCar(ResultSetWrappingSqlRowSet rowSet) {
        Car car = new Car();
        if (rowSet.next()) {
            car.setVin(rowSet.getString("vin"));
            car.setModel(rowSet.getString("model"));
            car.setBrand(rowSet.getString("brand"));
            car.setPlate(rowSet.getString("plate"));
            car.setFeature_level(rowSet.getString("feature_level"));
            car.setReg_fee(rowSet.getInt("reg_fee"));
        }
    }
}
