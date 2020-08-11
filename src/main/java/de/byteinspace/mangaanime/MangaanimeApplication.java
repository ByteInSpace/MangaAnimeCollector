package de.byteinspace.mangaanime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MangaanimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangaanimeApplication.class, args);
	}
	
	@Bean public StartupRunner scheduleRunner() {
		return new StartupRunner();
	}

}
