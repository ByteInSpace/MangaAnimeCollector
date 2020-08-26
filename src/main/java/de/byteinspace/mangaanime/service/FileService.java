package de.byteinspace.mangaanime.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileService {

	private final String UPLOAD_DIR 		= "./resources/static/images/collectionimages";
	private final String UPLOAD_DIR_THUMB 	= "./resources/static/images/thumb";
	
	private static Logger log = LoggerFactory.getLogger(FileService.class);
	
	
	public boolean uploadFile(MultipartFile uploadFile)  {
		
		if (uploadFile.isEmpty()) {
			log.warn("Upload file provided is empty");
			return false;
		}
		
		String fileName = getOriginalFileName(uploadFile);
		
		try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(uploadFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.warn(e.getStackTrace().toString());
            return false;
        }
		
		return true;
	}
	
	
	public String getOriginalFileName(MultipartFile file) {
		if (file.isEmpty()) {
			return "";
		}
		
		return StringUtils.cleanPath(file.getOriginalFilename());
	}
}
