package com.learningjava.jpa.spring.base;

import com.learningjava.jpa.spring.dao.Opinio;
import com.learningjava.jpa.spring.dao.Restaurant;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Llegeix la base de dades que està ubicada a la IP indicada "35.205.41.45:1521"
 */
public class ReadDB {
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String THIN_URL = "jdbc:oracle:thin:@35.205.41.45:1521:XE";
    private static final String USER = "usuari";
    private static final String PASSWORD = "usuari";

    private Object searchDB(String query, Function<ResultSet, Object> f) {
        Connection con;
        Statement stmt;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(THIN_URL, USER, PASSWORD);
            stmt = con.createStatement();
            // Aquí feim una Query directament a la base de dades:
            ResultSet rs = stmt.executeQuery(query);
            Object o = f.apply(rs);
            stmt.close();
            con.close();
            return o;
        } catch (Exception e) {
            return null;
        }
    }


    public List<Restaurant> readRestaurant(String search) {
        List<Restaurant> arrayRestaurants = new ArrayList<>();
        try {
            String query = StringUtils.EMPTY;
            if (StringUtils.isEmpty(search)) {
                query = "SELECT R.RES_CODI,R.RES_NOM,R.RES_ADRECA,R.RES_WEB,R.RES_TELEFON,R.RES_URL_IMG,R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM " +
                        "RESTAURANTS R,TRESTAURANTS TR WHERE ROWNUM <= 5 AND R.RES_TRS_CODI = TR.TRS_CODI ORDER BY RES_MITJANA DESC";
            } else {
                query = "SELECT R.RES_CODI,R.RES_NOM,R.RES_ADRECA,R.RES_WEB,R.RES_TELEFON,R.RES_URL_IMG,R.RES_MITJANA, TR.TRS_DESCRIPCIO " +
                        "FROM RESTAURANTS R,TRESTAURANTS TR WHERE R.RES_TRS_CODI = TR.TRS_CODI" +
                        " AND LOWER (RES_NOM) LIKE '%" + search.toLowerCase() + "%'";
            }
            ResultSetMapper<Restaurant> a = new ResultSetMapper<>();
            Function<ResultSet, Object> func = new Function<ResultSet, Object>() {
                public Object apply(ResultSet rs) {
                    return a.mapResultSetToObject(rs, Restaurant.class);
                }
            };
            arrayRestaurants = (ArrayList) searchDB(query, func);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return arrayRestaurants;
    }

    public static Restaurant readRestaurantInfo(String id) {
        Restaurant restaurant = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");
            PreparedStatement stmt = con.prepareStatement("SELECT R.RES_CODI,R.RES_NOM,R.RES_ADRECA,R.RES_WEB,R.RES_TELEFON,R.RES_URL_IMG,R.RES_MITJANA, TR.TRS_DESCRIPCIO " +
                    "FROM RESTAURANTS R,TRESTAURANTS TR WHERE TR.TRS_CODI=R.RES_TRS_CODI AND R.RES_CODI='" + id + "'");
            // Aquí feim una Query directament a la base de dades:
            ResultSet rs = stmt.executeQuery();

            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return restaurant;
    }

    public ArrayList readOpinions(String id) {

        ArrayList arrayOpinions = new ArrayList();

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "SELECT O.OPI_OBSERVACIO, O.OPI_PUNTUACIO, U.USU_NOM FROM OPINIONS O\n" +
                            "JOIN USUARIS U ON U.USU_CODI = O.OPI_USU_CODI\n" +
                            "JOIN RESTAURANTS R ON O.OPI_RES_CODI = R.RES_CODI\n" +
                            "WHERE R.RES_CODI = '" + id + "'"

            );

            while (rs.next()) {

                String opinio = rs.getString("OPI_OBSERVACIO");
                String user = rs.getString("USU_NOM");
                String puntuacio = rs.getString("OPI_PUNTUACIO");


                Opinio opn = new Opinio();

                opn.setOpinio(opinio);
                opn.setUser(user);
                opn.setPuntuacio(puntuacio);


                arrayOpinions.add(opn);

            }
            stmt.close();
            con.close();


        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return arrayOpinions;
    }

    public List readRestaurantAPI() {
        List<Restaurant> arrayRestaurants = new ArrayList<>();
        try {
            //VERSION GENERICS
            String query = "SELECT R.RES_CODI,R.RES_NOM,R.RES_ADRECA,R.RES_WEB,R.RES_TELEFON,R.RES_URL_IMG,R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM " +
                    "RESTAURANTS R,TRESTAURANTS TR WHERE  R.RES_TRS_CODI = TR.TRS_CODI";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");
            Statement stmt = con.createStatement();
            // Aquí feim una Query directament a la base de dades:
            ResultSet rs = stmt.executeQuery(query);
            // I aquí indicam que mentres hi hagi mes restaurants, segueixi impriment-los.
            ResultSetMapper<Restaurant> mapper = new ResultSetMapper<>();
            arrayRestaurants= mapper.mapResultSetToObject(rs,Restaurant.class);
            stmt.close();con.close();
            //VERSION FUNCTIONAL
            arrayRestaurants = new ArrayList<>();
            Function<ResultSet, Object> func = new Function<ResultSet, Object>() {
                public Object apply(ResultSet rs) {
                    return mapper.mapResultSetToObject(rs, Restaurant.class);
                }
            };
            arrayRestaurants = (ArrayList) searchDB(query, func);
            System.out.println("yuhu v2");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return arrayRestaurants;
    }
}






