package de.byteinspace.mangaanime.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import de.byteinspace.mangaanime.entity.Language;

@Repository
public interface LanguageRepository extends PagingAndSortingRepository<Language, Long> {
	
	public Language findLanguageByLanguage(String name);
	public Language findLanguageById(Long id);


}
