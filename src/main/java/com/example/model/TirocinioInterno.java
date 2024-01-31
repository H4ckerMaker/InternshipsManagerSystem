package com.example.model;

import java.util.Date;

public class TirocinioInterno extends Tirocinio{
    public TirocinioInterno(int id, Date dataInizio, Date dataFine, String stato, String nomeRelatore, String cognomeRelatore, Studente studente) {
        super(id, dataInizio, dataFine, stato, nomeRelatore, cognomeRelatore, studente);
    }
}
