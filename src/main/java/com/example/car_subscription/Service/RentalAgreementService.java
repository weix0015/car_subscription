package com.example.car_subscription.Service;

import com.example.car_subscription.Model.RentalAgreement;
import com.example.car_subscription.Repository.RentalAgreementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalAgreementService {

    RentalAgreementRepo rentalAgreementRepo;

   public List<RentalAgreement> fetchAllAgreements(){
       return rentalAgreementRepo.fetchAllAgreements();
   }

   public void newRentalAgreement(RentalAgreement a){
       rentalAgreementRepo.newRentalAgreement(a);
   }




}
