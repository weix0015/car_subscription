package com.example.car_subscription.Service;

import com.example.car_subscription.Model.DamageReport;
import com.example.car_subscription.Repository.DamageReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageReportService {

    @Autowired
    DamageReportRepo damageReportRepo;

    // everything from damage_report
    public List<DamageReport> fetchAll() {
        return damageReportRepo.fetchAll();
    }

    // add damage_report
    public void addDamage_Report(DamageReport damageReport) {
        damageReportRepo.add_damage_Report(damageReport);
    }

    // find damage_report by id
    public DamageReport findeDamage_Report(int damage_Report) {
        return damageReportRepo.findDamage_Report(damage_Report);
    }

    // delete damage_report
    public boolean delete_report(int damage_report_id) {
        return damageReportRepo.delete_report(damage_report_id);
    }

    // update damage_report
    public void updateDamage_Report(int damage_Report, DamageReport damageReport) {
        damageReportRepo.updateDamage_Report(damage_Report, damageReport);
    }
}
