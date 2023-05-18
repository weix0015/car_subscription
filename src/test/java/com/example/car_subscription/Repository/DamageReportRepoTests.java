package com.example.car_subscription.Repository;

import com.example.car_subscription.Model.DamageReport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class DamageReportRepoTests {
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

            damageReportRepo.add_damage_Report(damageReport);

            String sql = "INSERT INTO damage_report(customer_id, car_id, damage_description," +
                    "damage_price,damage_date)" +
                    "VALUES(?,?,?,?,?)";
            jdbcTemplate.update(sql, damageReport.getCustomer_id(), damageReport.getCar_id(),
                    damageReport.getDamage_description(), damageReport.getDamage_price(),
                    damageReport.getDamage_date());

            String selectSql = "SELECT * from damage_report WHERE customer_id = ?";
            RowMapper<DamageReport> rowMapper = new BeanPropertyRowMapper<>(DamageReport.class);
            List<DamageReport> result = jdbcTemplate.query(selectSql, rowMapper, 1);
            Assertions.assertNotEquals(0, result.size());
    }

}
