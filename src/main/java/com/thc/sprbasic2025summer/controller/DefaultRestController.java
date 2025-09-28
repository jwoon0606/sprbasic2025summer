package com.thc.sprbasic2025summer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class DefaultRestController {

    @RequestMapping("/calculator")
    public Map<String, Object> calculator(int num1, int num2) {
        Map<String, Object> map = new HashMap<>();
        map.put("sum",num1+num2);
        return map;
    }

    @RequestMapping("/calculator2")
    public Map<String, Object> calculator2(int num1, int num2) {
        Map<String, Object> map = new HashMap<>();
        map.put("result",num1*num2);
        return map;
    }
}
