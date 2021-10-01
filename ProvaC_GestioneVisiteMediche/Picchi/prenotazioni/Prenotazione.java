package prenotazioni;

import java.time.LocalDate;

public abstract class Prenotazione implements Comparable<Prenotazione>{
	private String ID;
	private static int counter = 0;
	private String cognomePaziente;
	private String nomePaziente;
	private String descrizione;
	private LocalDate dataVisita;
	private TipoVisita tipoVisita;
	
	private Prenotazione(String cognome, String nome, String descrizione, TipoVisita tipoVisita) {
		this.cognomePaziente = cognome;
		this.nomePaziente = nome;
		this.descrizione = descrizione;
		this.tipoVisita = tipoVisita;
		this.counter++;
	}
	public Prenotazione(String ID, String cognome, String nome, String descrizione, TipoVisita tipoVisita) {
		this(cognome, nome, descrizione, tipoVisita);
		this.ID = ID;
		if(Integer.parseInt(ID.substring(1, ID.length()))>counter)
			counter++;
		this.dataVisita = dataVisita;
	}
	
	public Prenotazione(char primaLettera, String cognome, String nome, String descrizione, TipoVisita tipoVisita) {
		this(cognome, nome, descrizione, tipoVisita);
		this.ID = String.valueOf(primaLettera) + counter;
		this.dataVisita = dataVisita;
	}
	
	public LocalDate getDataVisita() { return dataVisita; }
	public String getID() {	return ID;	}
	public void setID(String iD) {	ID = iD;	}
	public String getPaziente() {	return this.cognomePaziente + " " + this.nomePaziente;	}
	public void setPaziente(String cognome,String nome) { this.cognomePaziente = cognome; this.nomePaziente = nome;	}
	public String getDescrizione() { return descrizione; }
	public void setDescrizione(String descrizione) { this.descrizione = descrizione; }
	public TipoVisita getTipoVisita() { return tipoVisita;	}
	public void setTipoVisita(TipoVisita tipoVisita) {	this.tipoVisita = tipoVisita;	}
	public void setDataVisita(LocalDate dataVisita) {	this.dataVisita = dataVisita;	}
	
	/**
	 * I vari costi sono calcolati in base a vari fattori che differiscono per tipo di visita.
	 * @return il costo della visita
	 */
	public abstract double getCosto();
	
	
	/**
	 * Le prenotazioni vengono comparate di default prima per la data, e poi in secondo luogo (in caso di date uguali) per paziente.
	 */
	@Override
	public int compareTo(Prenotazione o) {
		if(dataVisita == null || o.dataVisita == null)
			return 1;
		else if (this.dataVisita.isEqual(o.dataVisita))
		{
			return this.getPaziente().compareTo(o.getPaziente()); 
		}
		return this.dataVisita.compareTo(o.dataVisita);
	}
	@Override
	public String toString() {
		return "ID: "+ ID + " del " + dataVisita.toString() + " di " + this.getPaziente() + "con descrizione: " + descrizione + " tipo: " + tipoVisita.toString();
	}
}
