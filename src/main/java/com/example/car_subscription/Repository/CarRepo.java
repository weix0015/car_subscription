package com.example.car_subscription.Repository;

import com.example.car_subscription.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepo {
    // The new update
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
        String sql = "INSERT INTO car(vin,model,brand,plate,feature_level,steelprice,reg_fee,co2,isFaulty,isRented) " +
                "VALUE(?,?,?,?,?,?,?,?,?,?)";
        template.
                update(sql, car.
                                getVin(),
                        car.getModel(),
                        car.getBrand(),
                        car.getPlate(),
                        car.getFeature_level(),
                        car.getSteelprice(),
                        car.getReg_fee(),
                        car.getCo2(),
                        car.getIsFaulty(),
                        car.getIsRented());
    }

    // find Car by car_id
    public Car findCar(int car_id) {
        String sql = "SELECT * FROM car WHERE car_id=?";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        Car car_find =
                template.queryForObject(sql, rowMapper, car_id);
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
                "co2=?,isFaulty=?,isRented=? WHERE car_id = ?";
        template.update(sql,
                car.getVin(),
                car.getModel(),
                car.getBrand(),
                car.getPlate(),
                car.getFeature_level(),
                car.getSteelprice(),
                car.getReg_fee(),
                car.getCo2(),
                car.getIsFaulty(),
                car.getIsRented(),
                car.getCar_id());
    }

    public Car search() {
        String sql = "SELECT * FROM car WHERE vin LIKE%?1%" +
                "OR model LIKE%?1%" +
                "OR brand LIKE%?1%" +
                "OR plate LIKE%?1%" +
                "OR feature_level LIKE%?1%" +
                "OR steelprice LIKE%?1%" +
                "OR reg_fee LIKE%?1%" +
                "OR co2 LIKE%?1%" +
                "OR isFaulty LIKE%?1%" +
                "OR isRented LIKE%?1%";
        RowMapper<Car>rowMapper=new SingleColumnRowMapper<>(Car.class);

        return (Car) template.query(sql,rowMapper);
    }


}
