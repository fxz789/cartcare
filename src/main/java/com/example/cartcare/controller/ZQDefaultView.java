package com.example.cartcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ZQDefaultView {

    @RequestMapping("/")
    public String index (Model model){
        return "forward:/Home/index";
    }
}