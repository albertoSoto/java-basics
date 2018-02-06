package com.learningjava.rest.dataaccess;

import java.util.ArrayList;

/**
 * zeroproject
 * com.iesemilidarder.projectzero.core
 * Created by alber in 12/01/2018.
 * Description:
 */
public class TestDB {
    public static void main (String... args){
        ReadDB db = new ReadDB();
        ArrayList data = db.readRestaurantes("");
        System.out.println("yuhu");
    }
}
