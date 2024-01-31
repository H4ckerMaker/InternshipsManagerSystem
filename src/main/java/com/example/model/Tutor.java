package com.example.model;

import java.util.ArrayList;

public class Tutor {
    private final String nome;
    private final String cognome;

    private final ArrayList<TirocinioEsterno> tirocini;
    private final Azienda azienda;

    private final int id;

    public Tutor(String nome, String cognome, ArrayList<TirocinioEsterno> tirocini, Azienda azienda, int id) {
        this.nome = nome;
        this.cognome = cognome;
        this.tirocini = tirocini;
        this.azienda = azienda;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public ArrayList<TirocinioEsterno> getTirocini() {
        return tirocini;
    }

    public Azienda getAzienda() {
        return azienda;
    }

    public int getId() {
        return id;
    }
}
