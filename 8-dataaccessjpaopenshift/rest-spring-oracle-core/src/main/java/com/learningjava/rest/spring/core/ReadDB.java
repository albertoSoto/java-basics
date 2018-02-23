package com.learningjava.rest.spring.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * com.learningjava.rest.spark.core
 * Class
 * By berto. 12/02/2018
 */
public class ReadDB extends Restaurantes {
    // se crea el objeto con un parametro
    public ArrayList readRestaurantes(String cerca) {
        // se crea array list
        ArrayList array1 = new ArrayList();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");
            // se crea este statement para incluir dos querys
            PreparedStatement stmt;
            if ((cerca != null) && !cerca.equals("")) {
                // query con parametro
                stmt = con.prepareStatement("select * from ( select R.RES_NOM,  RR.TRS_DESCRIPCIO, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, R.RES_URL_IMG from RESTAURANTS R, TRESTAURANTS RR  WHERE RES_TRS_CODI = TRS_CODI  AND LOWER(R.RES_NOM) LIKE ? order by RES_MITJANA ASC ) where ROWNUM <= 5");
                stmt.setString(1, "%" + cerca.toLowerCase() + "%");
                // query sin parametro
            } else {
                stmt = con.prepareStatement("select * from ( select R.RES_NOM,  RR.TRS_DESCRIPCIO, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, R.RES_URL_IMG from RESTAURANTS R, TRESTAURANTS RR  WHERE RES_TRS_CODI = TRS_CODI order by RES_MITJANA ASC ) where ROWNUM <= 5");
            }
            // saca informacion y la coloca en los atributos java
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nom = rs.getString("RES_NOM");
                String descripcio = rs.getString("TRS_DESCRIPCIO");
                String adreca = rs.getString("RES_ADRECA");
                String web = rs.getString("RES_WEB");
                String telefon = rs.getString("RES_TELEFON");
                String imagen = rs.getString("RES_URL_IMG");
                Restaurantes rts = new Restaurantes();
                rts.setNom(nom);
                rts.setDescripcio(descripcio);
                rts.setAdreca(adreca);
                rts.setWeb(web);
                rts.setTelefon(telefon);
                rts.setImagen(imagen);
                array1.add(rts);
            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return array1;
    }
}
