package com.learningjava.rest.spring.core;
/**
 * com.learningjava.rest.spring.core
 * Class
 * By berto. 12/02/2018
 */
public class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
