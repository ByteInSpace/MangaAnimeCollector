package de.byteinspace.mangaanime.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Autor {

	@Id
	@GeneratedValue
	private Long id;
	private String vorname;
	private String nachname;
	
	@OneToMany(mappedBy = "autor")
	private List<Manga> mangas;
	
	@OneToMany(mappedBy = "autor")
	private List<Manga> artbooks;

	public Autor(String vorname, String nachname) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	
}
