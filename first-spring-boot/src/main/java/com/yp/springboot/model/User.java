package com.yp.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
@ConfigurationProperties("boy")
public class User {
    private String A;
    private String B;
    private int C;
    private String d;

    @JsonIgnore//隐藏
    private String name;

    private String passowld;
    private Integer age;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT+8")
    //时间地区格式
    private Date stattime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    //不许为null
    private String desc;


    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassowld() {
        return passowld;
    }

    public void setPassowld(String passowld) {
        this.passowld = passowld;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getStattime() {
        return stattime;
    }

    public void setStattime(Date stattime) {
        this.stattime = stattime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passowld='" + passowld + '\'' +
                ", age=" + age +
                ", stattime=" + stattime +
                ", desc='" + desc + '\'' +
                '}';
    }
}
