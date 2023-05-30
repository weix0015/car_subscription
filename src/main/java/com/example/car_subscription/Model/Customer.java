package com.example.car_subscription.Model;

public class Customer {

    // attributes
    private int customer_id;
    private String first_name;
    private String last_name;
    private String address;
    private int zipcode;
    private String city;
    private String mail;

    // constructor
    public Customer(int customer_id, String first_name, String last_name,
                    String address, int zipcode, String city, String mail) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.mail = mail;
    }

    // empty constructor
    public Customer() {

    }

    // getter
    public int getCustomer_id() {
        return customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getMail() {
        return mail;
    }

    // setter
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    // toString to CustomerRepoTests
    @Override
    public String toString() {
        return "Customer:\ncustomer_id = " + getCustomer_id() + "\nfirst_name: " + getFirst_name() +
                "\nlast_name: " + getLast_name()
                + "\naddress: " + getAddress() + "\nzipcode: " + getZipcode() +
                "\ncity: " + getCity() + "\nmail: " + getMail();
    }
}
