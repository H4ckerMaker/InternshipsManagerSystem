package com.example.model;

import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;

public class SistemaDAOImpl implements SistemaDAO {

    private static SistemaDAOImpl singleton;
    private final MongoClientSettings settings;
    private final ArrayList<Studente> studenti;
    private final ArrayList<Tirocinio> tirocini;
    private final ArrayList<Tutor> tutor;
    private final ArrayList<Azienda> aziende;

    public static SistemaDAOImpl getInstance() {
        if (singleton == null)
            singleton = new SistemaDAOImpl();
        return singleton;
    }
    private SistemaDAOImpl() {
        this.studenti = new ArrayList<>();
        this.tirocini = new ArrayList<>();
        this.tutor = new ArrayList<>();
        this.aziende = new ArrayList<>();
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        String uri = "mongodb+srv://administrator:tirocinio1908@gestionetirocini.nhyotds.mongodb.net/?retryWrites=true&w=majority";
        this.settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .serverApi(serverApi)
                .build();
    }

    public boolean load() {
        try (MongoClient mongoClient = MongoClients.create(this.settings)) {
            MongoDatabase database = mongoClient.getDatabase("GestioneTirocini");
            loadStudenti(database);
            loadAziende(database);
            loadTutor(database);
            loadTirocini(database);
            return true;
        } catch (MongoException me) {
            System.err.println("Errore nel loading delle classi dal Database: " + me);
            return false;
        }
    }

    private void loadStudenti(MongoDatabase database) throws MongoException {
        MongoCollection<Document> CollectionStudenti = database.getCollection("Studenti");
        FindIterable<Document> StudentiIterator = CollectionStudenti.find();
        for(Document stud : StudentiIterator) {
            this.studenti.add(new Studente(
                    stud.getString("nome"),
                    stud.getString("cognome"),
                    stud.getInteger("matricola"),
                    stud.getInteger("cfu"),
                    null
            ));
        }
    }

    private void loadAziende(MongoDatabase database) throws MongoException {
        MongoCollection<Document> CollectionAziende = database.getCollection("Aziende");
        FindIterable<Document> AziendeIterator = CollectionAziende.find();
        for(Document az : AziendeIterator) {
            this.aziende.add(new Azienda(
                    az.getString("nome"),
                    Integer.parseInt(az.getString("piva")),
                    new ArrayList<>()
            ));
        }
    }

    private void loadTutor(MongoDatabase database) throws MongoException {
        MongoCollection<Document> CollectionTutor = database.getCollection("Tutor");
        FindIterable<Document> TutorIterator = CollectionTutor.find();
        for(Document tut : TutorIterator) {
            for (Azienda az : this.aziende) {
                if (az.getPiva() == Integer.parseInt(tut.getString("azienda"))) {
                    Tutor t = new Tutor(
                            tut.getString("nome"),
                            tut.getString("cognome"),
                            new ArrayList<>(),
                            az,
                            Integer.parseInt(tut.getString("id"))
                    );
                    this.tutor.add(t);
                    az.getTutor().add(t);
                }
            }
        }
    }

