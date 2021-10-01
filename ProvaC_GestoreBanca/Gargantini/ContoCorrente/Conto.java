package ContoCorrente;

import prog.utili.SequenzaOrdinata;
import Eccezioni.NomeIntestatarioNonValidoException;
import OperazioniBancarie.OperazioneBancaria;

// TODO: Auto-generated Javadoc

/**
 * reppresenta un singolo conto, con il suo numero, il suo intestartrio �
 * comparable rispetto il saldo.
 */
class Conto implements Comparable<Conto> {

	/** Il contatore dei conti correnti. */
	private static int contiCorrenti = 0; // variabile usata per attribuire al
											// conto un numero univoco

	/** Il numero conto. */
	int numeroConto;

	/** L'intestatario. */
	private String intestatario;

	/** The saldo. */
	float saldo;

	/** The operazioni. */
	SequenzaOrdinata<OperazioneBancaria> operazioni; // lista con operazioni

	/**
	 * Crea un nuovo conto corrente, genera in automatico saldo e numero del
	 * conto.
	 * 
	 * @param intestatario
	 *            nome dell'intestatario
	 */
	Conto(String intestatario) {
		this(++contiCorrenti, intestatario, 0);
	}

	/**
	 * Costruttore (nel caso in cui i conti vengano caricati dal file) con un
	 * numero di conto gi� stabilito.
	 * 
	 * @param nConto
	 *            numero del conto
	 * @param intestatario
	 *            intestatario del conto
	 * @param saldo
	 *            saldo del conto
	 */
	Conto(int nConto, String intestatario, float saldo) {
		if (intestatario.length() == 0)
			throw new NomeIntestatarioNonValidoException(
					"Intestatario senza nome");
		this.numeroConto = nConto;
		this.intestatario = intestatario;
		this.saldo = saldo;
		operazioni = new SequenzaOrdinata<OperazioneBancaria>();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conto Corrente #" + numeroConto + "\n" + "Intestatario: "
				+ intestatario + "\n" + "Saldo: " + saldo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Conto c2) {
		// assumo che al pi� differiscano per un centesimo
		return Math.round((this.saldo - c2.saldo) * 100);
	}

}
