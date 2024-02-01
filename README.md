**Applicazione per gestione tirocini**

**Lorenzo Fallani**

**1 Descrizione del problema**

Si vuole realizzare un’applicazione per la gestione dei tirocini associati alle tesi per i corsi di laurea triennali del Dipartimento di Informatica.

L’applicazione deve aiutare a gestire l’attivazione e disattivazione dei tirocini di laurea.

**1.1 Analisi e specifica dei requisiti**

**1.1.1 Requisiti funzionali**

1\. L’applicazione deve archiviare le richieste di tirocinio da parte degli studenti, le quali si dividono in richieste di tirocinio interne ed esterne. (Le informazioni relative alle richieste sono consultate quando è necessaria l’ approvazione del tirocinio)

2\. L’applicazione deve permettere al gestore di accettare le richieste di tirocinio archiviate nel caso esse soddisfino i requisiti di durata minima del tirocinio di 3 mesi. (L’ accettazione verrà utilizzata per distinguere i tirocini approvati da quelli non approvati)

3\. L’applicazione deve permettere al gestore di verificare che lo studente che richiede il tirocinio sia in regola con i requisiti per entrare in tesi, nel nostro caso che abbia almeno 120 cfu. (Uno studente non può entrare in tesi se non ha superato un certo numero di esami)

4\. L’applicazione deve permettere al gestore di tenere traccia della durata del tirocinio. (Il gestore deve sempre controllare che la durata del tirocinio sia maggiore o uguale a 3 mesi anche nel caso essa venga modificata durante il tirocinio)

5\. L’applicazione deve permettere al gestore di raccogliere l’anagrafica necessaria ai tirocini interni, come i dati degli studenti e i dati dei relatori, e a quelli esterni, dove si aggiungono anche i dati dell’ azienda esterna e i dati del tutor aziendale. (Le informazioni relative ai tirocini attivi sono utilizzate a scopo analitico e gestionale)

6\. L’applicazione deve permettere al gestore di vedere lo stato dei tirocini, che si suddividono in: approvato, iniziato e terminato. (Questa suddivisione viene fatta per facilitare la ricerca di tirocini con le stesse caratteristiche)

**1.1.2 Requisiti non funzionali**

1\. L’applicazione deve cambiare lo stato di un tirocinio in modo automatico nelle occorrenze dei vari eventi. (Si prevede che con un sistema automatico il gestore non abbia bisogno di cambiare manualmente lo stato dei tirocini, aumentando così la facilità d’ uso)

2\. L’applicazione deve controllare che le richieste di tirocinio da parte degli studenti siano ben formate, e nel caso non lo siano essa deve rifiutarle. (Si prevede un archivio con richieste consistenti, con formato ben preciso e corrette sintatticamente)

3\. L’applicazione deve controllare in modo automatico che ci sia al massimo una e soltanto una richiesta di tirocinio per studente. (Uno studente non può effettuare più richieste di tirocinio. Viene garantito quindi anche che ci sia al massimo uno e soltanto un solo tirocinio attivo)

4\. L’applicazione deve inviare un prompt di conferma al gestore nel caso in cui esso voglia accettare il tirocinio di uno studente. (Per evitare errori di misclick è necessario ottenere una conferma da parte del gestore in quanto non sia possibile tornare indietro una volta accettato un tirocinio)

**1.2 Glossario**

|**Termine** |**Definizione**|
| :- | :- |
|<p>Amministratore/</p><p>Gestore</p>|Persona fisica addetta alla gestione dei tirocini associati alle tesi degli studenti. Inoltre possiede i permessi per eseguire l’applicazione e controllare i dati degli studenti che hanno fatto richiesta.|
|Banner|Finestra visualizzata a schermo che contiene delle informazioni relative ad un evento accaduto.|
|Cardinalità|Numero di elementi che appartengono ad un insieme.|
|Entry|Informazione che contiene vari campi raggruppati e viene salvata all’ interno di un sistema di archiviazione. Rappresenta tutte le informazioni di un'entità (Ex. Studente)|
|Filtro|Un elemento a schermo che permette di effettuare una ricerca secondo alcuni criteri ben precisi. (Ex. Trova quei tirocini che hanno durata maggiore di 4 mesi)|
|Form|Modulo da compilare per fare la richiesta di tirocinio.|
|MissClick|Quando si sbaglia a cliccare su un elemento a schermo.|
|Prompt di Conferma|Finestra visualizzata a schermo che chiede la conferma di un’ azione che si vuole eseguire.|
|SQL |Linguaggio che permette di eseguire delle domande ad un archivio. (Ex. Trova nome dello studente che ha cognome Rossi)|

