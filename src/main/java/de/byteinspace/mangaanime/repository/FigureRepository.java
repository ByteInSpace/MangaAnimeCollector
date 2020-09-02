package de.byteinspace.mangaanime.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.byteinspace.mangaanime.entity.Figure;

public interface FigureRepository extends PagingAndSortingRepository<Figure, Long>{
	
	public Figure findFigureByFigureName(String name);
	public Figure findFigureById(Long id);
	

}
