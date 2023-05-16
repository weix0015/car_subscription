package com.example.car_subscription.Service;

import com.example.car_subscription.Model.Car;
import com.example.car_subscription.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepo carRepo;

    public List<Car> fetchAll() {
        return carRepo.fetchAll();
    }

    public void addCar(Car car) {
        carRepo.addCar(car);

    }

    public void find_car(int car_id) {
        carRepo.findCar(car_id);
    }

    public Boolean delete_car(int car_id) {
        return carRepo.delete_car(car_id);
    }

    public void updateCar(int car, Car c) {
        carRepo.updateCar(car, c);
    }
}
