package com.yp.springboot.jpa;

import com.yp.springboot.model.BuMen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuMenRepository extends JpaRepository<BuMen, Integer> {
}
