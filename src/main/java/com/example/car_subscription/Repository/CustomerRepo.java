package com.example.car_subscription.Repository;

import com.example.car_subscription.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {

    @Autowired
    JdbcTemplate template;

    // constructor with JdbcTemplate parameter for junit test
    @Autowired
    public CustomerRepo(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    // everything from customer table
    public List<Customer> fetchAll() {
        String sql = "SELECT * FROM customer";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }

    // add customer to customer table
    public void addCustomer(Customer c) {
        String sql = "INSERT INTO customer(first_name, last_name, address, zipcode, city, mail, customer_id)" +
                "VALUES(?,?,?,?,?,?,?)";
        template.update(sql, c.getFirst_name(), c.getLast_name(), c.getAddress(), c.getZipcode(), c.getCity(),
                c.getMail(), c.getCustomer_id());
    }

    // find customer by customer_id
    public Customer findCustomer_id(int id) {
        String sql = "SELECT * FROM customer WHERE customer_id = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer customer = template.queryForObject(sql, rowMapper, id);
        return customer;
    }

    // delete customer from customer table
    public Boolean deleteCustomer(int id) {
        String sql = "DELETE FROM customer WHERE customer_id = ?";
        return template.update(sql, id) > 0;
    }

    // update customer into customer table
    public void updateCustomer(int id, Customer c) {
        String sql = "UPDATE customer SET first_name = ?, last_name = ?, address = ?, " +
                "zipcode = ?, city = ?, mail = ? WHERE customer_id= ?";
        template.update(sql, c.getFirst_name(), c.getLast_name(), c.getAddress(), c.getZipcode(), c.getCity(),
                c.getMail(), c.getCustomer_id());
    }

}
