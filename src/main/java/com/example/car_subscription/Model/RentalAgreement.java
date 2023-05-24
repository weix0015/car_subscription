package com.example.car_subscription.Model;

public class RentalAgreement {

    // attributes
    private int rentalagreement_id;
    private int customer_id;
    private int car_id;
    private boolean isLimited;
    private String rental_date;
    private int monthly_price;
    private int total_sum;

    // constructor
    public RentalAgreement(int rentalagreement_id, int customer_id, int car_id, boolean isLimited,
                           String rental_date, int monthly_price) {
        this.rentalagreement_id = rentalagreement_id;
        this.customer_id = customer_id;
        this.car_id = car_id;
        this.isLimited = isLimited;
        this.rental_date = rental_date;
        this.monthly_price = monthly_price;
    }

    // constructor for total_sum
    public RentalAgreement(int total_sum) {
        this.total_sum = total_sum;
    }

    // empty constructor
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

    public int getTotal_sum() {
        return total_sum;
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

    public void setTotal_sum(int total_sum) {
        this.total_sum = total_sum;
    }
}
