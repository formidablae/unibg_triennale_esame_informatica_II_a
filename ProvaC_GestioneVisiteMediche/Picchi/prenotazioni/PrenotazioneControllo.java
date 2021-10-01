package prenotazioni;

import java.time.LocalDate;

public class PrenotazioneControllo extends Prenotazione {
	private LocalDate dataPrevista;
	/**
	 * Costruttore che genera una prenotazione di controllo a partire da un id e vari altri campi.
	 * Non è necessario inserire una data, perchè essa verrà poi settata dal gestore.
	 * @param ID id della prenotazione
	 * @param cognome Cognome del paziente
	 * @param nome Nome del paziente
	 * @param descrizione descrizione della visita
	 * @param tipoVisita enum che descrive il tipo di visita (Malattia, Malattia Cronica, Vaccino)
	 * @param dataPrevista la data prevista/di scadenza
	 */
	public PrenotazioneControllo(String ID, String cognome, String nome, String descrizione, TipoVisita tipoVisita, LocalDate dataPrevista) {
		super(ID, cognome, nome, descrizione, tipoVisita);
		this.dataPrevista = dataPrevista;
	}
	/**
	 * Costruttore che genera una prenotazione di controllo senza un id ma dando comunque vari altri campi.
	 * Non è necessario inserire una data, perchè essa verrà poi settata dal gestore.
	 * @param ID id della prenotazione
	 * @param cognome Cognome del paziente
	 * @param nome Nome del paziente
	 * @param descrizione descrizione della visita
	 * @param tipoVisita enum che descrive il tipo di visita (Malattia, Malattia Cronica, Vaccino)
	 * @param dataPrevista la data prevista/di scadenza
	 */
	public PrenotazioneControllo(String cognome, String nome, String descrizione, TipoVisita tipoVisita, LocalDate dataPrevista) {
		super('S', cognome, nome, descrizione, tipoVisita);
		this.dataPrevista = dataPrevista;
	}
	
	public LocalDate getDataScadenza() { return dataPrevista; }
	public void setDataScadenza(LocalDate dataPrevista) { this.dataPrevista = dataPrevista; }
	@Override
	public double getCosto() {
		int numGiorni = 0;
		if(getDataVisita().isBefore(this.dataPrevista)) {
			numGiorni = getDataVisita().until(this.dataPrevista).getDays();
			numGiorni = numGiorni > 20 ? 20 : numGiorni;

		}
		return 200 + numGiorni*5;
	}
	@Override
	public String toString() {
		return "Prenotazione controllo " + super.toString() + "con scadenza " + this.dataPrevista.toString();
	}
}
