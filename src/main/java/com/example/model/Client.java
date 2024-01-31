package com.example.model;

import java.util.ArrayList;

public class Client {
    private final SistemaDAO sistemaDAO;

    public Client(){
        this.sistemaDAO = SistemaDAOImpl.getInstance();
        if(!this.sistemaDAO.load())
            System.err.println("Client: loading delle classi fallito!");
    }
    public void visualizzaRichieste() {
        ArrayList<Tirocinio> richieste;
        richieste = this.sistemaDAO.getRichieste();
        this.printTirocini(richieste);
    }
    public void visualizzaTirocini() {
        ArrayList<Tirocinio> tirocini;
        tirocini = this.sistemaDAO.getTirocini();
        this.printTirocini(tirocini);
    }
    public void visualizzaTirociniFilter(String filtro, String input) {
        ArrayList<Tirocinio> tirociniFilter;
        tirociniFilter = this.sistemaDAO.getTirociniFilter(filtro, input);
        if (tirociniFilter != null) {
            this.printTirocini(tirociniFilter);
        }
        else {
            System.out.println("Client: Visualizzazione non possibile!");
        }
    }
    public void accettaRichiesta(int idRichiesta) {
        if(this.sistemaDAO.accettaRichiesta(idRichiesta))
            System.out.println("Client: Richiesta accettata!");
        else
            System.out.println("Client: Richiesta non accettata!");
    }
    private void printTirocini(ArrayList<Tirocinio> tirocini) {
        for (Tirocinio tir : tirocini) {
            System.out.print(tir.getStudente().getNome() + ","
                            + tir.getStudente().getCognome() + ","
                            + tir.getStudente().getCfu() + ","
                            + tir.getStudente().getMatricola() + ","
                            + tir.getDataInizio() + ","
                            + tir.getDataFine() + ","
                            + tir.getNomeRelatore() + ","
                            + tir.getCognomeRelatore()
            );
            if (tir instanceof TirocinioEsterno)
                System.out.print("," + ((TirocinioEsterno) tir).getTutor().getNome() + ","
                            + ((TirocinioEsterno) tir).getTutor().getCognome()  + ","
                            + ((TirocinioEsterno) tir).getTutor().getAzienda().getNome()
                );
            if (!tir.getStato().isEmpty())
                System.out.print("," + tir.getStato());
            System.out.println();
        }
    }

}
