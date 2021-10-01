package OperazioniBancarie;

import prog.utili.Data;
import Eccezioni.BeneficiarioNonValidoException;
import Eccezioni.DataEsecuzioneNonValidaException;

/**
 * The Class Bonifico.
 */
public class Bonifico extends OperazioneBancaria {

	/** The conto beneficiario. */
	private String contoBeneficiario;

	/** The data esecuzione. */
	private Data dataEsecuzione;

	/** The causale. */
	private String causale;

	/** The oggi. */
	private Data oggi = new Data(); // mi serve per fare il controllo sulla
									// dataEsecuzione

	/**
	 * Instantiates a new bonifico.
	 * 
	 * @param dataOperazione
	 *            data in cui viene effettuata l'operazione
	 * @param numeroConto
	 *            numero del conto pagante
	 * @param contoBeneficiario
	 *            numero del conto beneficiario
	 * @param dataEsecuzione
	 *            data di esecuzione
	 * @param importo
	 *            importo da trasferire
	 */
	public Bonifico(Data dataOperazione, int numeroConto,
			String contoBeneficiario, Data dataEsecuzione, float importo) {
		super(dataOperazione, numeroConto, importo);
		if (contoBeneficiario.length() == 0)
			throw new BeneficiarioNonValidoException(
					"Hai inserito un beneficiario non valido");
		this.contoBeneficiario = contoBeneficiario;
		if (dataEsecuzione.quantoManca(oggi) > 0)
			throw new DataEsecuzioneNonValidaException(
					"Hai specificato una data di esecuzione antecedente a quella di oggi");

		this.dataEsecuzione = dataEsecuzione;
	}

	/**
	 * Calcola il costo del bonifico bancario.
	 * 
	 * @return se il bonifico viene fatto entro 2 giorni si paga 1 euro, 0
	 *         altrimenti
	 */
	@Override
	public int getCosto() {
		int nGiorni = oggi.quantoManca(dataEsecuzione);
		return nGiorni <= 2 ? 1 : 0; // se voglio fare il bonifico entro 2
										// giorni pago 1 euro, 0 altrimenti
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see OperazioniBancarie.OperazioneBancaria#stampa()
	 */
	@Override
	public void stampa() {
		System.out.println("BONIFICO");
		super.stampa();
		System.out.println("Conto Beneficiario: " + contoBeneficiario + "\n"
				+ "Data di esecuzione: " + dataEsecuzione.toString() + "\n"
				+ "Costo Operazione (€): " + getCosto() + "\n" + "Causale: "
				+ causale);
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
