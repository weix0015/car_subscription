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

    public List<Car> fetchAll() {
        String sql = "SELECT* FROM car";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql, rowMapper);
    }


    public void addCar(Car car) {
        String sql = "INSERT INTO car(vin,model,brand,plate,feature_level,steelprice,reg_fee,co2,isFaulty,isRented" +
                "+VALUE(?,?,?,?,?,?,?,?,?,?,?,?)";
        template.update(sql, car.getVin(), car.getBrand(), car.getPlate(), car.getFeature_level(), car.getSteelprice(),
                car.getReg_fee(), car.getCo2(), car.isFaulty(), car.isRented());
    }

    public Car findeCar(int car_id) {
        String sql = "SELECT * FROM car WHERE car_id=?";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        Car car_finde = template.queryForObject(sql, rowMapper, car_id);
        return car_finde;
    }

    public Boolean delet_car(int car_id) {
        String sql = "DELETE * FROM car WHERE car_id=?";
        return template.update(sql, car_id) > 0;
    }

    public void updateCar(int car_id, Car car) {
        String sql = "UPDATE car SET vin=?,model=?,brand=?,plate=?,feature_level=?,steelprice=?,reg_fee=?," +
                "co2=?,isFaulty=?,isRented=?";
        template.update(sql, car.getVin(), car.getBrand(), car.getPlate(), car.getFeature_level(),
                car.getSteelprice(), car.getReg_fee(), car.getCo2(), car.isFaulty(), car.isRented());
    }


}
