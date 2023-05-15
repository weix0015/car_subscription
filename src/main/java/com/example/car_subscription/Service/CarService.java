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
        return (List<Car>) carRepo;
    }
}
