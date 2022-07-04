package com.example.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.springboot.app.model.Language;
import com.example.springboot.app.repository.LanguageRepository;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepository;
	
	@Override
	public Language findLanguageById(long languageId) {
		
		Optional<Language> languageDb = this.languageRepository.findById(languageId);
		
		if(languageDb.isPresent()) {
			return languageDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + languageId); 
		}
	}
	
	@Override
	public List<Language> findAllLanguage() {
	
		return this.languageRepository.findAll();
	}
	
	@Override
	public void deleteLanguage(long languageId) {
	
		Optional<Language> languageDb = this.languageRepository.findById(languageId);
		
		if(languageDb.isPresent()) {
			this.languageRepository.delete(languageDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + languageId); 
		}
		
	}
	
	@Override
	public Language updateLanguage(Language language) {
		// TODO Auto-generated method stub
		
		Optional<Language> response = this.languageRepository.findById(language.getId());
		
		if(response.isPresent()) {
			Language update = response.get();
			update.setCode(language.getCode());
			update.setName(language.getName());
			languageRepository.save(update);
			return update;
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + language.getId()); 
		}
	}
}
