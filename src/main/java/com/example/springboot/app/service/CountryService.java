package com.example.springboot.app.service;

import java.util.List;

import com.example.springboot.app.model.Country;

public interface CountryService {
	
	Country addCountry(Country country);

	Country findCountryById(long countryId);
	
	List<Country> findAllCountry();
	
	void deleteCountry(long countryId);
	
	Country updateCountry(Country country);
}
