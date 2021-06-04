package com.example.termin10.model;

import com.example.termin10.model.Knjiga;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "oblast")
public class Oblast {
    public static final String POLJE_NAZIV = "naziv";
    public static final String POLJE_POCETNA_STRANA = "pocetna_strana";
    public static final String POLJE_KNJIGA_ID = "knjiga_id";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = POLJE_NAZIV, canBeNull = false, unique = false)
    private String naziv;

    @DatabaseField(columnName = POLJE_POCETNA_STRANA, canBeNull = false, unique = false)
    private int pocetnaStrana;

    @DatabaseField(columnName = POLJE_KNJIGA_ID, foreign = true, foreignAutoRefresh = true, canBeNull = false)
    private Knjiga knjiga;

    public Oblast() {
    }

    public Oblast(String naziv, int pocetnaStrana) {
        this.naziv = naziv;
        this.pocetnaStrana = pocetnaStrana;
    }


    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getPocetnaStrana() {
        return pocetnaStrana;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setPocetnaStrana(int pocetnaStrana) {
        this.pocetnaStrana = pocetnaStrana;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }


    @Override
    public String toString() {
        return "Oblast{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", pocetnaStrana=" + pocetnaStrana +
                '}';
    }
}
