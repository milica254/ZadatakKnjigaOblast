package com.example.termin10.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "knjiga")
public class Knjiga {
    public static final String POLJE_NASLOV = "naslov";
    public static final String POLJE_BROJ_STRANA = "broj_strana ";
    public static final String POLJE_DATUM_IZDAVANJA = "datum_izdavanja ";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = POLJE_NASLOV, canBeNull = false, unique = false)
    private String naslov;

    @DatabaseField(columnName = POLJE_BROJ_STRANA, canBeNull = false, unique = false)
    private int brojStrana;

    @DatabaseField(columnName = POLJE_DATUM_IZDAVANJA, canBeNull = false, unique = false)
    private Date datumIzdanja;

    private boolean prisutna;

    @ForeignCollectionField( foreignFieldName = "knjiga" , eager = false , maxEagerLevel = 1)
    private ForeignCollection<Oblast> oblasti;

    public Knjiga(String naslov, int brojStrana, Date datumIzdanja) {
        this.naslov = naslov;
        this.brojStrana = brojStrana;
        this.datumIzdanja = datumIzdanja;
    }

    public Knjiga() {
    }

    public int getId() {
        return id;
    }

    public String getNaslov() {
        return naslov;
    }

    public int getBrojStrana() {
        return brojStrana;
    }

    public Date getDatumIzdanja() {
        return datumIzdanja;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public void setBrojStrana(int brojStrana) {
        this.brojStrana = brojStrana;
    }

    public void setDatumIzdanja(Date datumIzdanja) {
        this.datumIzdanja = datumIzdanja;
    }

    public ForeignCollection<Oblast> getOblasti() {
        return oblasti;
    }

    public void setOblasti(ForeignCollection<Oblast> oblasti) {
        this.oblasti = oblasti;
    }

    @Override
    public String toString() {
        return "Knjiga{" +
                "id=" + id +
                ", naslov='" + naslov + '\'' +
                ", brojStrana=" + brojStrana +
                ", datumIzdanja=" + datumIzdanja +
                '}';
    }
}
