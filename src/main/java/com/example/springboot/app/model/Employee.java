package com.example.springboot.app.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "fistname")
	private String fistname;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference
	private java.util.List<Language> laguages = new ArrayList<>();
	
	@OneToMany(mappedBy = "employeeCountry", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private java.util.List<Country> countries = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFistname() {
		return fistname;
	}

	public void setFistname(String fistname) {
		this.fistname = fistname;
	}
	
}
