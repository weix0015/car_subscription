package com.example.car_subscription.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

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
    public String customerList() {
        return "Home/customerList";
    }

    @GetMapping("/createCustomer")
    public String createCustomer() {
        return "Home/createCustomer";
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
