package de.byteinspace.mangaanime.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import de.byteinspace.mangaanime.entity.Publisher;

@Repository
public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Long>{
	
	public Publisher findPublisherByName(String name);
	public Publisher findPublisherById(Long id);
	

}
