package de.byteinspace.mangaanime.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Figure {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne 
	private Serie serie;
	
	@ManyToOne 
	private Publisher publisher;
	
	private String figureName;
	private boolean ovp;
	private int figureCondition;
	private String figureComment;
	private String fileName;
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
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public String getFigureName() {
		return figureName;
	}
	public void setFigureName(String figureName) {
		this.figureName = figureName;
	}
	public boolean isOvp() {
		return ovp;
	}
	public void setOvp(boolean ovp) {
		this.ovp = ovp;
	}
	public int getFigureCondition() {
		return figureCondition;
	}
	public void setFigureCondition(int figureCondition) {
		this.figureCondition = figureCondition;
	}
	public String getFigureComment() {
		return figureComment;
	}
	public void setFigureComment(String figureComment) {
		this.figureComment = figureComment;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
	
	
}
