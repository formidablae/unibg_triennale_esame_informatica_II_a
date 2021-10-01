package OperazioniBancarie;

import prog.utili.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class Versamento.
 */
public class Versamento extends OperazioneBancaria {

	/** The causale versamento. */
	private String causaleVersamento;

	/** The tipo. */
	private TipoVersamento tipo;

	/**
	 * Crea un nuovo versamento utilizzando il metodo ENUM.values()[n]
	 * 
	 * @param dataOperazione
	 *            the data operazione
	 * @param numeroConto
	 *            the numero conto
	 * @param importo
	 *            the importo
	 * @param tipoVers
	 *            tipo di pagamento, 0 per ASSEGNO, 1 per CONTANTI, 2 per ALTRO
	 */

	public Versamento(Data dataOperazione, int numeroConto, float importo,
			int tipoVers) {
		super(dataOperazione, numeroConto, importo);
		tipo = TipoVersamento.values()[tipoVers];
	}

	/**
	 * Questo metodo consente di impostare la causale del versamento, non
	 * inizializzata nel costruttore.
	 * 
	 * @param causale
	 *            stringa indicante la causale
	 */
	public void setCausale(String causale) {
		causaleVersamento = causale;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see OperazioniBancarie.OperazioneBancaria#stampa()
	 */
	@Override
	public void stampa() {
		System.out.println("VERSAMENTO");
		super.stampa();
		System.out.println("Causale Versamento: " + causaleVersamento + "\n"
				+ "Tipo Versamento: " + tipo + "\n" + "Costo Operazione (�): "
				+ getCosto());
	}

	/**
	 * Calcola il costo del Versamento.
	 * 
	 * @return il costo dell'operazione; 0 se si usano i contanti, 1 l'assegno,
	 *         5 altro mezzo
	 */
	@Override
	public int getCosto() {
		return tipo.getCosto();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see OperazioniBancarie.OperazioneBancaria#getValore()
	 */
	@Override
	public float getValore() {
		return importo;
	}
}
