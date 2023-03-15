## Lista funzioni app
- Creazione profilo utente
- Modifica delle eventuali informazioni profilo(nome, cognome, bio, elenco interessi ecc.) e credenziali
- Possibilità di eliminare il profilo
- Possibilità di creare una lista di amici con gli altri utenti(con possibilità di confermare o rifiutare l’amicizia)
- Bacheca posts profilo utente. Ogni post è relativo all’ evento partecipato(max 4 foto per post e una descrizione)
- Possibilità di eliminare il post
- Bacheca eventi organizzati dall’utente
- Creazione evento con relative info(orario, luogo con mappa, foto, num partecipanti, aperto/chiuso solo ad amici, descrizione, categoria)
- Possibilità di eliminare l’evento
- Possibilità di cambiare le info dell’evento con notifica in tempo reale a tutti gli iscritti
- Possibilità di commentare sotto ad un evento, solo se si è partecipato e valutarlo con un like o dislike
- Feed degli eventi organizzati da amici o di eventi vicini (filtrati anche in base agli interessi personali) con eventuale mappa
- Feed principale di posts degli utenti amici o sconosciuti nelle vicinanze.
- Ricerca di utenti tramite username
- Ricerca di eventi per nome


### Note 
- Main Activity lancia la splashscreen e la fase di login/signup se l'utente non è loggato. La splashscreen dovrà chiudere una volta che l'app avrà caricato tutti i dati.
- Per il logout utilizzare Intent con il flag FLAG_ACTIVITY_CLEAR_TASK (https://medium.com/swlh/truly-understand-tasks-and-back-stack-intent-flags-of-activity-2a137c401eca)
