package com.example.car_subscription.Model;

public class RentalAgreement {
    private int rentalagreement_id;
    private int customer_id;
    private int car_id;
    private boolean isLimited;
    private String rental_date;
    private int monthly_price;


    public RentalAgreement(int rentalagreement_id, int customer_id, int car_id, boolean isLimited,
                           String rental_date, int monthly_price) {
        this.rentalagreement_id = rentalagreement_id;
        this.customer_id = customer_id;
        this.car_id = car_id;
        this.isLimited = isLimited;
        this.rental_date = rental_date;
        this.monthly_price = monthly_price;
    }

    public RentalAgreement() {

    }

    public int getRentalagreement_id() {
        return rentalagreement_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public boolean isLimited() {
        return isLimited;
    }

    public String getRental_date() {
        return rental_date;
    }

    public int getMonthly_price() {
        return monthly_price;
    }

    public void setRentalagreement_id(int rentalagreement_id) {
        this.rentalagreement_id = rentalagreement_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public void setLimited(boolean limited) {
        isLimited = limited;
    }

    public void setRental_date(String rental_date) {
        this.rental_date = rental_date;
    }

    public void setMonthly_price(int monthly_price) {
        this.monthly_price = monthly_price;
    }

    // toString to RentalAgreementTests
    @Override
    public String toString() {
        return "Customer:\nrentalagreement_id = " + getRentalagreement_id() + "\ncustomer_id: " + getCustomer_id() +
                "\ncar_id: " + getCar_id()
                + "\nisLimited: " + isLimited() + "\nrental_date: " + getRental_date() +
                "\nmonthly_price: " + getMonthly_price();
    }
}
