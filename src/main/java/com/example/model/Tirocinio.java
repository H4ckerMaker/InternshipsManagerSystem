package com.example.model;

import java.util.Date;

public abstract class Tirocinio {
    private int id;
    private Date date;
    private String stato;
    private String nomeRelatore;
    private String cognomeRelatore;
    private Studente studente;

    public Tirocinio(int id, Date date, String stato, String nomeRelatore, String cognomeRelatore, Studente studente) {
        this.id = id;
        this.date = date;
        this.stato = stato;
        this.nomeRelatore = nomeRelatore;
        this.cognomeRelatore = cognomeRelatore;
        this.studente = studente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getNomeRelatore() {
        return nomeRelatore;
    }

    public void setNomeRelatore(String nomeRelatore) {
        this.nomeRelatore = nomeRelatore;
    }

    public String getCognomeRelatore() {
        return cognomeRelatore;
    }

    public void setCognomeRelatore(String cognomeRelatore) {
        this.cognomeRelatore = cognomeRelatore;
    }

    public boolean isAcceptable() { return false; }

    private boolean checkDurata() { return false; }

    public Studente getStudente() {
        return studente;
    }

    public void setStudente(Studente studente) {
        this.studente = studente;
    }
}