**2 Progettazione del Sistema**

**2.1 Diagramma dei casi d’uso**

- **UseCaseDiagram/UseCaseDiagram1.jpg**

**2.2 Descrizione dei casi d’uso e scenari**

|**Nome**|Richiesta Tirocinio Interno/Esterno|
| :- | :- |
|**Attore/i**|Studente - Studente, Azienda Esterna|
|**Scopo**|Archiviare la richiesta di tirocinio interno/esterno nell’ archivio delle richieste dei tirocini |
|**Pre-Condizioni**|<p>1. Nella richiesta di tirocinio devono essere presenti tutte le informazioni necessarie per l’ approvazione. In particolare i dati dello studente, i dati del relatore, data di inizio tirocinio e data di fine tirocinio.Nel caso di tirocinio esterno deve contenere anche i dati del tutor aziendale e il nome dell’ azienda.</p><p>2. La richiesta di tirocinio non deve contenere comandi SQL e quindi essere sanitizzata.</p>|
|**Trigger**|<p>1) Lo studente dopo aver compilato un form sul sito dell’ università clicca ‘Invia richiesta di Tirocinio Interno’</p><p>2) Lo studente e l’ Azienda Esterna dopo essersi messi d’accordo e aver compilato un form sul sito dell’ università cliccano ‘Invia richiesta di Tirocinio Esterno’</p>|
|**Descrizione**|Consente allo studente di creare una entry nell’ archivio delle richieste di tirocinio|
|**Sequenza Eventi**|<p>**Azioni Sistema**</p><p>1. Il sistema riceve la richiesta di tirocinio.</p><p>2. La richiesta di tirocinio soddisfa il formato, è presente di tutte le informazioni necessarie per l’ approvazione e lo studente non ha già altre entry nell’ archivio delle richieste di tirocinio.</p><p>3. Il sistema crea una entry nell’ archivio delle richieste di tirocinio.</p><p>4. (Opzionale-Tirocinio Esterno) Il sistema notifica l’ azienda Esterna che la richiesta di tirocinio è stata archiviata.</p>|
|**Alternativa/e**|<p>**Azioni Sistema**</p><p>1. Il sistema riceve la richiesta di tirocinio.</p><p>2. La richiesta di tirocinio non soddisfa il formato oppure non è presente di tutte le informazioni necessarie per l’ approvazione oppure lo studente ha già una entry nell’archivio delle richieste di tirocinio.</p><p>3. Il sistema non accetta la richiesta di tirocinio ed invia un banner di errore allo studente.</p><p>4. (Opzionale-Tirocinio Esterno) Il sistema notifica l’ azienda Esterna che la richiesta di tirocinio non è stata archiviata.</p>|
|**Post-Condizioni**|<p>1. La cardinalità dell’archivio delle richieste di tirocinio deve essere +1 rispetto alla cardinalità prima della creazione della entry.</p><p>2. L’archivio delle richieste di tirocinio deve essere aggiornato con una nuova entry con informazioni uguali a quelle inserite nel form.</p>|


|**Nome**|Visualizza Richieste Tirocini|
| :- | :- |
|**Attore/i**|Amministratore|
|**Scopo**|Visualizzare il contenuto dell’ archivio delle richieste di tirocinio|
|**Pre-Condizioni**|(Non esistono pre-condizioni)|
|**Trigger**|Il gestore clicca su ‘visualizza richieste tirocini’ nella schermata principale|
|**Descrizione**|Consente al gestore di visualizzare le richieste di tirocinio archiviate nel sistema che sono in attesa di essere approvate|
|**Sequenza Eventi**|<p>**Azioni Sistema**</p><p>1. Il sistema recupera la lista di richieste di tirocinio dall’archivio</p><p>2. La lista ha cardinalità maggiore di 0</p><p>3. Visualizzazione a schermo della lista </p>|
|**Alternativa/e**|<p>**Azioni Sistema**</p><p>1. Il sistema recupera la lista di richieste di tirocinio dall’archivio</p><p>2. La lista ha cardinalità uguale a 0</p><p>3. Visualizzazione a schermo di un banner che dice ‘Al      momento non ci sono richieste di tirocinio’</p>|
|**Post-Condizioni**|(non esistono post-condizioni)|


