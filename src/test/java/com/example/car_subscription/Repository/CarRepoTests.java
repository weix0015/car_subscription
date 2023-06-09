package com.example.car_subscription.Repository;

import com.example.car_subscription.Model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class CarRepoTests {
    private JdbcTemplate jdbcTemplate;
    private CarRepo carRepo;

    // connection to mysql database
    @BeforeEach
    public void setup() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://eksamen23.mysql.database.azure.com/car_subscription");
        dataSource.setUsername("ditte");
        dataSource.setPassword("12SkoleTaktik !");
        jdbcTemplate = new JdbcTemplate(dataSource);

        carRepo = new CarRepo(jdbcTemplate);
    }

    // test create a new Car
    @Test
    public void testAddCar() {
        // Create a test car
        Car car = new Car();
        car.setVin("VIN123");
        car.setModel("Model1");
        car.setBrand("Brand1");
        car.setPlate("Plate1");
        car.setFeature_level("Basic");
        car.setSteelprice(1000);
        car.setReg_fee(50);
        car.setCo2(100);
        car.setFaulty(false);
        car.setRented(true);

        carRepo.addCar(car);

        String sql = "INSERT INTO car(vin,model,brand,plate,feature_level,steelprice,reg_fee,co2,faulty,rented) " +
                "VALUE(?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, car.getVin(), car.getModel(), car.getBrand(), car.getPlate(), car.getFeature_level(),
                car.getSteelprice(), car.getReg_fee(), car.getCo2(), car.isFaulty(), car.isRented());

        String selectSql = "SELECT * from car WHERE vin = ?";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        List<Car> result = jdbcTemplate.query(selectSql, rowMapper, "VIN123");
        Assertions.assertNotEquals(0, result.size());
        System.out.println(car.toString());
    }

}
