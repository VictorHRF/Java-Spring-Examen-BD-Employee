package com.example.springboot.app.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Country")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JsonBackReference
	private Employee ownerCountry;
	
	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private java.util.List<Airport> airports = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Employee getOwnerCountry() {
		return ownerCountry;
	}

	public void setOwnerCountry(Employee ownerCountry) {
		this.ownerCountry = ownerCountry;
	}

	public java.util.List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(java.util.List<Airport> airports) {
		this.airports = airports;
	}

}