|**Nome**|Accetta Richiesta Tirocinio|
| :- | :- |
|**Attore/i**|Amministratore|
|**Scopo**|Accettare le richieste di tirocinio valide |
|**Pre-Condizioni**|<p>1. Lo studente che ha fatto richiesta di tirocinio deve aver conseguito almeno 120 cfu.</p><p>2. La durata pattuita e presente all’ interno della richiesta di tirocinio deve essere almeno di 3 mesi.</p>|
|**Trigger**|Il gestore clicca su ‘accetta tirocinio’ su una richiesta di tirocinio|
|**Descrizione**|Consente al gestore di trasformare una richiesta di tirocinio valida in un tirocinio approvato|
|**Sequenza Eventi**||

|**Azioni Gestore**|**Azioni Sistema**|
| :- | :- |
||1\. Invia il prompt di conferma accettazione|
|2\. Clicca ‘si’ sul prompt di conferma accettazione|3\.Creazione entry all’ interno dell’ archivio dei tirocini|
||4\. Eliminazione della richiesta dall’archivio delle richieste di tirocinio|

|||
| :- | :- |
|**Alternativa/e**|(Non esistono alternative in quanto pre-condizioni soddisfatte)|
|**Post-Condizioni**|<p>1. La cardinalità dell’ archivio delle richieste di tirocinio deve essere -1 rispetto alla cardinalità prima dell’ accettazione.</p><p>2. L’archivio dei tirocini deve essere aggiornato con una nuova entry con informazioni uguali alla richiesta fatta.</p><p>3. Lo stato della entry creata nell’ archivio dei tirocini deve essere ‘approvato’.</p>|


|**Nome**|Visualizza Tirocini|
| :- | :- |
|**Attore/i**|Amministratore|
|**Scopo**|Visualizzare il contenuto dell’ archivio dei tirocini|
|**Pre-Condizioni**|(non esistono pre-condizioni)|
|**Trigger**|Il gestore clicca su ‘visualizza tirocini’ nella schermata principale|
|**Descrizione**|Consente al gestore di visualizzare i tirocini che sono stati approvati precedentemente|
|**Sequenza Eventi**|<p>**Azioni Sistema**</p><p>1. Il sistema recupera la lista di tirocini attivi dall’archivio.</p><p>2. La lista ha cardinalità maggiore di 0.</p><p>3. Visualizzazione a schermo della lista.</p>|
|**Alternativa/e**|<p>**Azioni Sistema**</p><p>1. Il sistema recupera la lista di tirocini attivi dall’archivio.</p><p>2. La lista ha cardinalità uguale a 0.</p><p>3. Visualizzazione a schermo di un banner che dice ‘Al      momento non ci sono tirocini attivi’.</p>|
|**Post-Condizioni**|(non esistono post-condizioni)|


|**Nome**|Filtro Durata, Filtro Anagrafica, Filtro Stato|
| :- | :- |
|**Attore/i**|Amministratore|
|**Scopo**|Visualizzare un sotto gruppo del contenuto dell’ archivio dei tirocini basato su alcuni filtri|
|**Pre-Condizioni**|<p>1. Le richiesta di filtro deve essere sintatticamente corretta e formattata.</p><p>2. Le richieste di filtro non devono contenere comandi SQL e quindi essere sanitizzate.</p>|
|**Trigger**|Il gestore clicca su ‘Applica filtro’ nella schermata della visualizzazione tirocini attivi|
|**Descrizione**|Consente al gestore di visualizzare i tirocini,che sono stati approvati precedentemente, filtrati secondo una politica di filtraggio|
|**Sequenza Eventi**|<p>**Azioni Sistema**</p><p>1. Il sistema recupera la lista di tirocini attivi dall’archivio e li filtra con il filtro selezionato.</p><p>2. La lista ha cardinalità maggiore di 0.</p><p>3. Visualizzazione a schermo della lista.</p>|
|**Alternativa/e**|<p>**Azioni Sistema**</p><p>1. Il sistema recupera la lista di tirocini attivi dall’archivio e li filtra con il filtro selezionato.</p><p>2. La lista ha cardinalità uguale a 0.</p><p>3. Visualizzazione a schermo di un banner che dice ‘Al momento non ci sono tirocini attivi con le caratteristiche selezionate’</p>|
|**Post-Condizioni**|<p>1. Ogni tirocinio attivo visualizzato deve soddisfare il filtro selezionato dal gestore.</p><p>2. La cardinalità della lista di tirocini attivi filtrati deve essere minore o uguale alla cardinalità della lista di tirocini attivi archiviati e non filtrati.</p>|

