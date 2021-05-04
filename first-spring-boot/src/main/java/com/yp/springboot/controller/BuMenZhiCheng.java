package com.yp.springboot.controller;

import com.yp.springboot.jpa.BuMenRepository;
import com.yp.springboot.jpa.RenRepository;
import com.yp.springboot.jpa.ZhiChengRepository;
import com.yp.springboot.model.BuMen;
import com.yp.springboot.model.ZhiCheng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class BuMenZhiCheng {

    @Autowired
    BuMenRepository buMenRepository;

    @Autowired
    ZhiChengRepository zhiChengRepository;
    @Autowired
    RenRepository renRepository;

    @RequestMapping("bumenzhineng")
    public String renbumen() {
        //  int i=10/0;

        String a;

        BuMen b = new BuMen();
        b.setBuame("R部门");
        BuMen b2 = new BuMen();
        b2.setBuame("R部门");

        ZhiCheng zc = new ZhiCheng();
        zc.setZgname("R职称");

        b.getZc().add(zc);
        b2.getZc().add(zc);

        zc.getBumen().add(b);
        zc.getBumen().add(b2);

        try {
            zhiChengRepository.save(zc);
            a = "成功";
        } catch (Exception e) {
            a = e.getMessage();
        }
        return "成功";
    }

    @RequestMapping("selectbuzhicheng")
    public String selectbuzhicheng(Integer zgid) {
        ZhiCheng one = zhiChengRepository.getOne(zgid);
        System.out.println(one.getZgid() + " " + one.getZgname());
        Set<BuMen> bumen = one.getBumen();
        for (BuMen b : bumen) {
            System.out.println(b.getBuid() + " " + b.getBuame());
        }
        return "";
    }


}
