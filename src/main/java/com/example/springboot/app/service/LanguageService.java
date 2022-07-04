package com.example.springboot.app.service;

import java.util.List;

import com.example.springboot.app.model.Language;

public interface LanguageService {

	Language findLanguageById(long languageId);
	
	List<Language> findAllLanguage();
	
	void deleteLanguage(long languageId);
	
	Language updateLanguage(Language language);
}
