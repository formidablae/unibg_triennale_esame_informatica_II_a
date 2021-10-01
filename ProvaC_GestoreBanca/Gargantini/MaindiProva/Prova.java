package MaindiProva;

import prog.utili.Data;
import ContoCorrente.Banca;
import OperazioniBancarie.Bonifico;
import OperazioniBancarie.OperazioneBancaria;
import OperazioniBancarie.Prelievo;
import OperazioniBancarie.Versamento;

// TODO: Auto-generated Javadoc
/**
 * The Class Prova.
 */
public class Prova {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Banca banca = new Banca();
		banca.creaConto("Utente 1");
		banca.creaConto("Utente 2");
		banca.creaConto("Utente 3");
		banca.creaConto("Utente 4"); // creo 4 conti

		banca.leggieCaricadaFile(); // gli faccio caricare i conti da file

		// stampo la lista dei conti attualmente presenti
		banca.stampaContiperOrdinediSaldo();

		// creo qualche operazione in modo da variare il saldo di ogni conto
		OperazioneBancaria prelievo1su0 = new Prelievo(new Data(10, 10, 2010),
				0, 100, "bancomat");
		OperazioneBancaria prelievo2su0 = new Prelievo(new Data(01, 03, 2012),
				0, 200, "sportello");
		OperazioneBancaria versamento1su1 = new Versamento(new Data(18, 06,
				2009), 1, 560, 2);
		// OperazioneBancaria versamento1su1 = new Versamento(new
		// Data(18,06,2009), 90, 560, 2); <- test eccezione sul numero del conto

		OperazioneBancaria versamento1su0 = new Versamento(new Data(15, 12,
				2011), 0, 1000, 0);
		OperazioneBancaria bonifico_da0a1 = new Bonifico(
				new Data(18, 07, 2013), 0, "1", new Data(19, 07, 2013), 500); // fatta
																				// il
																				// giorno
																				// dopo
																				// (1
																				// euro
																				// di
																				// costo)
		OperazioneBancaria versamento1su3 = new Versamento(new Data(01, 01,
				2001), 3, 450, 2);
		// OperazioneBancaria bonifico1_2conEccezione = new Bonifico(new
		// Data(10,11,1872),0,"1", new Data(01,01,2011), 500); // test eccezione
		// sulla data

		// eseguo le operazioni sopra create
		banca.eseguiOperazione(versamento1su0); // versa 1000 euro
		banca.eseguiOperazione(prelievo1su0); // toglie 100 euro dal conto 0 (+1
												// di commissione)
		banca.eseguiOperazione(prelievo2su0); // toglie 200 euro dal conto 0 (+1
												// di commissione)
		banca.eseguiOperazione(versamento1su1);
		banca.eseguiOperazione(bonifico_da0a1); // manda 500 euro dal conto 1 al
												// conto 2
		banca.eseguiOperazione(versamento1su3); // carica 450 euro sul conto 3

		// faccio la stampa per ordine di saldo
		banca.stampaContiperOrdinediSaldo();

		// stampo i movimenti del conto 0 in ordine di data
		banca.stampaMovimentiperData(0, 3);

		/*
		 * //banca.eseguiOperazione(bonifico1_2conEccezione); //
		 */
	}
}
