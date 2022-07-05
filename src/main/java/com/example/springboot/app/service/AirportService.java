package com.example.springboot.app.service;

import java.util.List;

import com.example.springboot.app.model.Airport;

public interface AirportService {
	
	Airport addAirport(Airport airport);

	Airport findAirportById(long airportId);
	
	List<Airport> findAllAirport();
	
	void deleteAirport(long airportId);
	
	Airport updateAirport(Airport airport);
}
