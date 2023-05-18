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

    public List<DamageReport> fetchAll()

    {
        return damageReportRepo.fetchAll();
    }
    // This method will add the new damage (This make connection between the repo and the service)
    public void addDamage_Report(DamageReport damageReport)
    {
      damageReportRepo.add_damage_Report(damageReport);
    }
    // find the damage report by the id.
    public DamageReport findeDamage_Report(int damage_Report)
    {
     return damageReportRepo.findDamage_Report(damage_Report);
    }

    // This method will delete the report by the id.
    public boolean delete_report(int damage_report_id)
    {
        return damageReportRepo.delete_report(damage_report_id);
    }
    // This method will update the damage_Report.
    public void updateDamage_Report(int damage_Report, DamageReport damageReport)
    {
     damageReportRepo.updateDamage_Report(damage_Report,damageReport);
    }



}
