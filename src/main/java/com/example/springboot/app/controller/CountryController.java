package com.example.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.app.exception.Mensaje;
import com.example.springboot.app.model.Country;
import com.example.springboot.app.service.CountryService;

@RestController
@RequestMapping("apiv1")
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/findcountry/{id}")
	public ResponseEntity<Country> findCountryById(@PathVariable long id){
		return ResponseEntity.ok().body(countryService.findCountryById(id));
	}
	
	@GetMapping("/findallcountry")
	public ResponseEntity<?> findAllCoutry() {
		List<Country> lista = countryService.findAllCountry();
		if(lista.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Sin paises en la base de datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(countryService.findAllCountry());
	}
	
	@DeleteMapping("/deletecountry/{id}")
	public HttpStatus deleteCountry(@PathVariable long id) {
		this.countryService.deleteCountry(id);
		return HttpStatus.OK;
	}
	
	@PutMapping("/updatecountry/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable long id, @RequestBody Country country){
		country.setId(id);
		return ResponseEntity.ok().body(this.countryService.updateCountry(country));
	}
}
