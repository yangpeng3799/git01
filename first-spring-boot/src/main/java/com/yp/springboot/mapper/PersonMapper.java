package com.yp.springboot.mapper;

import com.yp.springboot.model.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {
    public int addPerson(Person person);
}
