package com.yp.springboot.server;

import com.yp.springboot.model.Person;

import java.util.List;


public interface PersonServiceInf {
    int addPerson(Person person);

    Person addAnimal(Person person);

    Person upAnimal(Person person);

    void deAnimal(Person person);

    List<Person> selectAnimal();

    Person selectAnimalbyid(int id);

}
