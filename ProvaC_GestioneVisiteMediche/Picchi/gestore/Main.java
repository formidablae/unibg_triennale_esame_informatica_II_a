package gestore;

import java.time.LocalDate;
import java.time.Month;

import eccezioni.DatiIncorretti;
import eccezioni.GiornoNonValidoException;
import prenotazioni.PrenotazioneControllo;
import prenotazioni.PrenotazioneNormale;
import prenotazioni.PrenotazioneUrgente;
import prenotazioni.TipoVisita;

public class Main {
	public static void main(String[] args) throws GiornoNonValidoException{
		// TODO Auto-generated method stub
		Gestore gestore;
		gestore = new Gestore();
		//lettura
		try {
			gestore.letturaDaFile();
		} catch (DatiIncorretti e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ulteriore inserimento
		gestore.addPrenotazione(new PrenotazioneNormale("Fumi", "Maria", "Forte dolore alla spalla sinistra", TipoVisita.MALATTIA));
		gestore.addPrenotazione(new PrenotazioneNormale("Lai","Osvaldo", "Vaccino influenzale", TipoVisita.VACCINO));
		gestore.addPrenotazione(new PrenotazioneUrgente("Totti","Francesco", "Caviglia slogata", TipoVisita.MALATTIA));
		gestore.addPrenotazione(new PrenotazioneUrgente("Renzetti","Renzo", "Ferita arma da fuoco", TipoVisita.MALATTIA));
		gestore.addPrenotazione(new PrenotazioneControllo("Totti","Francesco", "Controllo situazione caviglia", TipoVisita.MALATTIA, LocalDate.of(2019, Month.APRIL, 14)));
		//stampa ordine cronologico
		System.out.println("STAMPA PRENOTAZIONI IN ORDINE CRONOLOGICO");
		gestore.stampaVisite();
		//stampa visite di oggi
		System.out.println("STAMPA PRENOTAZIONI ODIERNE IN ORDINE CRESCENTE DI COSTO");
		gestore.stampaVisiteOdierne();
	}

}
