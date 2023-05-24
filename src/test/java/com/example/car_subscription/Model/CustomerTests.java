package com.example.car_subscription.Model;

import org.junit.jupiter.api.Test;

public class CustomerTests {
    Customer customer = new Customer();

    @Test
    public void testCar() {
        // test setters
        customer.setCustomer_id(1);
        customer.setFirst_name("Isaac");
        customer.setLast_name("Levy");
        customer.setAddress("København");
        customer.setZipcode(2600);
        customer.setMail("levy@gmail.com");

        // test getters
        assert customer.getCustomer_id() == 1;
        assert customer.getFirst_name().equals("Isaac");
        assert customer.getLast_name().equals("Levy");
        assert customer.getAddress().equals("København");
        assert customer.getZipcode() == 2600;
        assert customer.getMail().equals("levy@gmail.com");

        // Print out the car object to check the tests
        System.out.println(customer.toString());
    }
}
