package com.example.car_subscription.Model;

import org.junit.jupiter.api.Test;

public class RentalAgreementTests {
    RentalAgreement rentalAgreement = new RentalAgreement();

    @Test
    public void testCar() {
        // test setters
        rentalAgreement.setRentalagreement_id(1);
        rentalAgreement.setCustomer_id(1);
        rentalAgreement.setCar_id(1);
        rentalAgreement.setLimited(false);
        rentalAgreement.setRental_date("10/10/2023");
        rentalAgreement.setMonthly_price(8500);

        // test getters
        assert rentalAgreement.getRentalagreement_id() == 1;
        assert rentalAgreement.getCustomer_id() == 1;
        assert rentalAgreement.getCar_id() == 1;
        assert rentalAgreement.isLimited() == false;
        assert rentalAgreement.getRental_date().equals("10/10/2023");
        assert rentalAgreement.getMonthly_price() == 8500;

        // Print out the car object to check the tests
        System.out.println(rentalAgreement.toString());
    }
}
