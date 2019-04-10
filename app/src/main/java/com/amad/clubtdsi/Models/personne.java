package com.amad.clubtdsi.Models;

public class personne {

    private String id;
    private String nom_complet;
    private String email;
    private String telephone;

    public personne() {
    }

    private String atelier;


    public personne(String id, String nom_complet, String email, String telephone, String atelier) {
        this.id = id;
        this.nom_complet = nom_complet;
        this.email = email;
        this.telephone = telephone;
        this.atelier = atelier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom_complet() {
        return nom_complet;
    }

    public void setNom_complet(String nom_complet) {
        this.nom_complet = nom_complet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAtelier() {
        return atelier;
    }

    public void setAtelier(String atelier) {
        this.atelier = atelier;
    }
}
