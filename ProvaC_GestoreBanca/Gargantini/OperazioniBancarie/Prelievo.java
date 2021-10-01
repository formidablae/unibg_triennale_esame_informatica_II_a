package OperazioniBancarie;

import prog.utili.Data;

/**
 * prelievo.
 */
public class Prelievo extends OperazioneBancaria {

	/** The Constant COSTO_PRELIEVO. */
	private static final int COSTO_PRELIEVO = 1;

	/** The provenienza. */
	private String provenienza;

	/**
	 * Crea un nuovo oggetto Prelievo.
	 * 
	 * @param dataOperazione
	 *            data in cui � stata effettuata l'operazione
	 * @param numeroConto
	 *            numero del conto da cui viene prelevato il denaro
	 * @param importo
	 *            quanto denaro viene prelevato
	 * @param luogoPrel
	 *            the luogo prelievo
	 */
	public Prelievo(Data dataOperazione, int numeroConto, float importo,
			String luogoPrel) {
		super(dataOperazione, numeroConto, importo);
		provenienza = luogoPrel;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see OperazioniBancarie.OperazioneBancaria#stampa()
	 */
	@Override
	public void stampa() {
		System.out.println("PRELIEVO");
		super.stampa();
		System.out.println("Provenienza: " + provenienza + "\n"
				+ "Costo Operazione (�): " + getCosto());
	}

	/**
	 * Ritorna il costo del prelievo (fisso).
	 * 
	 * @return 1
	 */
	@Override
	public int getCosto() {
		return COSTO_PRELIEVO; // costo fisso
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see OperazioniBancarie.OperazioneBancaria#getValore()
	 */
	@Override
	public float getValore() {
		return -importo;
	}

}
