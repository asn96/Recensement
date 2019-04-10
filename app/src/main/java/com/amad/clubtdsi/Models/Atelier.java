package com.amad.clubtdsi.Models;

public class Atelier {

    private String id;
    private String sujet;
    private String presentateur;
    private String lieu;
    private String heure;

    public Atelier() {
    }

    public Atelier(String id, String sujet, String presentateur, String lieu, String heure) {
        this.id = id;
        this.sujet = sujet;
        this.presentateur = presentateur;
        this.lieu = lieu;
        this.heure = heure;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getPresentateur() {
        return presentateur;
    }

    public void setPresentateur(String presentateur) {
        this.presentateur = presentateur;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
