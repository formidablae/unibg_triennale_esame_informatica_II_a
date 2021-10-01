package prenotazioni;

import java.time.DayOfWeek;

public class PrenotazioneUrgente extends Prenotazione {
	
	/**
	 * Costruttore che genera una prenotazione urgente a partire da un id e vari altri campi.
	 * Non è necessario inserire una data, perchè essa verrà poi settata dal gestore.
	 * @param ID id della prenotazione
	 * @param cognome Cognome del paziente
	 * @param nome Nome del paziente
	 * @param descrizione descrizione della visita
	 * @param tipoVisita enum che descrive il tipo di visita (Malattia, Malattia Cronica, Vaccino)
	 */
	public PrenotazioneUrgente(String ID, String cognome, String nome, String descrizione, TipoVisita tipoVisita) {
		super(ID, cognome, nome, descrizione, tipoVisita);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Costruttore che genera una prenotazione urgente senza un id ma dando comunque vari altri campi.
	 * Non è necessario inserire una data, perchè essa verrà poi settata dal gestore.
	 * @param ID id della prenotazione
	 * @param cognome Cognome del paziente
	 * @param nome Nome del paziente
	 * @param descrizione descrizione della visita
	 * @param tipoVisita enum che descrive il tipo di visita (Malattia, Malattia Cronica, Vaccino)
	 */
	public PrenotazioneUrgente(String cognome, String nome , String descrizione, TipoVisita tipoVisita) {
		super('U', cognome, nome, descrizione, tipoVisita);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getCosto() {
		if(super.getDataVisita()!= null && super.getDataVisita().getDayOfWeek().equals(DayOfWeek.FRIDAY))
			return 300;
		return 200;
	}
	
	@Override
	public String toString() {
		return "Prenotazione urgente " + super.toString();
	}
}
