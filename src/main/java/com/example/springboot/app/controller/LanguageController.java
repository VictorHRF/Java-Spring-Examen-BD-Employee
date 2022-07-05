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
import com.example.springboot.app.model.Language;
import com.example.springboot.app.service.LanguageService;

@RestController
@RequestMapping("apiv1")
public class LanguageController {
	
	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/findlanguage/{id}")
	public ResponseEntity<Language> findLanguageById(@PathVariable long id){
		return ResponseEntity.ok().body(languageService.findLanguageById(id));
	}
	
	@GetMapping("/findalllanguage")
	public ResponseEntity<?> findAllLanguage() {
		List<Language> lista = languageService.findAllLanguage();
		if(lista.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Sin lenguages en la base de datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(languageService.findAllLanguage());
	}
	
	@DeleteMapping("/deletelanguages/{id}")
	public HttpStatus deleteLanguage(@PathVariable long id) {
		this.languageService.deleteLanguage(id);
		return HttpStatus.OK;
	}
	
	@PutMapping("/updatelanguage/{id}")
	public ResponseEntity<Language> updateLanguage(@PathVariable long id, @RequestBody Language language){
		language.setId(id);
		return ResponseEntity.ok().body(this.languageService.updateLanguage(language));
	}

}
