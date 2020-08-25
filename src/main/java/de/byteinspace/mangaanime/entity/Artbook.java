package de.byteinspace.mangaanime.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Artbook {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne 
	private Serie serie;
	
	@ManyToOne
	private Autor autor;
	
	@ManyToOne
	private Language language;
	
	private String artbookTitle;
	private int ISBN;
	private int artbookCondition;
	private String image;
	
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public String getArtbookTitle() {
		return artbookTitle;
	}
	public void setArtbookTitle(String artbookTitle) {
		this.artbookTitle = artbookTitle;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public int getArtbookCondition() {
		return artbookCondition;
	}
	public void setArtbookCondition(int artbookCondition) {
		this.artbookCondition = artbookCondition;
	}
	
	
}
