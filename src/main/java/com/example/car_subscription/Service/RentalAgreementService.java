package com.example.car_subscription.Service;

import com.example.car_subscription.Model.RentalAgreement;
import com.example.car_subscription.Repository.RentalAgreementRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalAgreementService {

    RentalAgreementRepo rentalAgreementRepo;

   public List<RentalAgreement> fetchAllAgreements(){
       return rentalAgreementRepo.fetchAllAgreements();
   }

   public void newRentalAgreement(RentalAgreement a){
       rentalAgreementRepo.addRentalAgreement(a);
   }

   public boolean deleteAgreement(int id){
       return rentalAgreementRepo.deleteRentalAgreement(id);
   }

    public RentalAgreement findrentalAgreement_id(int id) {
        return rentalAgreementRepo.findRentalAgreement_id(id);
    }

   public void editRentalAgreement(int id, RentalAgreement a){
       rentalAgreementRepo.updateRentalAgreement(id, a);
   }




}
