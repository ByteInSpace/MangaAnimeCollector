package de.byteinspace.mangaanime.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import de.byteinspace.mangaanime.entity.Serie;
import de.byteinspace.mangaanime.repository.SerieRepository;

@Service
public class SerieService {

	@Autowired SerieRepository serieRepository;
	private static Logger log = LoggerFactory.getLogger(SerieService.class);
	@Autowired FileService fileService;
	private final String FILE_SUB_PATH = "serie";
	
	
	public Iterable<Serie> getAllSeries() {
		return serieRepository.findAll();
	}
	
	public Serie getSerieByID(Long id) {
		return serieRepository.findSerieById(id);
	}
	
	public void deleteSerieByID(Long id) {
		serieRepository.deleteById(id);
	}
	
	public void saveSerie(Serie serie) {
		if (serie.getNameDeutsch() == null)
			serie.setNameDeutsch(serie.getNameOrginal());
		log.info("Saving " + serie.toString());
		serieRepository.save(serie);
	}

	public void updateSerie(Serie serie) {
		log.info("Updating " + serie.toString());
		serieRepository.save(serie);
	}
	
	public void processAddUpdate(Serie serie, final String action, final MultipartFile  uploadFile) {
		String fileName = fileService.uploadFile(uploadFile, FILE_SUB_PATH, serie.getFileName());
		if (fileName != "")
			serie.setFileName(fileName);
		
		if (action.equals("edit"))
			updateSerie(serie);
		else
			saveSerie(serie);
	}
}
