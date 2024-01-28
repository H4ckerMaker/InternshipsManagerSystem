package com.example.model;

import com.mongodb.*;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;

public class SistemaDAOImpl implements SistemaDAO {

    private final String uri = "mongodb+srv://administrator:tirocinio1908@gestionetirocini.nhyotds.mongodb.net/?retryWrites=true&w=majority";
    private final ServerApi serverApi;
    private final MongoClientSettings settings;

    private ArrayList<Studente> studenti;
    private ArrayList<Tirocinio> tirocini;
    private ArrayList<Tutor> tutor;
    private ArrayList<Azienda> aziende;

    public SistemaDAOImpl() {
        this.studenti = new ArrayList<>();
        this.tirocini = new ArrayList<>();
        this.tutor = new ArrayList<>();
        this.aziende = new ArrayList<>();
        this.serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        this.settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(this.uri))
                .serverApi(this.serverApi)
                .build();
        try (MongoClient mongoClient = MongoClients.create(this.settings)) {
            MongoDatabase database = mongoClient.getDatabase("GestioneTirocini");
            MongoCollection<Document> CollectionStudenti = database.getCollection("Studenti");
            FindIterable<Document> StudentiIterator = CollectionStudenti.find();
            for(Document stud : StudentiIterator) {
                this.studenti.add(new Studente(
                        stud.getString("nome"),
                        stud.getString("cognome"),
                        stud.getInteger("matricola"),
                        stud.getInteger("cfu"),
                        null)
                );
            }
            //TODO: Inserire in RAM i tirocini dal DB
            MongoCollection<Document> CollectionTirocini = database.getCollection("Tirocini");
            FindIterable<Document> TirociniIterator = CollectionTirocini.find();
            for(Document tir : TirociniIterator) {
                //TODO : Controllare che IdStudente esista e controllare se esterno o interno
            }
        }
    }

    @Override
    public String getRichieste() {
        return "";
    }

    @Override
    public String getTirocini() {
        return null;
    }

    @Override
    public String getTirociniFilter(String filtro, String input) {
        return null;
    }

    @Override
    public Tirocinio getRichiesta(int idRichiesta) {
        return null;
    }


}