package de.byteinspace.mangaanime.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import de.byteinspace.mangaanime.entity.Artbook;

@Repository
public interface ArtbookRepository extends PagingAndSortingRepository<Artbook, Long>{
	
	public Artbook findArtbookByArtbookTitle(String name);
	public Artbook findArtbookById(Long id);
	

}
