package com.example.model;

import java.util.ArrayList;

public class Tutor {
    private String nome;
    private String cognome;

    private ArrayList<TirocinioEsterno> tirocini;
    private Azienda azienda;

    public Tutor(String nome, String cognome, ArrayList<TirocinioEsterno> tirocini, Azienda azienda) {
        this.nome = nome;
        this.cognome = cognome;
        this.tirocini = tirocini;
        this.azienda = azienda;
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

    public Azienda getAzienda() {
        return azienda;
    }

    public void setAzienda(Azienda azienda) {
        this.azienda = azienda;
    }

    public ArrayList<TirocinioEsterno> getTirocini() {
        return tirocini;
    }

    public void setTirocini(ArrayList<TirocinioEsterno> tirocini) {
        this.tirocini = tirocini;
    }
}
