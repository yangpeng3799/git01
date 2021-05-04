package com.yp.springboot.jpa;

import com.yp.springboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Person, Integer> {
    public List<Person> findByName(String name);

    public List<Person> findByNameLike(String name);

    public List<Person> findByNameContainingAndAgeOrderByIdDesc(String name, String age);

    @Query("select p from Person p where p.name= ?1")
    Person findbyName(String name);

    @Modifying
    @Query("update Person a set a.name=?1 where a.id=?2")
    int updatejap(String name, int id);

}
