package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Type;

@Repository
public interface TypeService extends JpaRepository<Type, Integer> {

}
