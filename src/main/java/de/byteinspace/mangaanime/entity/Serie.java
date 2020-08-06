package de.byteinspace.mangaanime.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Serie {

	@Id
	@GeneratedValue
	private Long id;
	private String nameDeutsch;
	private String nameOrginal;
	@OneToMany(mappedBy = "serie")
	private List<Manga> mangas;
	@OneToMany(mappedBy = "serie")
	private List<Manga> artbooks;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameDeutsch() {
		return nameDeutsch;
	}
	public void setNameDeutsch(String nameDeutsch) {
		this.nameDeutsch = nameDeutsch;
	}
	public String getNameOrginal() {
		return nameOrginal;
	}
	public void setNameOrginal(String nameOrginal) {
		this.nameOrginal = nameOrginal;
	}
	
	
}
