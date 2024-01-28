package com.example.model;

public interface SistemaDAO {

    String getRichieste();
    Tirocinio getRichiesta(int idRichiesta);
    String getTirocini();
    String getTirociniFilter(String filtro, String input);

}