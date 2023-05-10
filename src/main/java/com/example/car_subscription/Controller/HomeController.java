package com.example.car_subscription.Controller;

import com.example.car_subscription.Model.Customer;
import com.example.car_subscription.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        List<Customer>customerList=customerService.fetchAll();
        model.addAttribute("customerLists",customerList);
        return "Home/customerList";
    }
    /*@PostMapping("/customerList")
    public String showCustomer(Model model) {
        List<Customer>customerList=customerService.fetchAll();
        System.out.println(customerList);
     model.addAttribute("customerLists",customerList);
     return "Home/customerList";
    }*/

    @GetMapping("/createCustomer")
    public String createCustomer() {
        return "Home/createCustomer";
    }

    @PostMapping("/createNewCustomer")
    public String createCustomer(@ModelAttribute Customer customer){
        customerService.addCustomer(customer);
        return "redirect:/customerList";
    }

    @PostMapping("/data_registration")
    public String back_data_registration() {
      return "redirect:/data_registration";
    }


    @GetMapping("/createContract")
    public String createContract() {
        return "Home/createContract";
    }

    @GetMapping("/damage_registration")
    public String damage_registration() {
        return "Home/damage_registration";
    }

    @GetMapping("/business_view")
    public String business_view() {
        return "Home/business_view";
    }


}
