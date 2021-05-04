package com.yp.springboot.controller;

import com.yp.springboot.jpa.StudentRepository;
import com.yp.springboot.model.Person;
import com.yp.springboot.server.PersonServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonServiceInf PersonServiceInf;

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("Person")
    public String test(Person person) {
        System.out.println(person.getId());
        System.out.println(person.getName());
        String a;
        try {
            int i = PersonServiceInf.addPerson(person);
            a = "添加成功";
        } catch (Exception e) {
            a = "添加失败";
            a += e.getMessage();
        }
        return a;
    }

    @RequestMapping("jpasav")
    public String sav(Person person) {
        System.out.println(person.getId());
        System.out.println(person.getName());
        String a;
        try {
            Person i = PersonServiceInf.addAnimal(person);
            a = "添加成功";
        } catch (Exception e) {
            a = "添加失败";
            a += e.getMessage();
        }
        return a;
    }

    @RequestMapping("jpaup")
    public String up(Person person) {
        person.setId(1);
        System.out.println(person.getId());
        System.out.println(person.getName());
        String a;
        try {
            Person i = PersonServiceInf.upAnimal(person);
            a = "更改成功";
        } catch (Exception e) {
            a = "更改失败";
            a += e.getMessage();
        }
        return a;
    }

    @RequestMapping("jpade")
    public String de(Person person) {
        String a;
        try {
            PersonServiceInf.deAnimal(person);
            a = "删除成功";
        } catch (Exception e) {
            a = "删除失败";
            a += e.getMessage();
        }
        return a;
    }

    @RequestMapping("jpaselect")
    public void select() {
        String a;
        List<Person> list = PersonServiceInf.selectAnimal();
        for (Person p : list) {
            System.out.println(p.toString());
        }
    }

    //selectbyid/1
    @GetMapping(value = "selectbyid/{id}")
    public String selectbyid(@PathVariable("id") int id) {
        Person person = PersonServiceInf.selectAnimalbyid(id);
        System.out.println(person.toString());
        return "";
    }

//    @RequestMapping("findBystudentFenye")
//    public String findBystudentFenye(){
//        Sort.Order order=new Sort.Order(Sort.Direction.DESC,"id");
//        Sort sort=new Sort(order);
//        int dq=0;
//        int pg=2;
//        Pageable pageable=new PageRequest(0,2,sort);
//        Page<Person> page = studentRepository.findAll(pageable);
//        List<Person> content = page.getContent();
//        System.out.println("总条数"+page.getTotalElements());
//        System.out.println("总页数"+page.getTotalPages());
//        for (Person pe:content) {
//            System.out.println(pe.toString());
//        }
//        return "";
//    }

    @RequestMapping("findBystudentFenye")
    public void findBystudentFenye() {
        Pageable pageable = PageRequest.of(0, 2);//页数索引从0开始
        Page<Person> page = studentRepository.findAll(pageable);
        System.out.println("共多少条：" + page.getTotalElements());
        System.out.println("共多少页：" + page.getTotalPages());
        System.out.println("当前页码：" + (page.getNumber() + 1));
        //得到指定页码下的要展现的列表数据
        List<Person> list = page.getContent();
        for (Person sysuser : list) {
            System.out.println(sysuser.toString());
        }
    }

    @RequestMapping("orderby")
    void testSortNoParameterAndPage() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Person> list = studentRepository.findAll(sort);
        for (Person sysuser : list) {
            System.out.println(sysuser);
        }
    }

    @RequestMapping("select")
    public void seleclikebyname(String name) {
        List<Person> by = studentRepository.findByName(name);
        for (Person sysuser : by) {
            System.out.println(sysuser);
        }
    }

    @RequestMapping("like")
    public void findByNameContainingAndAgeDesc(String name, String age) {
        System.out.println(name);
        System.out.println(age);
        List<Person> by = studentRepository.findByNameContainingAndAgeOrderByIdDesc(name, age);
        for (Person sysuser : by) {
            System.out.println(sysuser);
        }
    }

    @RequestMapping("queryjap")
    public void queryjap(String name) {
        Person person = studentRepository.findbyName(name);
        System.out.println(person.toString());
    }


    @RequestMapping("updatejap")
    public String updatejap(String name, int id) {
        int i = studentRepository.updatejap(name, id);
        return " " + i + " ";
    }

}
