package de.byteinspace.mangaanimecollector.datamodel;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Person {

    // Constants
    public static final int MANGAKA = 0;
    public static final int DOLMETSCHER = 1;


    @IntDef({MANGAKA, DOLMETSCHER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PersonMode{ }


    private int id;
    private String vorname;
    private String nachname;
    private int personMode;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @PersonMode
    public int getPersonMode()
    {
        return this.personMode;
    }

    public void setPersonMOde(@PersonMode int mode)
    {
        this.personMode = mode;
    }


    public String getPersonModeAsString()
    {
        switch (this.personMode)
        {
            case  MANGAKA:
                return "Mangaka";
            case DOLMETSCHER:
                return "DOLMETSCHER";
            default:
                return "UNKNOWN";
        }
    }
}
