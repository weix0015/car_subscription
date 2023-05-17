package com.example.car_subscription.Service;

import com.example.car_subscription.Model.DamageReport;
import com.example.car_subscription.Repository.DamageReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageReportService {

    @Autowired
    DamageReportRepo damageReportRepo;

    public List<DamageReport> fetchAll() {
        return damageReportRepo.fetchAll();
    }

    public List<DamageReport> damageReportList() {
        return damageReportRepo.damageReportList();
    }

    public boolean delete_report(int damage_report_id) {
        return damageReportRepo.delete_report(damage_report_id);
    }

}
