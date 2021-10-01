import prog.utili.Data;


public class Bonifico extends Operazione
{
	// Campi
	int coordinateBancaBeneficiario;
	String causaleBonifico; // opzionale
	
	// Costruttori
	Bonifico(int id,
			 float importoOperazioneInput,
			 Data dataOperazioneInput,
			 int numeroContoCorrenteInput,
			 int coordinateBancaBeneficiarioInput,
			 String causaleBonificoInput)
	{
		super.importoOperazione = importoOperazioneInput;
		super.dataOperazione = dataOperazioneInput;
		super.numeroContoCorrente = numeroContoCorrenteInput;
		coordinateBancaBeneficiario = coordinateBancaBeneficiarioInput;
		causaleBonifico = causaleBonificoInput;
	}
	
	// Metodi
	int getIdBonifico()
	{
		return super.getIdOperazione();
	}
	
	@Override
	void stampa()
	{
		System.out.println("Bonifico" +
				           " con ID: " + super.id +
				           "; Data: " + super.dataOperazione +
				           "; Numero del conto corrente: " + super.numeroContoCorrente +
				           "; Importo dell'operazione: " + super.importoOperazione +
				           "; Coordinate bancarie del beneficiario: " + coordinateBancaBeneficiario +
				           "; Causale: " + causaleBonifico +
				           ".");
	}
}