package com.example.car_subscription.Model;

public class DamageReport {

    // attributes
    private int damage_report_id;
    private int customer_id;
    private int car_id;
    private String damage_description;
    private int damage_price;
    private String damage_date;

    // constructor
    public DamageReport(int damage_report_id,
                        int customer_id, int car_id,
                        String damage_description,
                        int damage_price,
                        String damage_date) {
        this.damage_report_id = damage_report_id;
        this.customer_id = customer_id;
        this.car_id = car_id;
        this.damage_description = damage_description;
        this.damage_price = damage_price;
        this.damage_date = damage_date;
    }

    // empty constructor.
    public DamageReport() {

    }

    // getter
    public int getDamage_report_id() {
        return damage_report_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public String getDamage_description() {
        return damage_description;
    }

    public int getDamage_price() {
        return damage_price;
    }

    public String getDamage_date() {
        return damage_date;
    }

    // setter
    public void setDamage_report_id(int damage_report_id) {
        this.damage_report_id = damage_report_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public void setDamage_description(String damage_description) {
        this.damage_description = damage_description;
    }

    public void setDamage_price(int damage_price) {
        this.damage_price = damage_price;
    }

    public void setDamage_date(String damage_date) {
        this.damage_date = damage_date;
    }

    // toString to DamageReportRepoTests
    @Override
    public String toString() {
        return "DamageReport:\ndamage_report_id = " + getDamage_report_id() + "\ncustomer_id: " + getCustomer_id() +
                "\ncar_id: " + getCar_id() + "\ndamage_description: " + getDamage_description() +
                "\ndamage_price: " + getDamage_price() +
                "\ndamage_date: " + getDamage_date();
    }
}
