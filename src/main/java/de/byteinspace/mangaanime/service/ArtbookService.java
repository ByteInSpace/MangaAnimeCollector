package de.byteinspace.mangaanime.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import de.byteinspace.mangaanime.entity.Artbook;
import de.byteinspace.mangaanime.repository.ArtbookRepository;

@Service
public class ArtbookService {

	private static Logger log = LoggerFactory.getLogger(SerieService.class);
	@Autowired FileService fileService;
	private final String FILE_SUB_PATH = "artbook";
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
	
	public void saveSerie(Artbook artbook) {
		log.info("Saving " + artbook.toString());
		artbookRepository.save(artbook);
	}

	public void updateSerie(Artbook artbook) {
		log.info("Updating " + artbook.toString());
		artbookRepository.save(artbook);
	}

	public void processAddUpdate(Artbook artbook, final String action, final MultipartFile  uploadFile) {
		String fileName = fileService.uploadFile(uploadFile, FILE_SUB_PATH, artbook.getFileName());
		if (fileName != "")
			artbook.setFileName(fileName);
		
		if (action.equals("edit"))
			updateSerie(artbook);
		else
			saveSerie(artbook);
	}
}