**2.3 Diagramma delle classi di progetto**

- ClassDiagram/ClassDiagram1.jpeg

**2.4 Diagramma di sequenza dei casi d’uso**

**2.4.1 Richiesta Tirocinio Interno/Esterno**

- SequenceDiagram/RichiestaTirocinio.jpeg

**2.4.2 Visualizza Richieste Tirocinio**

- SequenceDiagram/VisualizzaRichiesteTirocinio.jpeg

**2.4.3 Accetta Richiesta Tirocinio**

- SequenceDiagram/AccettaRichiestaTirocinio.jpeg

**2.4.4 Visualizza Tirocini**

- SequenceDiagram/VisualizzaTirocini.jpeg

**2.4.5 Filtro Durata, Filtro Anagrafica, Filtro Stato**

- SequenceDiagram/FiltroDurataAnagraficaStato1.jpeg
- SequenceDiagram/FiltroDurataAnagraficaStato2.jpeg
- SequenceDiagram/FiltroDurataAnagraficaStato3.jpeg

**2.5 Diagramma delle attività**

**2.5.1 Processo di inizio nuovo tirocinio interno**

- ActivityDiagram/ProcessoDiInizioNuovoTirocinioInterno.jpeg

**2.5.2 Processo di inizio nuovo tirocinio esterno**

- ActivityDiagram/ProcessoDiInizioNuovoTirocinioEsterno.jpeg

**2.6 Macchine di stato**

**2.6.1 Oggetto Tirocinio**

- MachineStateUML/OggettoTirocinio.jpeg

**2.7 Diagramma delle classi di Programma**

- ClassDiagram/ClassDiagram5.jpeg

**2.8 Dettagli architetturali**

L'architettura MVC, acronimo di Model-View-Controller, è un design architetturale ampiamente utilizzato nel campo dello sviluppo del software per organizzare il codice in modo modulare e separare le responsabilità tra le diverse componenti.

Nel mio caso ho suddiviso il programma in 3 package:

1) com.example.Model:
- Il package Model contiene la logica di business dell’ applicazione. Qua si trovano le classi che rappresentano gli oggetti fondamentali dell’ applicazione e la logica associata ad essi. Queste classi includono entità e l’oggetto di accesso ai dati (DAO).
1) com.example.Controller:
- Il package Controller contiene le classi che fungono da intermediari tra la parte di presentazione (Resources) e il Model.
1) com.example.Resources:
- Il package Resources (View) è responsabile di far visualizzare i dati in modo comprensibile all’utente e di catturare gli input utente per passarli al Controller. In questo package troviamo i file .fxml per la visualizzazione grafica con la libreria JavaFX.

**2.9 Diagramma dei package**

- PackageDiagram/PackageDiagram.jpeg

**2.10 Design pattern**

Nel mio caso ho scelto di implementare due Design Pattern:

1) DAO Design Pattern (Data Access Object): Questo Design Pattern ha l'obiettivo di fornire un’ interfaccia unificata per accedere ai dati indipendentente dal tipo di archivio sottostante che nel mio caso è un database. L’ interfaccia DAO è la classe SistemaDAO, la classe concreta è la classe SistemaDAOImpl e le entità sono: Studente, Tirocinio, Azienda e Tutor.
1) Singleton Design Pattern: Questo Design Pattern ha l’obiettivo di garantire che una classe abbia una sola istanza e fornisce un punto globale di accesso a tale istanza. La classe Singleton è la classe SistemaDAOImpl in quanto voglio garantire che l’accesso al database sia fatto attraverso una singola istanza per motivi di efficienza nel loading delle classi.

**2.11 Diagramma degli oggetti**

- ObjectDiagram/ObjectDiagram.jpeg

