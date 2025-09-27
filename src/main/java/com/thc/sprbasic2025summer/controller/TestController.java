package com.thc.sprbasic2025summer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @ResponseBody
    @RequestMapping("/javareview")
    public Map<String, Object> javareview1() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("1", "111");
        map.put("2", "222");

        // 구구단
        for (int i = 1; i <= 9; i++) {
            System.out.println(i + "단");
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " * " + j + " = " + i*j);
            }
        }


        return map;
    }
}
