package de.byteinspace.mangaanime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.byteinspace.mangaanime.entity.Artbook;
import de.byteinspace.mangaanime.repository.ArtbookRepository;

@Service
public class ArtbookService {

	@Autowired private ArtbookRepository artbookRepository;
	
	public Iterable<Artbook> getAllArtbooks() {
		return artbookRepository.findAll();
	}
	
	public Artbook getArtbookByID(Long id) {
		return artbookRepository.findArtbookById(id);
	}
	
	public void deleteArtbookByID(Long id) {
		artbookRepository.deleteById(id);
	}
	
	public void saveArtbook(Artbook artbook) {
		artbookRepository.save(artbook);
	}
}
