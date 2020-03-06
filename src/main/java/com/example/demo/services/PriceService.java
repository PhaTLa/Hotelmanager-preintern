package com.example.demo.services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Price;
@Repository
public interface PriceService extends JpaRepository<Price, Integer> {

}
