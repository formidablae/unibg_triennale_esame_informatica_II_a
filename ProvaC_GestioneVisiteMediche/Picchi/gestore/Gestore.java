package gestore;

import java.io.File;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import eccezioni.DatiIncorretti;
import eccezioni.GiornoNonValidoException;
import eccezioni.GiornoPienoException;
import prenotazioni.Giorno;
import prenotazioni.Prenotazione;
import prenotazioni.PrenotazioneControllo;
import prenotazioni.PrenotazioneNormale;
import prenotazioni.PrenotazioneUrgente;
import prenotazioni.TipoVisita;
import prog.io.FileInputManager;

public class Gestore {
	
	private TreeSet<Giorno> listaGiorni;
	
	public Gestore() throws GiornoNonValidoException{
		listaGiorni = new TreeSet<Giorno>();
		listaGiorni.add(new Giorno(Giorno.getFirstValidDate(LocalDate.now())));
	}
	
	/**
	 * Aggiunge una prenotazione al sistema nel primo giorno disponibile.
	 * Ogni giorno può avere al massimo 5 visite.
	 * Lo studio chiude il lunedì e la domenica.
	 * @param p la prenotazione
	 */
	public LocalDate addPrenotazione(Prenotazione p) {
		for(Giorno g : listaGiorni) {
			if(g.getGiorno().isAfter(LocalDate.now().minusDays(1))) {
				if (!g.IsDayFull())
					try {
						p.setDataVisita(g.getGiorno());
						g.add(p);
						return g.getGiorno();
					} catch (GiornoPienoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		LocalDate newDay = listaGiorni.last().getGiorno().plusDays(1);
		while (newDay.getDayOfWeek().equals(DayOfWeek.MONDAY) || newDay.getDayOfWeek().equals(DayOfWeek.SUNDAY))
		{
			newDay = newDay.plusDays(1);
		}
		try {
			listaGiorni.add(new Giorno(newDay));
			try {
				p.setDataVisita(newDay);
				listaGiorni.last().add(p);
				
			} catch (GiornoPienoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		} catch (GiornoNonValidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newDay;
	}
	
	/**
	 * Stampa tutte le visite in ordine di data, ed a parità di data le ordina per paziente.
	 */
	public void stampaVisite() {
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);//if false (default) then no vertical lines are shown
        st.setHeaders("ID", "Data Visita", "Tipo prenotazione", "Tipo visita", "Paziente", "Descrizione", "Costo", "Data scadenza");//optional - if not used then there will be no header and horizontal lines
        for(Giorno g : listaGiorni) {
        	for (Prenotazione p : g.getPrenotazioni()) {
        		if (p instanceof PrenotazioneControllo) {
        	        st.addRow(p.getID(), p.getDataVisita().toString(), p.getTipoVisita().toString(), "Controllo", p.getPaziente(), p.getDescrizione(), String.valueOf(p.getCosto()), ((PrenotazioneControllo) p).getDataScadenza().toString());
        		} else if (p instanceof PrenotazioneNormale) {
        	        st.addRow(p.getID(), p.getDataVisita().toString(), p.getTipoVisita().toString(), "Normale", p.getPaziente(), p.getDescrizione(), String.valueOf(p.getCosto()), "NA");
        		} else {
        	        st.addRow(p.getID(), p.getDataVisita().toString(), p.getTipoVisita().toString(), "Urgente", p.getPaziente(), p.getDescrizione(), String.valueOf(p.getCosto()), "NA");
        		}
        	}
        }
        st.print();
	}
	
	/**
	 * Stampa tutte le visite di oggi in ordine di costo.
	 * Se non vi sono visite per oggi, fornisce un messaggio che indica la loro assenza.
	 */
	public void stampaVisiteOdierne() {
		List<Prenotazione> listaPrenotazioni = new ArrayList<Prenotazione>();
		for(Giorno g : listaGiorni) {
			if(g.getGiorno().equals(LocalDate.now())) {
				for (Prenotazione p :g.getPrenotazioni())
					listaPrenotazioni.add(p);
				Collections.sort(listaPrenotazioni, new CostComparator());
		        CommandLineTable st = new CommandLineTable();
		        st.setShowVerticalLines(true);//if false (default) then no vertical lines are shown
		        st.setHeaders("ID", "Data Visita", "Tipo prenotazione", "Tipo visita", "Paziente", "Descrizione", "Costo", "Data scadenza");//optional - if not used then there will be no header and horizontal lines
				for(Prenotazione p : listaPrenotazioni) {
	        		if (p instanceof PrenotazioneControllo) {
	        	        st.addRow(p.getID(), p.getDataVisita().toString(), p.getTipoVisita().toString(), "Controllo", p.getPaziente(), p.getDescrizione(), String.valueOf(p.getCosto()), ((PrenotazioneControllo) p).getDataScadenza().toString());
	        		} else if (p instanceof PrenotazioneNormale) {
	        	        st.addRow(p.getID(), p.getDataVisita().toString(), p.getTipoVisita().toString(), "Normale", p.getPaziente(), p.getDescrizione(), String.valueOf(p.getCosto()), "NA");
	        		} else {
	        	        st.addRow(p.getID(), p.getDataVisita().toString(), p.getTipoVisita().toString(), "Urgente", p.getPaziente(), p.getDescrizione(), String.valueOf(p.getCosto()), "NA");
	        		}
				}
				st.print();
				return;
			}
		}
		System.out.println("Nessuna visita prevista per oggi");
	}
	/**
	 * Legge dal file visite.txt un elenco di visite.
	 * I vari campi devono essere separati da un ';'
	 * I campi in ordine devono essere: <br> <ul>
	 * <li>tipoPrenotazione - Il tipo di prenotazione (normale, controllo, urgente)</li>
	 * <li>ID - può essere nullo</li>
	 * <li>tipoVisita - Il tipo di visita (Vaccino, Malattia Cronica, Malattia)</li>
	 * <li>cognome - il cognome del paziente</li>
	 * <li>nome - il nome del paziente</li>
	 * <li>descrizione - descrizione del motivo della visita</li>
	 * <li>eventuali altri dati</li>
	 * <ul>
	 */
	public void letturaDaFile() throws DatiIncorretti {
		
		FileInputManager file = new FileInputManager(System.getProperty("user.dir")+File.separator+"visite.txt");
		
		for(;;) {
			
			String line = file.readLine();
			if(line == null) break;
			
			String[] dati = line.split(";");
			
			// campi comuni a tutte le classi
			String tipoPrenotazione = dati[0];
			String ID = dati[1];
			String enumVisita = dati[2];
			TipoVisita tVisita;
			if(enumVisita.equals("Vaccino"))
				tVisita = TipoVisita.VACCINO;
			else if (enumVisita.equals("Malattia Cronica"))
				tVisita = TipoVisita.MALATTIA_CRONICA;
			else if (enumVisita.equals("Malattia"))
				tVisita = TipoVisita.MALATTIA;
			else
				throw new DatiIncorretti();
			String cognome = dati[3];
			String nome = dati[4];
			String descrizione = dati[5];
			
			if(tipoPrenotazione.equals("normale")) {	// Se è una visita normale
		
				if(ID.equals("")) {	// Se l'ID è vuoto allora viene costruito in automatico
					addPrenotazione(new PrenotazioneNormale(cognome,nome, descrizione, tVisita));
				} else {
					addPrenotazione(new PrenotazioneNormale(ID, cognome,nome, descrizione, tVisita));
				}
			}
			
			if(tipoPrenotazione.equals("urgente")) {	// Se è una gara di due gruppi
								
				if(ID.equals("")) {	// Se l'ID è vuoto allora viene costruito in automatico
					addPrenotazione(new PrenotazioneUrgente(cognome, nome, descrizione, tVisita));
				} else {
					addPrenotazione(new PrenotazioneUrgente(ID, cognome, nome, descrizione, tVisita));
				}
			}
			
			if(tipoPrenotazione.equals("controllo")) {	// Se è una gara di due gruppi
				LocalDate dataScadenza = LocalDate.parse(dati[6]);
				if(ID.equals("")) {	// Se l'ID è vuoto allora viene costruito in automatico
					addPrenotazione(new PrenotazioneControllo(cognome, nome, descrizione, tVisita,dataScadenza));
				} else {
					addPrenotazione(new PrenotazioneControllo(ID, cognome, nome, descrizione, tVisita,dataScadenza));
				}
			}			
		}
	}
	/**
	 * Semplice comparatore per comparare le prenotazioni per costo.
	 *
	 */
	private class CostComparator implements Comparator<Prenotazione> {
		@Override
		public int compare(Prenotazione o1, Prenotazione o2) {
			// TODO Auto-generated method stub
			return (int)(o1.getCosto() - o2.getCosto());
		}
		
	}
}
