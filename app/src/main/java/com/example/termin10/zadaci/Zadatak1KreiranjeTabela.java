package com.example.termin10.zadaci;

import com.example.termin10.model.Knjiga;
import com.example.termin10.model.Oblast;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Zadatak1KreiranjeTabela {


    public static void main(String[] args) {

            try {
                ConnectionSource connectionSource = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");
                TableUtils.dropTable ( connectionSource,  Oblast.class, true );
                TableUtils.dropTable ( connectionSource,  Knjiga.class, true );


                TableUtils.createTable ( connectionSource , Knjiga.class );
                TableUtils.createTable ( connectionSource , Oblast.class );

                connectionSource.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Desila se nepredvidjena greska.");
            }
    }


}
