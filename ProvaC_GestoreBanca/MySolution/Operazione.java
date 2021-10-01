import prog.utili.Data;

public class Operazione
{
	// Campi
	int id;
	float importoOperazione;
	Data dataOperazione;
	int numeroContoCorrente;
	
	// Costruttori
	Operazione()
	{
		
	}
	Operazione(float importoOperazioneInput, Data dataOperazioneInput, int numeroContoCorrenteInput)
	{
		importoOperazione = importoOperazioneInput;
		dataOperazione = dataOperazioneInput;
		numeroContoCorrente = numeroContoCorrenteInput;
		Conto.updateSaldo(importoOperazioneInput);
	}
	
	// Metodi
	int getIdOperazione()
	{
		return id;
	}
	
	int getCC()
	{
		return numeroContoCorrente;
	}
	
	float getImporto()
	{
		return importoOperazione;
	}
	
	void stampa()
	{
		System.out.println("Operazione" +
				           " con ID: " + id +
				           "; Data: " + dataOperazione +
				           "; Numero del conto corrente: " + numeroContoCorrente +
				           "; Importo dell'operazione: " + importoOperazione +
				           ".");
	}
}
