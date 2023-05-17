package com.example.car_subscription.Repository;

import com.example.car_subscription.Model.DamageReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DamageReportRepo {
    @Autowired
    JdbcTemplate template;

    // This method will Join(Inner) the car table and the damage_report table.
    public List<DamageReport> damageReportList() {
        String sql = "SELECT c.car_id, c.brand, d.damage_report_id,d.customer_id, d.car_id, d.damage_description, d.damage_price, d.damage_date" +
                "FROM car c JOIN damage_report d" +
                "ON c.car_id=d.car_id" +
                "ORDER BY model ASC;";
        RowMapper<DamageReport> rowMapper = new BeanPropertyRowMapper<>(DamageReport.class);
        return template.query(sql, rowMapper);
    }
    // Here this method will add the new damage.

    public boolean delete_report(int damage_report_id) {
        String sql = "DELETE FROM damage_report WHERE car_id=?";
        return template.update(sql, damage_report_id) > 0;
    }



}
