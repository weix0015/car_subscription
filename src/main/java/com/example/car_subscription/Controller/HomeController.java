package com.example.car_subscription.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/damage_registration")
    public String damage_registration() {
        return "Home/damage_registration";
    }

    @GetMapping("/business_view")
    public String business_view() {
        return "Home/business_view";
    }




}
