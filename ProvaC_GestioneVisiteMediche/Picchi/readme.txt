Si prega di vedere i vari javadoc all'interno del progetto per delle informazioni più mirate.
Il progetto è composto dai seguenti pacchetti e classi:

- prenotazioni
--- TipoVisita
------ Enum con i tre tipi di visita consentiti.	
--- Prenotazione
------ Classe astratta che rappresenta una visita/prenotazione generale.
--- PrenotazioneNormale
------ Sotto classe di Prenotazione che rappresenta una visita/prenotazione normale.
--- PrenotazioneControllo
------ Sotto classe di Prenotazione che rappresenta una visita/prenotazione controllo.
--- PrenotazioneUrgente
------ Sotto classe di Prenotazione che rappresenta una visita/prenotazione urgente.
--- Giorno
------ Contiene le prenotazioni di un determinato giorno. Al più 5 

- eccezioni
--- DatiIncorretti
------ Eccezione lanciata quando ci sono dei dati non corretti all'interno del file testuale.
--- GiornoPienoException
------ Eccezione lanciata quando ci troppe prenotazioni in un giorno.
--- DatiNonValidoException
------ Eccezione lanciata quando ci sono dei giorni non validi (domenica, lunedì)

- gestore
--- Gestore
------ Classe che gestisce le varie prenotazioni. Permette di aggiungerne, permette di visualizzarle, permette di caricarne da file
--- CommandLineTable
------ Utility open source per visualizzare dei dati sotto forma di tabella su console.
--- Main
------ classe di prova con il main.


FILE DI TESTO DA USARE
Va creato/usato un file chiamato visite.txt

I vari campi devono essere separati da un ';'
I campi in ordine devono essere:
* tipoPrenotazione - Il tipo di prenotazione (normale, controllo, urgente)
* ID - può essere nullo
* tipoVisita - Il tipo di visita (Vaccino, Malattia Cronica, Malattia)
* cognome - il cognome del paziente
* nome - il nome del paziente
* descrizione - descrizione del motivo della visita
* eventuali altri dati


NOTA:
fa uso seppur brevemente, della libreria prog-4