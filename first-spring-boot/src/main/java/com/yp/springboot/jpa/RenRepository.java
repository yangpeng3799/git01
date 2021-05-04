package com.yp.springboot.jpa;

import com.yp.springboot.model.Ren;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RenRepository extends JpaRepository<Ren, Integer> {
}
