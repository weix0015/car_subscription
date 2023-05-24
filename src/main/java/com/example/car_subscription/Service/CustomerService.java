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

    // everything from Customer
    public List<Customer> fetchAll() {
        return customerRepo.fetchAll();
    }

    // add Customer
    public void addCustomer(Customer c) {
        customerRepo.addCustomer(c);
    }

    // find Customer by id
    public Customer findCustomer_id(int id) {
        return customerRepo.findCustomer_id(id);
    }

    // update Customer
    public void updateCustomer(int id, Customer c) {
        customerRepo.updateCustomer(id, c);
    }

    // delete Customer
    public Boolean deleteCustomer(int id) {
        return customerRepo.deleteCustomer(id);
    }

}
