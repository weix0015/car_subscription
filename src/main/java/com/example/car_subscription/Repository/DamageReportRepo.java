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

    // constructor with JdbcTemplate parameter for junit test
    @Autowired
    public DamageReportRepo(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    public List<DamageReport> fetchAll() {
        String sql = "SELECT * FROM damage_report";
        RowMapper<DamageReport> rowMapper = new BeanPropertyRowMapper<>(DamageReport.class);
        return template.query(sql, rowMapper);
    }

    public void add_damage_Report(DamageReport damageReport)
    {
        String sql = "INSERT INTO damage_report(damage_report_id,customer_id,car_id,damage_description," +
                "damage_price,damage_date)" +
                "VALUES(?,?,?,?,?,?)";
        template.update(sql,
                damageReport.getDamage_report_id(),
                damageReport.getCustomer_id(),
                damageReport.getCar_id(),
                damageReport.getDamage_description(),
                damageReport.getDamage_price(),
                damageReport.getDamage_date());
    }

    public DamageReport findDamage_Report(int damage_Report_id)
    {
    String sql="SELECT* FROM damage_report WHERE damage_report_id=?";
    RowMapper<DamageReport>damageReportRowMapper=new BeanPropertyRowMapper<>(DamageReport.class);
    DamageReport damageReport_find=
            template.queryForObject(sql,damageReportRowMapper,damage_Report_id);
    return damageReport_find;
    }


    public boolean delete_report(int damage_report_id)
    {
        String sql = "DELETE FROM damage_report WHERE damage_report_id=?";
        return template.update(sql, damage_report_id) > 0;
    }
    public void updateDamage_Report(int damage_Report_id, DamageReport damageReport)
    {
    String sql="UPDATE damage_report set customer_id=?,car_id=?,damage_description=?, " +
            "damage_price=?,damage_date=? WHERE damage_report_id = ?";
    template.update(sql,damageReport.getCustomer_id(),
            damageReport.getCar_id(),
            damageReport.getDamage_description(),
            damageReport.getDamage_price(),
            damageReport.getDamage_date(),
            damageReport.getDamage_report_id());

    }


}
