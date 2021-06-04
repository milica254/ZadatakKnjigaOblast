package com.example.termin10.zadaci;

import com.example.termin10.model.Knjiga;
import com.example.termin10.model.Oblast;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.Date;

public class Zadatak2DodavanjeVrednosti {

    public static Dao<Knjiga, Integer> knjigaDao = null;
    public static Dao<Oblast, Integer> oblastDao = null;

    public static void main(String[] args) {
        ConnectionSource connectionSource;


        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");
            knjigaDao = DaoManager.createDao(connectionSource, Knjiga.class);
            oblastDao = DaoManager.createDao(connectionSource, Oblast.class);

            TableUtils.clearTable(connectionSource, Knjiga.class);
            TableUtils.clearTable(connectionSource, Oblast.class);

            Knjiga javaProgramiranje = new Knjiga("Java programiranje", 650, new Date());
            knjigaDao.create(javaProgramiranje);

            Knjiga androidProgramiranje = new Knjiga("Android programiranje", 500, new Date());
            knjigaDao.create(androidProgramiranje);

            Oblast uvod = new Oblast("Uvod", 2);
            uvod.setKnjiga(javaProgramiranje);
            oblastDao.create(uvod);

            Oblast naredbe = new Oblast("Naredbe", 10);
            naredbe.setKnjiga(javaProgramiranje);
            oblastDao.create(naredbe);

            Oblast aritmetickiOperatori = new Oblast("Aritmeticki operatori", 20);
            aritmetickiOperatori.setKnjiga(javaProgramiranje);
            oblastDao.create(aritmetickiOperatori);

            Oblast androidOperativniSistem = new Oblast("Android operativni sistem", 2);
            androidOperativniSistem.setKnjiga(androidProgramiranje);
            oblastDao.create(androidOperativniSistem);

            Oblast activityKlasa = new Oblast("Activity klasa", 30);
            activityKlasa.setKnjiga(androidProgramiranje);
            oblastDao.create(activityKlasa);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
