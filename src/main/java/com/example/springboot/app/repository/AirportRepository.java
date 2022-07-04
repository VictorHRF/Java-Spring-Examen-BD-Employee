package com.example.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.app.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

}
