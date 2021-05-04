package com.yp.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Skip {
    @RequestMapping("index")
    public String index() {
        System.out.println("11313123123");
        return "index";
    }
}
