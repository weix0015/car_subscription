package com.example.car_subscription.Service;

import com.example.car_subscription.Model.RentalAgreement;
import com.example.car_subscription.Repository.RentalAgreementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalAgreementService {

    @Autowired
    RentalAgreementRepo rentalAgreementRepo;

    // everything from RentalAgreement
    public List<RentalAgreement> fetchAllAgreements() {
        return rentalAgreementRepo.fetchAllAgreements();
    }

    // add RentalAgreement
    public void addRentalAgreement(RentalAgreement a) {
        rentalAgreementRepo.addRentalAgreement(a);
    }

    // find RentalAgreement by id
    public RentalAgreement findRentalAgreement_id(int id) {
        return rentalAgreementRepo.findRentalAgreement_id(id);
    }

    // delete RentalAgreement
    public boolean deleteRentalAgreement(int id) {
        return rentalAgreementRepo.deleteRentalAgreement(id);
    }

    // update RentalAgreement
    public void updateRentalAgreement(int id, RentalAgreement a) {
        rentalAgreementRepo.updateRentalAgreement(id, a);
    }

    // totalSum for monthly_price rentalagreement
    public List<RentalAgreement> totalSumPrice() {
        return rentalAgreementRepo.totalSumPrice();
    }
}
