package com.example.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.springboot.app.model.Country;
import com.example.springboot.app.repository.CountryRepository;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public Country findCountryById(long countryId) {
		
		Optional<Country> countryDb = this.countryRepository.findById(countryId);
		
		if(countryDb.isPresent()) {
			return countryDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + countryId); 
		}
	}
	
	@Override
	public List<Country> findAllCountry() {
		// TODO Auto-generated method stub
		return this.countryRepository.findAll();
	}
	
	@Override
	public void deleteCountry(long countryId) {
		// TODO Auto-generated method stub	
		Optional<Country> countryDb = this.countryRepository.findById(countryId);
		
		if(countryDb.isPresent()) {
			this.countryRepository.delete(countryDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + countryId); 
		}
	}
	
	@Override
	public Country updateCountry(Country country) {
		// TODO Auto-generated method stub
		
		Optional<Country> response = this.countryRepository.findById(country.getId());
		
		if(response.isPresent()) {
			Country update = response.get();
			update.setCode(country.getCode());
			update.setName(country.getName());
			countryRepository.save(update);
			return update;
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + country.getId()); 
		}
	}

}
