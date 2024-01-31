package com.example.model;

import java.util.Date;

public class TirocinioEsterno extends Tirocinio{

    private final Tutor tutor;

    public TirocinioEsterno(int id, Date dataInizio, Date dataFine, String stato, String nomeRelatore, String cognomeRelatore, Studente studente, Tutor tutor) {
        super(id, dataInizio, dataFine, stato, nomeRelatore, cognomeRelatore, studente);
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }
}
