package de.byteinspace.mangaanime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.byteinspace.mangaanime.entity.Autor;
import de.byteinspace.mangaanime.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired AutorRepository autorRepository;
	
	public Iterable<Autor> getAllAutors() {
		return autorRepository.findAll();
	}

	public Autor getAutorByID(Long id) {
		return autorRepository.findAutorById(id);
	}
}
