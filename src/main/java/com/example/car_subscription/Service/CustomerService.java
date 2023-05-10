package com.example.car_subscription.Service;

import com.example.car_subscription.Model.Customer;
import com.example.car_subscription.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    
    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> fetchAll() {
        return customerRepo.fetchAll();
    }

    public void addCustomer(Customer c){
        customerRepo.addCustomer(c);
    }

    public void editCustomer(int id, Customer c){
        customerRepo.editCustomer(id, c);
    }

    public Boolean deleteCustomer(int id){
        return customerRepo.deleteCustomer(id);
    }

}
