package de.byteinspace.mangaanime.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import de.byteinspace.mangaanime.entity.Autor;

@Repository
public interface AutorRepository extends PagingAndSortingRepository<Autor, Long> {
	
	public Autor findAutorByNachname(String name);
	public Autor findAutorById(Long id);

}
