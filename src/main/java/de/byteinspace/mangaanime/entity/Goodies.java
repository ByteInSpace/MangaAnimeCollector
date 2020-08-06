package de.byteinspace.mangaanime.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Goodies {
	@Id
	@GeneratedValue
	private Long id;
	private String goodieName;
	
	@ManyToOne
	private Manga manga;


	public String getGoodieName() {
		return goodieName;
	}


	public void setGoodieName(String goodieName) {
		this.goodieName = goodieName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Manga getManga() {
		return manga;
	}


	public void setManga(Manga manga) {
		this.manga = manga;
	}
	
	
}

