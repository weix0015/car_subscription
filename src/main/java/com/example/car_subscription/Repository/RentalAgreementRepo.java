package com.example.car_subscription.Repository;

import com.example.car_subscription.Model.RentalAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalAgreementRepo {

    @Autowired
    JdbcTemplate template;

    // everything from rentalagreement table
    public List<RentalAgreement> fetchAllAgreements() {
        String sql = "SELECT * FROM rentalagreement";
        RowMapper<RentalAgreement> rowMapper = new BeanPropertyRowMapper<>(RentalAgreement.class);
        return template.query(sql, rowMapper);
    }

    // add rentalagreement into rentalagreement table
    public void addRentalAgreement(RentalAgreement a) {
        String sql = "INSERT INTO rentalagreement(rentalagreement_id, customer_id, car_id, " +
                "isLimited, rental_date, monthly_price) VALUES(?,?,?,?,?,?)";
        template.update(sql, a.getRentalagreement_id(), a.getCustomer_id(), a.getCar_id(),
                a.isLimited(), a.getRental_date(), a.getMonthly_price());
    }

    // find rentalagreement by rentalagreement_id
    public RentalAgreement findRentalAgreement_id(int id) {
        String sql = "SELECT * FROM rentalAgreement WHERE rentalAgreement_id = ?";
        RowMapper<RentalAgreement> rowMapper = new BeanPropertyRowMapper<>(RentalAgreement.class);
        RentalAgreement rentalAgreement = template.queryForObject(sql, rowMapper, id);
        return rentalAgreement;
    }

    // delete rentalagreement from rentalagreement table
    public Boolean deleteRentalAgreement(int id) {
        String sql = "DELETE FROM rentalagreement WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    // update rentalagreement into rentalagreement table
    public void updateRentalAgreement(int id, RentalAgreement a) {
        String sql = "UPDATE rentalagreement SET rentalagreement_id = ?, customer_id = ?, car_id = ?, " +
                "isLimited = ?, rental_date = ?, monthly_price = ? WHERE id = ?";
        template.update(sql, a.getRentalagreement_id(), a.getCustomer_id(), a.getCar_id(),
                a.isLimited(), a.getRental_date(), a.getMonthly_price());
    }


}
