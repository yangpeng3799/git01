package com.yp.springboot.controller;

import com.yp.springboot.jpa.BuMenRepository;
import com.yp.springboot.jpa.RenRepository;
import com.yp.springboot.model.BuMen;
import com.yp.springboot.model.Ren;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RenBuMenController {

    @Autowired
    RenRepository renBuMenRepository;

    @Autowired
    BuMenRepository buMenRepository;

    @RequestMapping("ren")
    public String renbumen() {
        String a;
        Ren r = new Ren();
        r.setRname("大W");

        BuMen b = new BuMen();
        b.setBuame("S部门");

        r.setBumen(b);
        b.getSet().add(r);
        try {
            renBuMenRepository.save(r);
            a = "成功";
        } catch (Exception e) {
            a = e.getMessage();
        }
        return "成功";
    }

    //查询一对多
    @RequestMapping("selectstudentRole")
    public String selectstudentRole(int id) {
        Ren one = renBuMenRepository.getOne(id);
        System.out.println(one.getRname() + "" + one.getRid());
        System.out.println(one.getBumen().getBuid());
        System.out.println(one.getBumen().getBuame());
        return "";
    }

}
