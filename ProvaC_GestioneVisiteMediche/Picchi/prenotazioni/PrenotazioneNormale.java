package prenotazioni;

public class PrenotazioneNormale extends Prenotazione {
	/**
	 * Costruttore che genera una prenotazione normale a partire da un id e vari altri campi.
	 * Non è necessario inserire una data, perchè essa verrà poi settata dal gestore.
	 * @param ID id della prenotazione
	 * @param cognome Cognome del paziente
	 * @param nome Nome del paziente
	 * @param descrizione descrizione della visita
	 * @param tipoVisita enum che descrive il tipo di visita (Malattia, Malattia Cronica, Vaccino)
	 */
	public PrenotazioneNormale(String ID, String cognome, String nome, String descrizione, TipoVisita tipoVisita) {
		super(ID, cognome,nome, descrizione, tipoVisita);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Costruttore che genera una prenotazione normale senza un id ma dando comunque vari altri campi.
	 * Non è necessario inserire una data, perchè essa verrà poi settata dal gestore.
	 * @param ID id della prenotazione
	 * @param cognome Cognome del paziente
	 * @param nome Nome del paziente
	 * @param descrizione descrizione della visita
	 * @param tipoVisita enum che descrive il tipo di visita (Malattia, Malattia Cronica, Vaccino)
	 */
	public PrenotazioneNormale(String cognome, String nome, String descrizione, TipoVisita tipoVisita) {
		super('V', cognome, nome, descrizione, tipoVisita);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getCosto() {
		return 100;
	}
	
	@Override
	public String toString() {
		return "Prenotazione normale " + super.toString();
	}
}
