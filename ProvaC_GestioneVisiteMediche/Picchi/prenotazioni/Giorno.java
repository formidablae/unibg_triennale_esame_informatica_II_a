package prenotazioni;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.TreeSet;

import eccezioni.GiornoNonValidoException;
import eccezioni.GiornoPienoException;

public class Giorno implements Comparable<Giorno> {
	private TreeSet<Prenotazione> visite;
	private LocalDate giorno;
	public Giorno(LocalDate giorno) throws GiornoNonValidoException{
		if (giorno.getDayOfWeek().equals(DayOfWeek.MONDAY) || giorno.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			throw new GiornoNonValidoException(giorno);
		}
		this.giorno = giorno;
		this.visite = new TreeSet<Prenotazione>();
	}
	/**
	 * Aggiunge una prenotazione solo se il giorno non è pieno.
	 * @param prenotazione la prenotazione
	 * @throws GiornoPienoException indica che il giorno contenteneva già 5 visite.
	 */
	public void add(Prenotazione prenotazione) throws GiornoPienoException {
		if(visite.size() < 5) {
			visite.add(prenotazione);
		}
		else {
			throw new GiornoPienoException(this.giorno);
		}
	}
	public TreeSet<Prenotazione> getPrenotazioni() {
		return visite;
	}
	public LocalDate getGiorno() { return giorno; }
	public int getPrenotazioniCount() {
		return this.visite.size();
	}
	public boolean IsDayFull() {
		if (this.visite.size()>4) {
			return true;
		}
		return false;
	}
	/**
	 * I giorni vengono comparati su base della data.
	 */
	@Override
	public int compareTo(Giorno o) {
		// TODO Auto-generated method stub
		return this.giorno.compareTo(o.giorno);
	}
	public static LocalDate getFirstValidDate(LocalDate now) {
		while (now.getDayOfWeek().equals(DayOfWeek.SUNDAY) || now.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
			now = now.plusDays(1);
		}
		return now;
	}
}
