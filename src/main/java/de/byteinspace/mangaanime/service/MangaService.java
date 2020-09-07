package de.byteinspace.mangaanime.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import de.byteinspace.mangaanime.entity.Manga;
import de.byteinspace.mangaanime.repository.MangaRepository;

@Service
public class MangaService {

	private static Logger log = LoggerFactory.getLogger(SerieService.class);
	@Autowired FileService fileService;
	private final String FILE_SUB_PATH = "manga";
	@Autowired private MangaRepository mangaRepository;
	
	public Iterable<Manga> getAllMangas() {
		return mangaRepository.findAll();
	}
	
	public Manga getMangaByID(Long id) {
		return mangaRepository.findMangaById(id);
	}
	
	public void deleteMangaByID(Long id) {
		mangaRepository.deleteById(id);
	}
	
	public void saveManga(Manga manga) {
		log.info("Saving " + manga.toString());
		mangaRepository.save(manga);
	}

	public void updateManga(Manga manga) {
		log.info("Updating " + manga.toString());
		mangaRepository.save(manga);
	}

	public void processAddUpdate(Manga manga, final String action, final MultipartFile  uploadFile) {
		String fileName = fileService.uploadFile(uploadFile, FILE_SUB_PATH, manga.getFileName());
		if (fileName != "")
			manga.setFileName(fileName);
		
		if (action.equals("edit"))
			updateManga(manga);
		else
			saveManga(manga);
	}
}