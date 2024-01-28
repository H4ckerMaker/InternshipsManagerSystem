package com.example.model;

public class Studente {
    private String nome;
    private String cognome;
    private int matricola;
    private int cfu;
    private Tirocinio tirocinio;

    public Studente(String nome, String cognome, int matricola, int cfu, Tirocinio tirocinio) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.cfu = cfu;
        this.tirocinio = tirocinio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public Tirocinio getTirocinio() {
        return tirocinio;
    }

    public void setTirocinio(Tirocinio tirocinio) {
        this.tirocinio = tirocinio;
    }
}
