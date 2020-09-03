package de.byteinspace.mangaanime.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Anime {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne 
	private Serie serie;
	
	@ManyToOne
	private Autor autor;
	
	
	private String animeTitle;
	private String animeVolume;
	
	private boolean bluRay;
	private String fileName;
	private int animeCondition;
	
	
	
	

	public int getAnimeCondition() {
		return animeCondition;
	}

	public void setAnimeCondition(int animeCondition) {
		this.animeCondition = animeCondition;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnimeTitle() {
		return animeTitle;
	}

	public void setAnimeTitle(String animeTitle) {
		this.animeTitle = animeTitle;
	}

	public String getAnimeVolume() {
		return animeVolume;
	}

	public void setAnimeVolume(String animeVolume) {
		this.animeVolume = animeVolume;
	}

	public boolean isBluRay() {
		return bluRay;
	}

	public void setBluRay(boolean bluRay) {
		this.bluRay = bluRay;
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
	
	
	
}
