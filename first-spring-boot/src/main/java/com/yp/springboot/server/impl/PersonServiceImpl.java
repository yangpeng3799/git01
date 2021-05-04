package com.yp.springboot.server.impl;

import com.yp.springboot.jpa.StudentRepository;
import com.yp.springboot.mapper.PersonMapper;
import com.yp.springboot.model.Person;
import com.yp.springboot.server.PersonServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonServiceInf {

    @Autowired
    private PersonMapper PersonMapper;

    @Autowired
    private StudentRepository StudentRepository;

    @Override
    public int addPerson(Person person) {
        return PersonMapper.addPerson(person);
    }

    @Override
    public Person addAnimal(Person person) {
        return StudentRepository.save(person);
    }

    @Override
    public Person upAnimal(Person person) {
        return StudentRepository.save(person);
    }

    @Override
    public void deAnimal(Person person) {
        StudentRepository.delete(person);
    }

    @Override
    public List<Person> selectAnimal() {
        return StudentRepository.findAll();
    }

    @Override
    public Person selectAnimalbyid(int id) {
        Person one = StudentRepository.getOne(id);
        return one;
    }

}
