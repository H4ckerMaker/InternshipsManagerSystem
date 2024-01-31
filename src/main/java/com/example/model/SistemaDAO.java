package com.example.model;

import java.util.ArrayList;

public interface SistemaDAO {

    boolean load();
    ArrayList<Tirocinio> getRichieste();
    ArrayList<Tirocinio> getTirocini();
    ArrayList<Tirocinio> getTirociniFilter(String filtro, String input);
    boolean accettaRichiesta(int idRichiesta);
}