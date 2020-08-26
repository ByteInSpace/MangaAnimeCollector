package de.byteinspace.mangaanime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.byteinspace.mangaanime.entity.Language;
import de.byteinspace.mangaanime.repository.LanguageRepository;

@Service
public class LanguageService {

	@Autowired LanguageRepository languageRepository;
	
	
	public Iterable<Language> getAllLanguages() {
		return languageRepository.findAll();
	}
}
