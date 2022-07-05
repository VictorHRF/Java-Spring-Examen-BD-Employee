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
import com.example.springboot.app.model.Airport;
import com.example.springboot.app.service.AirportService;

@RestController
@RequestMapping("apiv1")
public class AirportController {

	@Autowired
	private AirportService airportService;
	
	@GetMapping("/findairport/{id}")
	public ResponseEntity<Airport> findAirportById(@PathVariable long id){
		return ResponseEntity.ok().body(airportService.findAirportById(id));
	}
	
	@GetMapping("/findallairport")
	public ResponseEntity<?> findAllAirport() {
		List<Airport> lista = airportService.findAllAirport();
		if(lista.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Sin aeropuertos en la base de datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(airportService.findAllAirport());
	}
	
	@DeleteMapping("/deleteairport/{id}")
	public HttpStatus deleteAirport(@PathVariable long id) {
		this.airportService.deleteAirport(id);
		return HttpStatus.OK;
	}
	
	@PutMapping("/updateairport/{id}")
	public ResponseEntity<Airport> updateAirport(@PathVariable long id, @RequestBody Airport airport){
		airport.setId(id);
		return ResponseEntity.ok().body(this.airportService.updateAirport(airport));
	}
}
