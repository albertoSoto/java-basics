package com.learningjava.jpa.spring.base;

import java.util.List;

/**
 * dummies
 * com.iesemilidarder.fordummies.core
 * Created by alber in 19/12/2017.
 * Description:
 */
public interface IDatabaseActions {
    public void save();
    public void delete();
    public void update();
    public List<DBObject> getAll();
}
