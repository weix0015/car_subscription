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

    public List<Customer> fetchAll(){
    String sql = "SELECT * FROM oenske";
    RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
    return template.query(sql, rowMapper);
    }

    public void addCustomer(Customer c){
        String sql = "INSERT INTO customer(first_name, last_name, address, zipcode, city, mail, customer_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, c.getFirst_name(), c.getLast_name(), c.getAddress(), c.getZipcode(),
                c.getCity(), c.getMail(), c.getCustomer_id());
    }

    public Boolean deleteCustomer(int id){
        String sql = "DELETE FROM customer WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    public void editCustomer(int id, Customer c){
        String sql = "UPDATE customer SET first_name = ?, last_name = ?, address = ?, " +
                "zipcode = ?, city = ?, mail = ? WHERE id = ?";
        template.update(sql, c.getFirst_name(), c.getLast_name(), c.getAddress(), c.getZipcode(),
                c.getCity(), c.getMail(), c.getCustomer_id());
    }

}
