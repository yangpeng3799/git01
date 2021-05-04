package com.yp.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity//这个类是数据库中的表
public class Person {

    @Id
    @GeneratedValue//代表自增
            int id;
    @Column(name = "age")
    String age;

    @Column(name = "name")
    String name;

    @Column(name = "birthday")
    Date birthday;
    String cid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", cid='" + cid + '\'' +
                '}';
    }
}
