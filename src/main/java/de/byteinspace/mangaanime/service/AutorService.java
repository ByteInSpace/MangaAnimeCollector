package de.byteinspace.mangaanime.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import de.byteinspace.mangaanime.entity.Autor;
import de.byteinspace.mangaanime.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired AutorRepository autorRepository;
	private static Logger log = LoggerFactory.getLogger(SerieService.class);
	@Autowired FileService fileService;
	private final String FILE_SUB_PATH = "autor";
	
	
	public Iterable<Autor> getAllAutors() {
		return autorRepository.findAll();
	}

	public Autor getAutorByID(Long id) {
		return autorRepository.findAutorById(id);
	}
	
	public void deleteAutorByID(Long id) {
		autorRepository.deleteById(id);
	}
	
	public void saveAutor(Autor autor) {
		log.info("Saving " + autor.toString());
		autorRepository.save(autor);
	}

	public void updateAutor(Autor autor) {
		log.info("Updating " + autor.toString());
		autorRepository.save(autor);
	}
	
	public void processAddUpdate(Autor autor, final String action, final MultipartFile  uploadFile) {
		String fileName = fileService.uploadFile(uploadFile, FILE_SUB_PATH, autor.getFileName());
		if (fileName != "")
			autor.setFileName(fileName);
		
		if (action.equals("edit"))
			updateAutor(autor);
		else
			saveAutor(autor);
	}
}
