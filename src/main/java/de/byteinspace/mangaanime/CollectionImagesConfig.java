package de.byteinspace.mangaanime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CollectionImagesConfig implements WebMvcConfigurer{
	
	@Value("${app.upload.dir}")
	public String uploadDir;
	
	@Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		String collection = "file:" + uploadDir + "/";
        registry.addResourceHandler("/collection/**").addResourceLocations(collection);
        System.out.println("Registry" + collection);
    }

}
