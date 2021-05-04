package com.yp.springboot.controller;

import com.yp.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TextController {

    @Autowired
    User user;

    @RequestMapping("say")
    public String say() {
        return "test";
    }

    @RequestMapping("user")
    public String User() {
        return user.getA() + user.getB() + user.getC() + user.getD() + user.getClass();
    }

    @RequestMapping("getUser")
    public User getUser() {
        user.setName("text");
        user.setPassowld("test");
        user.setAge(12);
        user.setStattime(new Date());
        user.setDesc("hellow imocc~");
        return user;
    }


}
