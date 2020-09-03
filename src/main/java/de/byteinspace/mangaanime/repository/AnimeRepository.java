package de.byteinspace.mangaanime.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.byteinspace.mangaanime.entity.Anime;

public interface AnimeRepository extends PagingAndSortingRepository<Anime, Long>{

	public Anime findAnimeByAnimeTitle(String name);
	public Anime findAnimeById(Long id);
}
