package com.yp.springboot.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @Value("${A}")
    private String A;
    @Value("${B}")
    private String B;
    @Value("${C}")
    private int C;
    @Value("${D}")
    private String d;

    @Override
    @RequestMapping("toString")
    public String toString() {
        return "Test{" +
                "A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C=" + C +
                ", d='" + d + '\'' +
                '}';
    }
}
