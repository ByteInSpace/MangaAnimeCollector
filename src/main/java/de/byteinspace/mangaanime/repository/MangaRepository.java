package de.byteinspace.mangaanime.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import de.byteinspace.mangaanime.entity.Manga;

@Repository
public interface MangaRepository extends PagingAndSortingRepository<Manga, Long>{
	
	public Manga findMangaById(Long id);
	

}
