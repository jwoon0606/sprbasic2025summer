package com.thc.sprbasic2025summer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultPageController {

    @RequestMapping({"","/","/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/aaa")
    public String aaa(@RequestParam String name, String phone, Model model) {
        System.out.println("name : " + name);
        System.out.println("phone : " + phone);
        model.addAttribute("name", name);
        model.addAttribute("phone", "phone");
        return "aaa";
    }

    @RequestMapping("/calculator")
    public String calculator(String num1, String num2, Model model){
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        int int_num1 = Integer.parseInt(num1);
        int int_num2 = Integer.parseInt(num2);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        return "calculator";
    }

    @RequestMapping("/calculator2")
    public String calculator2(int num1, int num2, Model model) {
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        return "calculator";
    }

}
