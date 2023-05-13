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

    public Customer findCustomer_id(int id) {
        return customerRepo.findCustomer_id(id);
    }

    public void updateCustomer(int id, Customer c){
        customerRepo.updateCustomer(id, c);
    }

    public Boolean deleteCustomer(int id){
        return customerRepo.deleteCustomer(id);
    }

}
