package com.learningjava.rest.spark.core;

import java.util.ArrayList;

/**
 * com.learningjava.rest.spark.core
 * Class
 * By berto. 12/02/2018
 */
public class TestDB {
    public static void main (String... args){
        ReadDB db = new ReadDB();
        ArrayList data = db.readRestaurantes("");
        System.out.println("yuhu");
    }
}
