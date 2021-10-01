package OperazioniBancarie;

import prog.utili.Data;
import Eccezioni.DatoNonValidoException;

/**
 * rappresenta le operazioni bancarie.
 */
public abstract class OperazioneBancaria implements
		Comparable<OperazioneBancaria> {

	/** The data operazione. */
	private Data dataOperazione;

	/** The numero conto. */
	private int numeroConto;

	/** The importo. */
	protected float importo;

	/**
	 * Instantiates a new operazione bancaria.
	 * 
	 * @param dataOperazione
	 *            the data operazione
	 * @param numeroConto
	 *            the numero conto
	 * @param importo
	 *            the importo
	 */
	OperazioneBancaria(Data dataOperazione, int numeroConto, float importo) {
		if (numeroConto < 0 || importo < 0)
			throw new DatoNonValidoException(
					"Il numero del conto o l'importo specificato non sono validi");

		this.dataOperazione = dataOperazione;
		this.numeroConto = numeroConto;
		this.importo = importo;
	}

	/**
	 * Stampa il numero del conto corrente che invoca il metodo.
	 * 
	 * @return numero del conto
	 */
	public int getCC() {
		return numeroConto;
	}

	/**
	 * Stampa il saldo del conto corrente che invoca il metodo.
	 * 
	 * @return importo presente nel conto
	 */
	public float getImporto() {
		return importo;
	}

	/**
	 * Stampa la descrizione dell'operazione.
	 * 
	 * @return descrizione operazione
	 */
	public void stampa() {
		System.out
				.println("Data Operazione: " + dataOperazione + "\n"
						+ "Numero conto: " + numeroConto + "\n" + "Importo: "
						+ importo);
	}

	/**
	 * Calcola il costo della singola operazione.
	 * 
	 * @return restituisce il costo (int)
	 */
	public abstract int getCosto();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(OperazioneBancaria o) {
		// inordine di data
		return this.dataOperazione.compareTo(o.dataOperazione);
	}

	// come importo ma pu� essere negativo per un prelievo
	/**
	 * Gets the valore.
	 * 
	 * @return the valore
	 */
	public abstract float getValore();
}
