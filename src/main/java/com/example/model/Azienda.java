package com.example.model;

import java.util.ArrayList;

public class Azienda {
    private String nome;
    private int piva;
    private ArrayList<Tutor> tutor;

    public Azienda(String nome, int piva, ArrayList<Tutor> tutor) {
        this.nome = nome;
        this.piva = piva;
        this.tutor = tutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPiva() {
        return piva;
    }

    public void setPiva(int piva) {
        this.piva = piva;
    }

    public ArrayList<Tutor> getTutor() {
        return tutor;
    }

    public void setTutor(ArrayList<Tutor> tutor) {
        this.tutor = tutor;
    }
}
