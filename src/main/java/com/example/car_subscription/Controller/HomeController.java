package com.example.car_subscription.Controller;

import com.example.car_subscription.Model.Car;
import com.example.car_subscription.Model.Customer;
import com.example.car_subscription.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// hello

// my name is Isaac

@Controller
public class HomeController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public String index() {
        return "Home/index";
    }

    @GetMapping("/data_registration")
    public String data_registration() {
        return "Home/data_registration";
    }

    @GetMapping("/index")
    public String back_index() {
        return "redirect:/";
    }

    @GetMapping("/customerList")
    public String customerList(Model model) {
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customerLists", customerList);
        return "Home/customerList";
    }

    // search bar / filter


    @GetMapping("/createCustomer")
    public String createCustomer() {
        return "Home/createCustomer";
    }

    // This method will delete the customer from the website.
    @GetMapping("/deleteCustomer/{customer_id}")
    public String deleteCustomer(@PathVariable("customer_id") int customer_id) {
        boolean delete = customerService.deleteCustomer(customer_id);
        if (delete) {
            return "redirect:/customerList";
        } else {
            return "redirect:/customerList";

        }
    }

    // update customer
    @GetMapping("/opdateCustomer/{customer_id}")
    public String updateCustomer(@PathVariable("customer_id") int customer_id, Model model) {
        model.addAttribute("customer", customerService.findCustomer_id(customer_id));
        return "Home/updateCustomer";
    }

    @PostMapping("/updateCustomerInfo")
    public String updateCustomerInfo(@ModelAttribute Customer customer) {
        customerService.updateCustomer(customer.getCustomer_id(), customer);
        return "redirect:/customerList";
    }



    @PostMapping("/createNewCustomer")
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customerList";
    }

    @PostMapping("/data_registration")
    public String back_data_registration() {
        return "redirect:/data_registration";
    }


    @GetMapping("/createAgreement")
    public String createContract() {
        return "Home/createAgreement";
    }

    @GetMapping("/damage_registration")
    public String damage_registration() {
        return "Home/damage_registration";
    }

    // method for carDamageList (missing backend in Car class, repo and service)
    @GetMapping("/carDamageList")
    public String carDamageList(Model model) {
        List<Car> carList = customerService.fetchAll();
        model.addAttribute("customerLists", customerList);
        return "Home/customerList";
    }

    @GetMapping("/business_view")
    public String business_view() {
        return "Home/business_view";
    }


}
