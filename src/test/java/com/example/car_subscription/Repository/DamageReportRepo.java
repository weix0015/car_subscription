package com.example.car_subscription.Repository;

import com.example.car_subscription.Model.Customer;
import com.example.car_subscription.Model.DamageReport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class DamageReportRepo {
        private JdbcTemplate jdbcTemplate;
        private DamageReportRepo damageReportRepo;

        @BeforeEach
        public void setup() {
            // Set up the JdbcTemplate
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/car_subscription");
            dataSource.setUsername("root");
            dataSource.setPassword("sesame80");
            jdbcTemplate = new JdbcTemplate(dataSource);

            damageReportRepo = new DamageReportRepo(jdbcTemplate);
        }

        @Test
        public void testAddDamageReport() {
            // Create a test car
            DamageReport damageReport = new DamageReport();
            damageReport.setCustomer_id(1);
            damageReport.setCar_id(1);
            damageReport.setDamage_description("Vindue ødelagt");
            damageReport.setDamage_price(2500);
            damageReport.setDamage_date("2023-05-01");

            damageReportRepo.addCustomer(customer);

            String sql = "INSERT INTO customer(first_name, last_name, address, zipcode, city, mail)" +
                    "VALUE(?,?,?,?,?,?)";
            jdbcTemplate.update(sql, customer.getFirst_name(), customer.getLast_name(), customer.getAddress(),
                    customer.getZipcode(), customer.getCity(), customer.getMail());

            String selectSql = "SELECT * from customer WHERE first_name = ?";
            RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
            List<Customer> result = jdbcTemplate.query(selectSql, rowMapper, "Peter");
            Assertions.assertNotEquals(0, result.size());
    }

}
