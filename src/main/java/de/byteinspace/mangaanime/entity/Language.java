package de.byteinspace.mangaanime.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Language {

	@Id
	@GeneratedValue
	private Long id;
	private String language;
	@OneToMany(mappedBy = "language")
	private List<Manga> mangas;
	
	@OneToMany(mappedBy = "language")
	private List<Manga> artbooks;
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	
	
}