**2.12 Diagramma dei componenti**

- ComponentDiagram/ComponentDiagram.jpeg

**2.13 Diagramma di deployment**

- DeploymentDiagram/DeploymentDiagram.jpeg

**2.14 Vincoli OCL**

\1) I tirocini accettati devono contenere una durata minima di 3 mesi e devono essere stati richiesti da studenti che hanno almeno 120 crediti\.

{ context Tirocinio inv: (self.stato = ‘approvato’ or self.stato = ‘iniziato’ or self.stato = ‘terminato’)  implies (

`		`self.getDurata() >= 3 and

`		`self.studente.cfu >= 120 ) }

\2) Per ogni tirocinio deve esistere uno ed un solo studente 

{ context Tirocinio inv: self.id = self.studente.tirocinio.id }

\3) Ogni id di ogni tirocinio deve essere uguale alla matricola dello studente che lo ha attivato

{ context Tirocinio inv: self.id = self.studente.matricola }

\4) Ogni tutor non può contenere più di un tirocinio esterno con lo stesso id 

{ context tutor inv: self.tirocini->select( Tirocini : tir )->isUnique( tir ) }

\5) Ogni chiamata alla funzione getTirociniFilter() deve contenere come filtro in input uno tra le seguenti stringhe: “durata”, “anagrafica” e “stato”

{ context SistemaDAOImpl::getTirociniFilter( filtro, input )

pre: (filtro = ‘durata’ || filtro = ‘anagrafica’ || filtro = ‘stato’)  }

\6) Ogni esecuzione della funzione getTirociniFilter() e getTirocini() deve terminare ritornando una collezione che contiene solo tirocini e non richieste

{ context getTirociniFilter( filtro, input) 

post: result->forAll(Tirocinio : tir | (tir.stato = ‘approvato’ 

|| tir.stato = ‘iniziato’

|| tir.stato = ‘terminato’ ) }

{ context getTirocini() 

post: result->forAll(Tirocinio : tir | (tir.stato = ‘approvato’ 

|| tir.stato = ‘iniziato’

|| tir.stato = ‘terminato’ ) }

\7) Ogni esecuzione della funzione getRichieste() deve terminare ritornando una collezione che contiene solo richieste di tirocinio e non tirocini attivi

{ context getRichieste()

`	`post: result->forAll(Tirocinio : tir | tir.stato = ‘’ ) }

\8) Ogni chiamata alla funzione accettaRichiesta() deve contenere come IdRichiesta un Id esistente

{ context SistemaDAOImpl::accettaRichiesta( IdRichiesta ) 

`	`pre: self.tirocini->exists(Tirocinio : tir | tir.id = IdRichiesta) }

\9) Ogni esecuzione della funzione accettaRichiesta() deve iniziare con il tirocinio che ha l’ Id = IdRichiesta con stato non settato e deve terminare con lo stesso tirocinio che ha stato settato ad ‘approvato’

{ context SistemaDAOImpl::accettaRichiesta( IdRichiesta )

`	`pre: (self.tirocini->select(Tirocinio : tir | tir.id = IdRichiesta)).stato = ‘’

`	`post: (self.tirocini->select(Tirocinio : tir | tir.id = IdRichiesta)).stato = ‘approvato’ }

**2.15 Implementazione** 

Ho implementato la logica del programma e la connessione al Database nel programma che viene utilizzato dagli amministratori. Per quanto riguarda la connessione al DB ho utilizzato le API che Atlas DB di MongoDB mette a disposizione sfruttando un bucket AWS sul cloud.

Per completare il progetto si dovrebbe implementare la parte dell’ interfaccia grafica con la libreria JavaFX inserendo i file .fxml nel package com.example.resources e le classi java controller nel package com.example.controller. Ovviamente si dovrebbe creare una classe MainGUI che utilizza la classe Client già implementata per usufruire delle classi nel package com.example.model e che trasferisca i dati sull’ interfaccia grafica.

Per quanto riguarda invece la parte delle richieste di tirocinio dovremmo istanziare un ServerWeb Apache che si connette al database Atlas DB e permette ai client di compilare un form che contiene tutte le informazioni necessarie per iniziare un tirocinio tramite richieste POST.

Per controllare le funzionalità già implemetate ho creato un file MainCLI che permette di testare il Client da riga di comando.




