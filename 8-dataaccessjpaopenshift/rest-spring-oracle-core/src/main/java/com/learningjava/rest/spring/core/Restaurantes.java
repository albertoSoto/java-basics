package com.learningjava.rest.spring.core;
/**
 * com.learningjava.rest.spark.core
 * Class
 * By berto. 12/02/2018
 */
public class Restaurantes {
// atributos
        private String nom;
        private String adreca;
        private String web;
        private String telefon;
        private String descripcio;
        private String imagen;


// setters and getters
        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getAdreca() {
            return adreca;
        }

        public void setAdreca(String adreca) {
            this.adreca = adreca;
        }

        public String getWeb() {
            return web;
        }

        public void setWeb(String web) {
            this.web = web;
        }

        public String getTelefon() {
            return telefon;
        }

        public void setTelefon(String telefon) {
            this.telefon = telefon;
        }

        public String getDescripcio() {
            return descripcio;
        }

        public void setDescripcio(String descripcio) {
            this.descripcio = descripcio;
        }
         public String getImagen() {
            return imagen;
        }

        public void setImagen(String imagen) {
            this.imagen = imagen;
        }
    }
