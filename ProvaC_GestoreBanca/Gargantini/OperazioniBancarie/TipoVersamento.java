package OperazioniBancarie;

/**
 * tipi di versamento con relativi costi.
 * 
 * @author garganti
 */
enum TipoVersamento {
	// il costo dell'operazione; 0 se si usano i contanti, 1 l'assegno,
	// 5 altro mezzo

	/** The contanti. */
	CONTANTI(0), /** The assegno. */
	ASSEGNO(1), /** The altro. */
	ALTRO(5);

	/** The costo. */
	private int costo;

	/**
	 * Costruttore dell'enum, utilizzato dalla JVC per creare gli elementi sopra
	 * riportati.
	 * 
	 * @param costo
	 *            the costo
	 */
	private TipoVersamento(int costo) {
		this.costo = costo;
	}

	/**
	 * Gets the costo.
	 * 
	 * @return the costo
	 */
	public int getCosto() {
		return costo;
	}

}
