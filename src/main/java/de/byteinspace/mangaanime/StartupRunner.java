package de.byteinspace.mangaanime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import de.byteinspace.mangaanime.entity.Artbook;
import de.byteinspace.mangaanime.entity.Autor;
import de.byteinspace.mangaanime.entity.Language;
import de.byteinspace.mangaanime.entity.Serie;
import de.byteinspace.mangaanime.repository.ArtbookRepository;
import de.byteinspace.mangaanime.repository.AutorRepository;
import de.byteinspace.mangaanime.repository.LanguageRepository;
import de.byteinspace.mangaanime.repository.SerieRepository;

public class StartupRunner implements CommandLineRunner {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired ArtbookRepository artbookRepository;
	@Autowired AutorRepository autorRepository;
	@Autowired LanguageRepository languageRepository;
	@Autowired SerieRepository serieRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		logger.info("Storing some example data");
		
		Serie serie1 = new Serie();
		serie1.setNameDeutsch("Ranma 1/2 DEU");
		serie1.setNameOrginal("Ranma 1/2 JP");
		serieRepository.save(serie1);
		
		Serie serie2 = new Serie();
		serie2.setNameDeutsch("Rorouni Kenshin DEU");
		serie2.setNameOrginal("Rorouni Kenshin JAP");
		serieRepository.save(serie2);
		
		Serie serie3 = new Serie();
		serie3.setNameDeutsch("Shao die Mondfee");
		serie3.setNameOrginal("Mamotte Shugogetten");
		serieRepository.save(serie3);
		
		Language lang1 = new Language();
		lang1.setLanguage("DEUTSCH");
		languageRepository.save(lang1);
		
		Language lang2 = new Language();
		lang2.setLanguage("JAPANISCH");
		languageRepository.save(lang2);
		
		Autor autor1 = new Autor("Rumiko", "Takahashi");
		autorRepository.save(autor1);
		
		Autor autor2 = new Autor("Nobuhiro", "Watsuki");
		autorRepository.save(autor2);
		
		Autor autor3 = new Autor("Minene", "Sakurano");
		autorRepository.save(autor3);
		
		Artbook artbook1 = new Artbook();
		artbook1.setSerie(serie1);
		artbook1.setAutor(autor1);
		artbook1.setArtbookTitle("Ranma Artbook");
		artbook1.setLanguage(lang1);
		artbook1.setArtbookCondition(5);
		artbookRepository.save(artbook1);
		
		
		Artbook artbook2 = new Artbook();
		artbook2.setSerie(serie2);
		artbook2.setAutor(autor2);
		artbook2.setArtbookTitle("Kenshin Artbook");
		artbook2.setLanguage(lang2);
		artbook2.setArtbookCondition(4);
		artbookRepository.save(artbook2);
		
		Artbook artbook3 = new Artbook();
		artbook3.setSerie(serie3);
		artbook3.setAutor(autor3);
		artbook3.setArtbookTitle("Shao Artbook");
		artbook3.setLanguage(lang2);
		artbook3.setArtbookCondition(3);
		artbookRepository.save(artbook3);
		
		logger.info("Example data stored");
	}

}
