package de.byteinspace.mangaanime.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	 @Value("${app.upload.dir}")
	 public String uploadDir;
	 
	private final int THUMB_WIDTH = 200;
	private final int IMAGE_WIDTH = 600;
	
	
	private static Logger log = LoggerFactory.getLogger(FileService.class);
	
	
	public String uploadFile(MultipartFile uploadFile, String uploadSubpathPart, String fileName)  {
		
		
		String uploadPath = uploadDir + "/" + uploadSubpathPart + "/";
		String uploadPathThumb = uploadPath + "/thumb/";
		
		if (uploadFile.isEmpty()) {
			log.warn("Upload file provided is empty");
			return "";
		}
		
		
		if (fileName == null || fileName.length() == 0)
		{
			fileName = uploadSubpathPart + "_" + System.currentTimeMillis() + ".png";
		}
		
		String fileNameWithPath = uploadPath + fileName;
		
		try {
            Path path = Paths.get(fileNameWithPath);
            
            Files.copy(uploadFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            BufferedImage origPicture = ImageIO.read(new File(fileNameWithPath));
			BufferedImage scaledPicture = getResizedImage(origPicture, IMAGE_WIDTH);
			File thumFile = new File(fileNameWithPath);
			ImageIO.write(scaledPicture, "png", thumFile);
			
        } catch ( Exception e) {
            e.printStackTrace();
            return "";
        }
		
		String uploadPathThumbFile = uploadPathThumb + fileName;
		try {
			BufferedImage origPicture = ImageIO.read(new File(fileNameWithPath));
			BufferedImage thumbPicture = getResizedImage(origPicture, THUMB_WIDTH);
			File thumFile = new File(uploadPathThumbFile);
			ImageIO.write(thumbPicture, "png", thumFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return fileName;
	}
	
	BufferedImage getResizedImage(BufferedImage originalImage, int targetWidth) throws Exception {
	    return Scalr.resize(originalImage, targetWidth);
	}
	
	
	public String getOriginalFileName(MultipartFile file) {
		if (file.isEmpty()) {
			return "";
		}
		
		return StringUtils.cleanPath(file.getOriginalFilename());
	}
}
