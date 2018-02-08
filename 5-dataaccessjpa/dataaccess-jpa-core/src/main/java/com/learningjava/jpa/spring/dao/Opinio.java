package com.learningjava.jpa.spring.dao;

public class Opinio {

    private String codi;
    private String opinio;
    private String puntuacio;
    private String user;


    // Getters

    public String getCodi() {
        return codi;
    }

    public String getOpinio() {
        return opinio;
    }

    public String getPuntuacio() {
        return puntuacio;
    }

    public String getUser() {
        return user;
    }

    // Setters

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setOpinio(String opinio) {
        this.opinio = opinio;
    }

    public void setPuntuacio(String puntuacio) {
        this.puntuacio = puntuacio;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
