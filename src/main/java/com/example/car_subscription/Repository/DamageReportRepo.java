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

    public List<DamageReport> fetchAll() {
        String sql = "SELECT * FROM damage_report";
        RowMapper<DamageReport> rowMapper = new BeanPropertyRowMapper<>(DamageReport.class);
        return template.query(sql, rowMapper);
    }

    public boolean delete_report(int damage_report_id) {
        String sql = "DELETE FROM damage_report WHERE car_id=?";
        return template.update(sql, damage_report_id) > 0;
    }



}