    private void loadTirocini(MongoDatabase database) throws MongoException {
        MongoCollection<Document> CollectionTirocini = database.getCollection("Tirocini");
        FindIterable<Document> TirociniIterator = CollectionTirocini.find();
        for(Document tir : TirociniIterator) {
            for(Studente stud : this.studenti) {
                if (stud.getMatricola() == Integer.parseInt(tir.getString("IdStudente"))){
                    if (tir.getString("tipo").equals("interno")){
                        TirocinioInterno ti = new TirocinioInterno(
                                Integer.parseInt(tir.getString("IdStudente")),
                                tir.getDate("dataInizio"),
                                tir.getDate("dataFine"),
                                tir.getString("stato"),
                                tir.getString("nomeRelatore"),
                                tir.getString("cognomeRelatore"),
                                stud
                        );
                        this.tirocini.add(ti);
                        stud.setTirocinio(ti);
                    }
                    if (tir.getString("tipo").equals("esterno")) {
                        for (Tutor tut : this.tutor) {
                            if (tut.getId() == Integer.parseInt(tir.getString("tutor"))) {
                                TirocinioEsterno te = new TirocinioEsterno(
                                        Integer.parseInt(tir.getString("IdStudente")),
                                        tir.getDate("dataInizio"),
                                        tir.getDate("dataFine"),
                                        tir.getString("stato"),
                                        tir.getString("nomeRelatore"),
                                        tir.getString("cognomeRelatore"),
                                        stud,
                                        tut
                                );
                                this.tirocini.add(te);
                                stud.setTirocinio(te);
                                tut.getTirocini().add(te);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public ArrayList<Tirocinio> getRichieste() {
        ArrayList<Tirocinio> array = new ArrayList<>();
        for (Tirocinio tir : this.tirocini) {
            if (tir.getStato().isEmpty()) {
                array.add(tir);
            }
        }
        return array;
    }

    @Override
    public ArrayList<Tirocinio> getTirocini() {
        ArrayList<Tirocinio> array = new ArrayList<>();
        for (Tirocinio tir : this.tirocini) {
            if (tir.getStato().equals("approvato") || tir.getStato().equals("iniziato") || tir.getStato().equals("terminato")) {
                array.add(tir);
            }
        }
        return array;
    }

    @Override
    public ArrayList<Tirocinio> getTirociniFilter(String filtro, String input) {
        ArrayList<Tirocinio> array = new ArrayList<>();
        switch (filtro) {
            case "durata":
                int months;
                try {
                    months = Integer.parseInt(input);
                }catch (Exception e) {
                    System.err.println("SistemaDAO: Il filtro durata non è un numero!");
                    return null;
                }
                for (Tirocinio tir : this.tirocini) {
                    if (tir.getDurata() >= months) {
                        if (tir.getStato().equals("approvato") || tir.getStato().equals("iniziato") || tir.getStato().equals("terminato")) {
                            array.add(tir);
                        }
                    }
                }
                break;
            case "anagrafica":
                for (Tirocinio tir : this.tirocini) {
                    if (tir.getStudente().getNome().equals(input)) {
                        if (tir.getStato().equals("approvato") || tir.getStato().equals("iniziato") || tir.getStato().equals("terminato")) {
                            array.add(tir);
                        }
                    }
                }
                break;
            case "stato":
                if (input.equals("approvato") || input.equals("iniziato") || input.equals("terminato")){
                    for (Tirocinio tir : this.tirocini) {
                        if (tir.getStato().equals(input)) {
                            array.add(tir);
                        }
                    }
                } else {
                    System.err.println("SistemaDAO: Il filtro stato non è corretto!");
                    return null;
                }
                break;
            default:
                System.err.println("SistemaDAO: Filtro selezionato inesistente!");
                return null;
        }
        return array;
    }

    @Override
    public boolean accettaRichiesta(int idRichiesta) {
        for (Tirocinio tir : this.tirocini) {
            if(tir.getId() == idRichiesta && tir.getStato().isEmpty()){
                if (tir.checkAcceptability() == 0) {
                    try (MongoClient mongoClient = MongoClients.create(this.settings)) {
                        MongoDatabase database = mongoClient.getDatabase("GestioneTirocini");
                        MongoCollection<Document> tirocini = database.getCollection("Tirocini");
                        Document query = new Document().append("IdStudente", String.valueOf(idRichiesta));
                        Bson update = Updates.combine(Updates.set("stato", "approvato"));
                        UpdateResult result = tirocini.updateOne(query, update);
                        tir.setStato("approvato");
                        System.out.println("SistemaDAO: Richiesta approvata: " +result);
                        return true;
                    } catch (MongoException me) {
                        System.err.println("SistemaDAO: Non sono in grado di aggiornare lo stato per l'errore: " + me);
                        return false;
                    }
                } else if (tir.checkAcceptability() == 1) {
                    System.err.println("SistemaDAO: Lo studente non ha abbastanza crediti!");
                    return false;
                } else {
                    System.err.println("SistemaDAO: Il tirocinio non dura almeno 3 mesi!");
                    return false;
                }
            }
        }
        System.err.println("SistemaDAO: Non esiste una richiesta con l'id specificato!");
        return false;
    }

}