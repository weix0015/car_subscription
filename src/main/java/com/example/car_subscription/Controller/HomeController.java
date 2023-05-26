package com.example.car_subscription.Controller;

import com.example.car_subscription.Model.Car;
import com.example.car_subscription.Model.Customer;
import com.example.car_subscription.Model.DamageReport;
import com.example.car_subscription.Model.RentalAgreement;
import com.example.car_subscription.Service.CarService;
import com.example.car_subscription.Service.CustomerService;
import com.example.car_subscription.Service.DamageReportService;
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

    @Autowired
    DamageReportService damageReportService;

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

    // customerList back button
    @PostMapping("/data_registration")
    public String back_data_registration() {
        return "redirect:/data_registration";
    }

    // customerList createCustomer button
    @GetMapping("/createCustomer")
    public String createCustomer() {
        return "Home/createCustomer";
    }

    // createCustomer submit button
    @PostMapping("/createNewCustomer")
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customerList";
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

    // data_registration agreement button
    @GetMapping("/agreementList")
    public String agreementList(Model model) {
        List<RentalAgreement> agreementList = rentalAgreementService.fetchAllAgreements();
        model.addAttribute("agreementLists", agreementList);
        return "Home/agreementList";
    }

    // createAgreement button
    @GetMapping("/createAgreement")
    public String createAgreement() {
        return "Home/createAgreement";
    }

    // createAgreement submit button
    @PostMapping("/createNewAgreement")
    public String createAgreement(@ModelAttribute RentalAgreement rentalAgreement) {
        rentalAgreementService.addRentalAgreement(rentalAgreement);
        return "redirect:/agreementList";
    }

    // rentalAgreementList delete button
    @GetMapping("/deleteAgreement/{rentalAgreement_id}")
    public String deleteAgreement(@PathVariable("rentalAgreement_id") int rentalAgreement_id) {
        boolean delete = rentalAgreementService.deleteRentalAgreement(rentalAgreement_id);
        if (delete) {
            return "redirect:/agreementList";
        } else {
            return "redirect:/agreementList";
        }
    }

    // rentalAgreementList update button
    @GetMapping("/updateAgreement/{rentalAgreement_id}")
    public String updateAgreement(@PathVariable("rentalAgreement_id") int rentalAgreement_id, Model model) {
        model.addAttribute("agreement", rentalAgreementService.findRentalAgreement_id(rentalAgreement_id));
        return "Home/updateAgreement";
    }

    // updateAgreement submit button
    @PostMapping("/updateAgreementInfo")
    public String updateAgreementInfo(@ModelAttribute RentalAgreement rentalAgreement) {
        rentalAgreementService.updateRentalAgreement(rentalAgreement.getRentalagreement_id(), rentalAgreement);
        return "redirect:/agreementList";
    }

    // damageReportList
    @GetMapping("/damage_Report_List")
    public String damage_report_List(Model model) {
        List<DamageReport> damageReportList = damageReportService.fetchAll();
        model.addAttribute("damage_Report_Lists", damageReportList);
        return "Home/damage_Report_List";
    }


    // The backRow for the damage-Report_List.
    @PostMapping("/")
    public String back_damage_Report_List() {
        return "redirect:/";
    }

    // update damage report.
    @GetMapping("/update_Damage_Report/{damage_report_id}")
    public String update_Damage_Report
    (@PathVariable("damage_report_id") int damage_Report_id, Model model) {
        model.addAttribute("DamageReport", damageReportService.findeDamage_Report(damage_Report_id));
        return "Home/update_Damage_Report";
    }

    // submit update button for update damage report
    @PostMapping("/update_Damage_ReportInfo")
    public String update_Damage_Report_Info(@ModelAttribute DamageReport damageReport) {
        damageReportService.updateDamage_Report(damageReport.getDamage_report_id(), damageReport);
        return "redirect:/damage_Report_List";
    }

    // delete damage report
    @GetMapping("/deleteDamage/{damage_report_id}")
    public String delete_Damage_Report(@PathVariable("damage_report_id") int damage_Report) {
        boolean delete_Damage_Report = damageReportService.delete_report(damage_Report);
        if (delete_Damage_Report) {
            return "redirect:/damage_Report_List";
        } else {
            return "redirect:/damage_Report_List";
        }

    }

    // create Damage report
    @GetMapping("createDamage_Report")
    public String creatDamage() {
        return "Home/createDamage_Report";
    }

    // create damage report list
    @PostMapping("/addDamage")
    public String addContract(@ModelAttribute DamageReport damageReport) {
        damageReportService.addDamage_Report(damageReport);
        return "redirect:/damage_Report_List";
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

    // delete car button
    @GetMapping("/deleteCar/{car_id}")
    public String deleteCar(@PathVariable("car_id") int car_id) {
        boolean delete = carService.delete_car(car_id);
        if (delete) {
            return "redirect:/car_list";
        } else {
            return "redirect:/car_list";

        }
    }

    // business_view site list
    @GetMapping("/business_view")
    public String business_view(Model model) {
        // customer list
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customerLists", customerList);
        // rental agreement list
        List<RentalAgreement> rentalAgreementList = rentalAgreementService.fetchAllAgreements();
        model.addAttribute("agreementLists", rentalAgreementList);
        // totalSumPrice list
        List<RentalAgreement> totalSumPrice = rentalAgreementService.totalSumPrice();
        model.addAttribute("sum", totalSumPrice);
        // total car rented list
        List<Car> totalRentedCar = carService.rentedTotalCar();

        // total car not rented list
        List<Car> notRentedTotalCar = carService.notRentedTotalCar();
        return "Home/business_view";
    }
}
