package de.byteinspace.mangaanime.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Manga {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Serie serie;
	private int bandNummer;
	@ManyToOne
	private Autor autor;
	private int condition;
	@ManyToOne
	private Language language;
	private boolean hardCover; // True if Hard, False if Soft
	private int rating;
	@ManyToOne
	private Publisher publisher;
	private int ISBN;
	@OneToMany(mappedBy = "goodiesName")
	private List<Goodies> goodies;
	
	
	public Manga() {
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
	public int getBandNummer() {
		return bandNummer;
	}
	public void setBandNummer(int bandNummer) {
		this.bandNummer = bandNummer;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public boolean isHardCover() {
		return hardCover;
	}
	public void setHardCover(boolean hardCover) {
		this.hardCover = hardCover;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	
	
	
	
}
