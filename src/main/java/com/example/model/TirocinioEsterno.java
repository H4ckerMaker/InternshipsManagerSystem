package com.example.model;

import java.util.Date;

public class TirocinioEsterno extends Tirocinio{

    private Tutor tutor;

    public TirocinioEsterno(int id, Date date, String stato, String nomeRelatore, String cognomeRelatore, Studente studente, Tutor tutor) {
        super(id, date, stato, nomeRelatore, cognomeRelatore, studente);
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
