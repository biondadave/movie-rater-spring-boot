# Movie Rater

Movie Rater è un'applicazione web che mostra ai visitatori 2 film scelti in modo casuale e permette loro di scegliere 
il preferito tra i 2. Ogni volta che un utente vota uno dei 2 film l'applicazione aggiorna il contatore dei voti per il singolo film e propone altri 2 film sempre scelti in maniera casuale nel database.

## Dettagli Tecnici

- Progetto Maven
- Spring Boot
- JDK 1.8
- Spring MVC
- HTML templates gestiti via [Mustache Templates](https://mustache.github.io/)
- [MaterializeCSS](https://materializecss.com/) per il frontend 
- database h2 creato e popolato automaticamente all'avvio a partire dai file in `src/main/resources/db/migration`

## Avvio dell'applicazione

Per lanciare l'applicazione

```java
// ./mvnw spring-boot:run
``` 

Aprire il browser all'indirizzo 
```
http://localhost:8080
```

Per accedere al database h2 (creato automaticamente all'avvio dell'app) accedere all'url: 
```
http://localhost:8080/h2-console
``` 

Credenziali di accesso al db. 
- url: `jdbc:h2:file:~/movierater` 
- username: `sa` 
- password: lasciare vuoto

## Consegna del codice

Clonare questo repository e committare i singoli task. Al termine della sessione di lavoro consegnare il codice al referente Intesys:
1. inviando al referente Intesys il progetto un link al file .zip contenente la cartella .git (evitare zip via email, vengono rifiutati)
2. oppure creando un repository privato su github e condividendolo con l'account github del referente

## Task

Si richiede quindi di implementare le seguenti funzionalità:

1. Implementare il metodo `MovieService#getMovieCount` per ritornare al frontend il numero totale di film del database
2. Implementare il metodo `MovieService#get2RandomMovies` per prendere 2 film random dal database
3. Implementare la logica di raccolta dei voti (MovieController#submitVote) per il singolo film. (HINT. Creare un nuovo file .sql per aggiungere le colonne o tabelle necessarie al database)
4. Scrivere un algoritmo che stampi i 3 attori con la carriera più lunga. La carriera si misura calcolando gli anni trascorsi tra il primo e l'ultimo film di un attore. Implementare la logica nella classe AppStartup, loggando con il logger gli attori trovati.
5. Mostrare in home page il numero totale di voti raccolti per tutti i film
6. Creare la tabella actor e actor_movie e scrivere una procedura di migrazione in java per migrare i dati dei singoli attori dalla tabella movie alla tabella actor, mettendole in relazione tramite la tabella actor_movie
7. Creare una pagina di dettaglio per il singolo attore. La pagina deve mostrare il nome dell’attore e la lista dei film in cui ha recitato. Dalla pagina di dettaglio del film per ogni attore della lista, deve essere possibile navigare verso questa pagina di dettaglio.
8. Se un attore è tra i primi 10 o 100 più votati, mostrare rispettivamente un badge TOP10 o TOP100 nella pagina di dettaglio implementata nel punto precedente. I voti del singolo attore si calcolano sommando i voti presi dai film in cui l'attore ha recitato.





Bonus:

Usare hibernate e spring data jpa invece di jdbc template


## Elementi considerati per la valutazione

- correttezza della soluzione
- numero di task completati
- performance
- pulizia del codice
- versionamento dei sorgenti
- tempo di svolgimento

## Note
Per rendere il processo di selezione equo per tutti, si prega di non condividere con nessuno questo assignment o la soluzione proposta.



