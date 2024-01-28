package com.example.model;

import java.util.Date;

public class TirocinioInterno extends Tirocinio{
    public TirocinioInterno(int id, Date date, String stato, String nomeRelatore, String cognomeRelatore, Studente studente) {
        super(id, date, stato, nomeRelatore, cognomeRelatore, studente);
    }
}
