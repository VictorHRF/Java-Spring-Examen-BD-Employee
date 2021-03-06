package com.example.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.app.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

}
