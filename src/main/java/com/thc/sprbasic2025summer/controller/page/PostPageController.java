package com.thc.sprbasic2025summer.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostPageController {

    @GetMapping("/{page}")
    public String create(@PathVariable String page) {
        return "post/" + page;
    }

    @GetMapping("/{page}/{id}")
    public String create(@PathVariable String page, @PathVariable String id) {
        return "post/" + page;
    }
}
