package de.byteinspace.mangaanime.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import de.byteinspace.mangaanime.entity.Serie;

@Repository
public interface SerieRepository extends PagingAndSortingRepository<Serie, Long>{
	
	public Serie findSerieByNameDeutsch(String name);
	public Serie findSerieById(Long id);

}
