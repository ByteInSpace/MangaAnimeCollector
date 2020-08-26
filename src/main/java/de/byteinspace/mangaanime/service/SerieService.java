package de.byteinspace.mangaanime.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.byteinspace.mangaanime.entity.Serie;
import de.byteinspace.mangaanime.repository.SerieRepository;

@Service
public class SerieService {

	@Autowired SerieRepository serieRepository;
	private static Logger log = LoggerFactory.getLogger(SerieService.class);
	
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

	public Object findSerieByID(Long id) {
		return serieRepository.findById(id);
	}

	public void updateSerie(Serie serie) {
		log.info("Updating " + serie.toString());
		serieRepository.save(serie);
	}
}
