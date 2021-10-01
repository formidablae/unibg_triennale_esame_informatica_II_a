//package pratiche;
//
//import eccezioni.ClienteException;
//import eccezioni.DescrizioneException;
//import eccezioni.OverflowException;
//import eccezioni.UdienzaException;
//import prog.utili.Data;
//import studioLegale.Cliente;
//
//public abstract class Pratica implements Comparable<Pratica>{
//	
//	private static final int PRIORITA_IN_CORSO = 1000;
//	private static long newId = 0;
//	private long id;
//	private Cliente richiedente;	
//	private String descrizione;
//	private Data udienza;
//	private Stato stato;
//	protected int ore;
//	
//	/**
//	 * Nel momento in cui una pratica viene aperta le ore di lavoro sono 0, e la pratica � IN_CORSO, non avrebbe senso
//	 * inserire una pratica CHIUSA o ARCHIVIATA
//	 */
//	public Pratica(Cliente richiedente, String descrizione, Data udienza) {
//		this(richiedente,descrizione, udienza, Stato.IN_CORSO, 0);
//	}
//	
//	/**
//	 * Usato da me per testare il programma, il costruttore pi� sensato sarebbe quello sopra 	
//	 */
//	public Pratica(Cliente richiedente, String descrizione, Data udienza, Stato stato, int ore) {
//		if(newId < 0)
//			throw new OverflowException("L'id � andato in overflow comunicarlo all'amministratore");
//		if(richiedente == null)
//			throw new ClienteException("Non � possibile creare pratiche senza un richiedente");
//		if(descrizione == null || descrizione.length() < 1)
//			throw new DescrizioneException("La descrizione non pu� essere vuota");
//		id = newId++;
//		this.richiedente = richiedente;
//		this.descrizione = descrizione;
//		this.udienza = udienza;
//		this.stato = stato;
//		this.ore = ore;
//	}
//	
//	public abstract int getCosto();
//	
//	/**
//	 * Qual'ora una pratica ARCHIVIATA o CHIUSA abbia una udienza passatta d'ho valore 1000, perch� il fatto che
//	 * sia non IN_CORSO ha priorit� su una udienza passata 
//	 * @return Priorit� della pratica
//	 */
//	public int getPriorita(){
//		Data oggi = new Data();
//		if(!stato.equals(Stato.IN_CORSO))
//			return PRIORITA_IN_CORSO;
//		if(oggi.compareTo(udienza) > 0)
//			return Integer.MAX_VALUE;
//		return oggi.quantoManca(udienza);
//	}
//	
//	public boolean equals(Pratica p){
//		return id == p.id;
//	}
//	
//	public int compareTo(Pratica p){
//		return getPriorita()-p.getPriorita();
//	}
//	
//	@Override
//	public String toString() {
//		return "Id:" + id + "\n Richiedente:" + richiedente
//				+ "\n Descrizione:" + descrizione + "\n Prossima udienza:" + udienza
//				+ "\n Stato:" + stato + "\n Ore:" + ore;
//	}
//	
//	public Stato getStato(){
//		return stato;
//	}	
//	
//	/** 	 
//	 * Serve nella lettura da file in modo da mantenere l'id col quale la pratica � stata salvata
//	 * @param newId Valore a cui settare il campo newId.
//	 */
//	public static void setId(long newId){
//		if(newId < 0)
//			throw new OverflowException("L'id non pu� essere negativo");
//		Pratica.newId = newId;
//	}
//
//}
