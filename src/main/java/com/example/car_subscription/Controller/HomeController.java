package com.example.car_subscription.Controller;

import com.example.car_subscription.Model.Car;
import com.example.car_subscription.Model.Customer;
import com.example.car_subscription.Model.RentalAgreement;
import com.example.car_subscription.Service.CarService;
import com.example.car_subscription.Service.CustomerService;
import com.example.car_subscription.Service.RentalAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CustomerService customerService;

    @Autowired
    CarService carService;

    @Autowired
    RentalAgreementService rentalAgreementService;

    // main menu
    @GetMapping("/")
    public String index() {
        return "Home/index";
    }

    // data_registration site
    @GetMapping("/data_registration")
    public String data_registration() {
        return "Home/data_registration";
    }

    // data_registration back button
    @GetMapping("/index")
    public String back_index() {
        return "redirect:/";
    }

    // createCustomer back button
    @GetMapping("/customerList")
    public String customerList(Model model) {
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customerLists", customerList);
        return "Home/customerList";
    }

    // data_registration agreement button
    @GetMapping("/agreementList")
    public String agreementList(Model model) {
        List<RentalAgreement> agreementList = rentalAgreementService.fetchAllAgreements();
        model.addAttribute("agreementLists", agreementList);
        return "Home/createAgreement";
    }

    // customerList createCustomer button
    @GetMapping("/createCustomer")
    public String createCustomer() {
        return "Home/createCustomer";
    }

    // customerList delete button
    @GetMapping("/deleteCustomer/{customer_id}")
    public String deleteCustomer(@PathVariable("customer_id") int customer_id) {
        boolean delete = customerService.deleteCustomer(customer_id);
        if (delete) {
            return "redirect:/customerList";
        } else {
            return "redirect:/customerList";

        }
    }

    // rentalAgreementList delete button
    @GetMapping("/deleteAgreement/{rentalAgreement_id}")
    public String deleteAgreement(@PathVariable("rentalAgreement_id") int rentalAgreement_id) {
        boolean delete = rentalAgreementService.deleteRentalAgreement(rentalAgreement_id);
        if (delete) {
            return "redirect:/createAgreement";
        } else {
            return "redirect:/createAgreement";

        }
    }

    // rentalAgreementList update button
    @GetMapping("/updateAgreement/{rentalAgreement_id}")
    public String updateAgreement(@PathVariable("rentalAgreement_id") int rentalAgreement_id, Model model) {
        model.addAttribute("agreement", rentalAgreementService.findRentalAgreement_id(rentalAgreement_id));
        return "Home/createAgreement";
    }

    // updateAgreement submit button
    @PostMapping("/updateAgreementInfo")
    public String updateAgreementInfo(@ModelAttribute RentalAgreement rentalAgreement) {
        rentalAgreementService.updateRentalAgreement(rentalAgreement.getRentalagreement_id(), rentalAgreement);
        return "redirect:/createAgreement";
    }

    // customerList update button
    @GetMapping("/updateCustomer/{customer_id}")
    public String updateCustomer(@PathVariable("customer_id") int customer_id, Model model) {
        model.addAttribute("customer", customerService.findCustomer_id(customer_id));
        return "Home/updateCustomer";
    }

    // updateCustomer submit button
    @PostMapping("/updateCustomerInfo")
    public String updateCustomerInfo(@ModelAttribute Customer customer) {
        customerService.updateCustomer(customer.getCustomer_id(), customer);
        return "redirect:/customerList";
    }

    // createCustomer submit button
    @PostMapping("/createNewCustomer")
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customerList";
    }

    // customerList back button
    @PostMapping("/data_registration")
    public String back_data_registration() {
        return "redirect:/data_registration";
    }

    // data_registration agreement button
    @GetMapping("/createAgreement")
    public String createAgreement() {
        return "Home/createAgreement";

    }

    // damage_registration site
    @GetMapping("/damage_registration")
    public String damage_registration() {
        return "Home/damage_registration";
    }

    // The new method for going to the damage report_list. The get method.
    @GetMapping("/damage_Report_List")
    public String damage_report_List() {
        return "Home/damage_Report_List";
    }

    // The backRow for the damage-Report_List.
    @PostMapping("/")
    public String back_damage_Report_List() {
        return "redirect:/";
    }

    // damage_registration car button
    @GetMapping("/car_list")
    public String carList(Model model) {
        List<Car> car_List = carService.fetchAll();
        model.addAttribute("carLists", car_List);
        return "Home/car_list";
    }

    // car_list createCar button
    @GetMapping("createCar")
    public String createCar() {
        return "Home/createCar";
    }

    // addCar submit button
    @PostMapping("/addCar")
    public String addCar(@ModelAttribute Car car) {
        carService.addCar(car);
        return "redirect:/car_list";
    }

    // car_list updateCar button
    @GetMapping("/updateCar/{car_id}")
    public String updateCar(@PathVariable("car_id") int car_id, Model model) {
        var cars = carService.find_car(car_id);
        System.out.println(cars);
        model.addAttribute("car", cars);
        return "Home/updateCar";
    }

    // updateCar submit button
    @PostMapping("/updateCarInfo")
    public String updateCarInfo(@ModelAttribute Car car) {
        carService.updateCar(car.getCar_id(), car);
        return "redirect:/car_list";
    }

    // the method will delete the car from the car list.
    @GetMapping("/deleteCar/{car_id}")
    public String deleteCar(@PathVariable("car_id") int car_id) {
        boolean delete = carService.delete_car(car_id);
        if (delete) {
            return "redirect:/car_list";
        } else {
            return "redirect:/car_list";

        }
    }

    // business_view site
    @GetMapping("/business_view")
    public String business_view() {
        return "Home/business_view";
    }
}
