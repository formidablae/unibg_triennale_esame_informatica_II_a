//package studioLegale;
//
//import prog.utili.Data;
//
//public class Cliente {//aggiungo controlli
//	private String nome;
//	private String cognome;
//	private Data nascita;
//	private String residenza;
//	
//	public Cliente(String nome, String cognome, Data nascita, String residenza) {
//		if(nome == null || nome.length() < 1 || cognome == null || cognome.length() < 0  || nascita == null 
//				|| (new Data()).compareTo(nascita) > 0 || residenza == null || residenza.length() < 0)
//			throw new IllegalArgumentException("Uno o pi� paramentri inseriti non sono corretti");
//		this.nome = nome;
//		this.cognome = cognome;
//		this.nascita = nascita;
//		this.residenza = residenza;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getCognome() {
//		return cognome;
//	}
//
//	public void setCognome(String cognome) {
//		this.cognome = cognome;
//	}
//
//	public Data getNascita() {
//		return nascita;
//	}
//
//	public void setNascita(Data nascita) {
//		this.nascita = nascita;
//	}
//
//	public String getResidenza() {
//		return residenza;
//	}
//
//	public void setResidenza(String residenza) {
//		this.residenza = residenza;
//	}
//
//	@Override
//	public String toString() {
//		return nome+" "+cognome;
//	}	
//	
//		
//}
