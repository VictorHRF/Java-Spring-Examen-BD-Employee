package com.example.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.springboot.app.model.Airport;
import com.example.springboot.app.repository.AirportRepository;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

	@Autowired
	private AirportRepository airportRepository;
	
	@Override
	public Airport findAirportById(long airportId) {
		
		Optional<Airport> airportDb = this.airportRepository.findById(airportId);
		
		if(airportDb.isPresent()) {
			return airportDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + airportId); 
		}
	}
	
	@Override
	public List<Airport> findAllAirport() {
		// TODO Auto-generated method stub
		return this.airportRepository.findAll();
	}
	
	@Override
	public void deleteAirport(long airportId) {
		// TODO Auto-generated method stub
		Optional<Airport> airportDb = this.airportRepository.findById(airportId);
		
		if(airportDb.isPresent()) {
			this.airportRepository.delete(airportDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + airportId); 
		}
		
	}
	
	@Override
	public Airport updateAirport(Airport airport) {
		// TODO Auto-generated method stub
		Optional<Airport> response = this.airportRepository.findById(airport.getId());
		
		if(response.isPresent()) {
			Airport update = response.get();
			update.setName(airport.getName());
			airportRepository.save(update);
			return update;
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + airport.getId()); 
		}
	}
}
