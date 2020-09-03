package de.byteinspace.mangaanime.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import de.byteinspace.mangaanime.entity.Anime;
import de.byteinspace.mangaanime.repository.AnimeRepository;

@Service
public class AnimeService {

	private static Logger log = LoggerFactory.getLogger(SerieService.class);
	@Autowired FileService fileService;
	private final String FILE_SUB_PATH = "anime";
	@Autowired private AnimeRepository animeRepository;
	
	public Iterable<Anime> getAllAnimes() {
		return animeRepository.findAll();
	}
	
	public Anime getAnimeByID(Long id) {
		return animeRepository.findAnimeById(id);
	}
	
	public void deleteAnimeByID(Long id) {
		animeRepository.deleteById(id);
	}
	
	public void saveAnime(Anime anime) {
		log.info("Saving " + anime.toString());
		animeRepository.save(anime);
	}

	public void updateAnime(Anime anime) {
		log.info("Updating " + anime.toString());
		animeRepository.save(anime);
	}

	public void processAddUpdate(Anime anime, final String action, final MultipartFile  uploadFile) {
		String fileName = fileService.uploadFile(uploadFile, FILE_SUB_PATH, anime.getFileName());
		if (fileName != "")
			anime.setFileName(fileName);
		
		if (action.equals("edit"))
			updateAnime(anime);
		else
			saveAnime(anime);
	}
}