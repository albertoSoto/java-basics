package com.learningjava.rest.spark.core;

/**
 * ies-base
 * com.iesemilidarder.fordummies.web
 * Created by alber in 10/01/2018.
 * Description:
 */
import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }

}