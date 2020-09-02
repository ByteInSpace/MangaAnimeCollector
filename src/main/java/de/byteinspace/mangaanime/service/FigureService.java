package de.byteinspace.mangaanime.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import de.byteinspace.mangaanime.entity.Artbook;
import de.byteinspace.mangaanime.entity.Figure;
import de.byteinspace.mangaanime.repository.FigureRepository;

@Service
public class FigureService {

	private static Logger log = LoggerFactory.getLogger(SerieService.class);
	@Autowired FileService fileService;
	private final String FILE_SUB_PATH = "figure";
	@Autowired private FigureRepository figureRepository;
	
	public Iterable<Figure> getAllFigures() {
		return figureRepository.findAll();
	}
	
	public Figure getFigureByID(Long id) {
		return figureRepository.findFigureById(id);
	}
	
	public void deleteFigureByID(Long id) {
		figureRepository.deleteById(id);
	}
	
	public void saveFigure(Figure figure) {
		log.info("Saving " + figure.toString());
		figureRepository.save(figure);
	}

	public void updateFigure(Figure figure) {
		log.info("Updating " + figure.toString());
		figureRepository.save(figure);
	}

	public void processAddUpdate(Figure figure, final String action, final MultipartFile  uploadFile) {
		String fileName = fileService.uploadFile(uploadFile, FILE_SUB_PATH, figure.getFileName());
		if (fileName != "")
			figure.setFileName(fileName);
		
		if (action.equals("edit"))
			updateFigure(figure);
		else
			saveFigure(figure);
	}
}
