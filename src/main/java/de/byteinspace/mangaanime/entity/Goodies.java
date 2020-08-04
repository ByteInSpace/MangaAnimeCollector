package de.byteinspace.mangaanime.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Goodies {
	@Id
	@GeneratedValue
	private Long id;
	private String goodieName;
	
	
	@OneToMany(mappedBy = "autor")
	private List<Manga> mangas;


	public String getGoodieName() {
		return goodieName;
	}


	public void setGoodieName(String goodieName) {
		this.goodieName = goodieName;
	}
	
	
}

