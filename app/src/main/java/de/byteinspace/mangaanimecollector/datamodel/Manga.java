package de.byteinspace.mangaanimecollector.datamodel;

public class Manga {

    private long id;
    private Series serie;
    private int bandNummer;
    private Language sprache;
    private Person author;
    private int condition;
    private int rating;

    public long getId() {
        return id;
    }

    public Series getSerie() {
        return serie;
    }

    public void setSerie(Series serie) {
        this.serie = serie;
    }

    public int getBandNummer() {
        return bandNummer;
    }

    public void setBandNummer(int bandNummer) {
        this.bandNummer = bandNummer;
    }

    public Language getSprache() {
        return sprache;
    }

    public void setSprache(Language sprache) {
        this.sprache = sprache;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setId(long id) {
        this.id = id;
    }
}
