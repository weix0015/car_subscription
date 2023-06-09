package com.example.car_subscription.Repository;

import com.example.car_subscription.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepo {

    @Autowired
    JdbcTemplate template;

    // constructor with JdbcTemplate parameter for junit test
    @Autowired
    public CarRepo(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    // everything from car table
    public List<Car> fetchAll() {
        String sql = "SELECT * FROM car";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql, rowMapper);
    }

    // add cars into car table
    public void addCar(Car car) {
        String sql = "INSERT INTO car(vin,model,brand,plate,feature_level,steelprice,reg_fee,co2,faulty,rented) " +
                "VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, car.getVin(), car.getModel(), car.getBrand(), car.getPlate(), car.getFeature_level(),
                car.getSteelprice(), car.getReg_fee(), car.getCo2(), car.isFaulty(), car.isRented());
    }

    // find Car by car_id
    public Car findCar(int car_id) {
        String sql = "SELECT * FROM car WHERE car_id=?";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        Car car_find = template.queryForObject(sql, rowMapper, car_id);
        return car_find;
    }

    // delete car from car table
    public Boolean delete_car(int car_id) {
        String sql = "DELETE FROM car WHERE car_id=?";
        return template.update(sql, car_id) > 0;
    }


    // update car into car table
    public void updateCar(int car_id, Car car) {
        String sql = "UPDATE car SET vin=?,model=?,brand=?,plate=?,feature_level=?,steelprice=?,reg_fee=?," +
                "co2=?,faulty=?,rented=? WHERE car_id = ?";
        template.update(sql, car.getVin(), car.getModel(), car.getBrand(), car.getPlate(), car.getFeature_level(),
                car.getSteelprice(), car.getReg_fee(), car.getCo2(), car.isFaulty(), car.isRented(),
                car.getCar_id());
    }

    // total car rented in car table
    public List<Car> rentedTotalCar() {
        String sql = "SELECT COUNT(rented) AS rentedCar FROM car WHERE rented = 1;";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql, rowMapper);
    }

    // total car not rented in car table
    public List<Car> notRentedTotalCar() {
        String sql = "SELECT COUNT(rented) AS notRentedCar FROM car WHERE rented = 0;";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql, rowMapper);
    }
}
