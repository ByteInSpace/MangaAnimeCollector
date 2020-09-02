package de.byteinspace.mangaanime.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import de.byteinspace.mangaanime.entity.Publisher;
import de.byteinspace.mangaanime.repository.PublisherRepository;

@Service
public class PublisherService {

	private static Logger log = LoggerFactory.getLogger(SerieService.class);
	@Autowired FileService fileService;
	private final String FILE_SUB_PATH = "publisher";
	@Autowired private PublisherRepository publisherRepository;
	
	public Iterable<Publisher> getAllPublishers() {
		return publisherRepository.findAll();
	}
	
	public Publisher getPublisherByID(Long id) {
		return publisherRepository.findPublisherById(id);
	}
	
	public void deletePublisherByID(Long id) {
		publisherRepository.deleteById(id);
	}
	
	public void savePublisher(Publisher publisher) {
		log.info("Saving " + publisher.toString());
		publisherRepository.save(publisher);
	}

	public void updatePublisher(Publisher publisher) {
		log.info("Updating " + publisher.toString());
		publisherRepository.save(publisher);
	}

	public void processAddUpdate(Publisher publisher, final String action, final MultipartFile  uploadFile) {
		String fileName = fileService.uploadFile(uploadFile, FILE_SUB_PATH, publisher.getFileName());
		if (fileName != "")
			publisher.setFileName(fileName);
		
		if (action.equals("edit"))
			updatePublisher(publisher);
		else
			savePublisher(publisher);
	}
}
