package com.example.model;

import java.util.Calendar;
import java.util.Date;

public abstract class Tirocinio {
    private final int id;
    private final Date dataInizio;
    private final Date dataFine;
    private String stato;
    private final String nomeRelatore;
    private final String cognomeRelatore;
    private final Studente studente;

    public Tirocinio(int id, Date dataInizio, Date dataFine, String stato, String nomeRelatore, String cognomeRelatore, Studente studente) {
        this.id = id;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.stato = stato;
        this.nomeRelatore = nomeRelatore;
        this.cognomeRelatore = cognomeRelatore;
        this.studente = studente;
    }

    public int getId() {
        return id;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
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

    public String getCognomeRelatore() {
        return cognomeRelatore;
    }

    public Studente getStudente() {
        return studente;
    }

    public int checkAcceptability() {
        if (this.studente.getCfu() >= 120)
            if (this.checkDurata())
                return 0;
            else
                return 2;
        else
            return 1;
    }

    public int getDurata() {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(this.dataInizio);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(this.dataFine);
        int differenzaAnni = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
        int differenzaMesi = cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);
        return differenzaAnni * 12 + differenzaMesi;
    }
    private boolean checkDurata() {
        int diff = this.getDurata();
        return diff >= 3;
    }
}
