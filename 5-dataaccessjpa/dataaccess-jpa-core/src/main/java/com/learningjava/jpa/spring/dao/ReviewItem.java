package com.learningjava.jpa.spring.dao;

import com.learningjava.jpa.spring.base.DBObject;

/**
 * dummies
 * com.iesemilidarder.fordummies.core
 * Created by alber in 19/12/2017.
 * Description:
 *
 * Review class for restaurants and many other concepts
 * Let's see
 */
public class ReviewItem extends DBObject {
    private int id;
    private String name;
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    protected void beforeSave() {
        doLog("todo!");
    }
}
