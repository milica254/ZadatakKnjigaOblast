package com.example.termin10.zadaci;

import com.example.termin10.model.Knjiga;
import com.example.termin10.model.Oblast;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;

public class Zadatak3IzmenaVrednosti {

    public static Dao<Knjiga, Integer> knjigaDao = null;
    public static Dao<Oblast, Integer> oblastDao = null;

    public static void main(String[] args) {
        ConnectionSource connectionSource;


        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");
            knjigaDao = DaoManager.createDao(connectionSource, Knjiga.class);
            oblastDao = DaoManager.createDao(connectionSource, Oblast.class);



            QueryBuilder<Oblast, Integer> oblastNazivQuery = oblastDao.queryBuilder();
            Where<Oblast, Integer> where = oblastNazivQuery.where();
            where.like(Oblast.POLJE_NAZIV, "%Activity klasa%" );
            PreparedQuery<Oblast> oblastNazivPripremljen=oblastNazivQuery.prepare();
            List<Oblast> oblast = oblastDao.query(oblastNazivPripremljen);
            for (Oblast o : oblast) {
                o.setPocetnaStrana(35);
                oblastDao.update(o);
                System.out.println(o) ;

            }

            connectionSource.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Desila se nepredvidjena greska.");
        }
    }

}
