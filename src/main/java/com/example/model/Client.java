package com.example.model;
public class Client {
    private SistemaDAO sistemaDAO;

    public Client(){}

    public String getTirociniFilter(String filtro, String input) { return ""; }

    public String getRichieste() {
        String richieste;
        SistemaDAO sistemaDAO = new SistemaDAOImpl();
        richieste = sistemaDAO.getRichieste();
        return richieste;
    }

    public String getTirocini() { return ""; }

    public void accettaRichiesta(int idRichiesta) { }

    private void printRichieste(String richieste) { }

    private void printTirocini(String tirocini) { }
}