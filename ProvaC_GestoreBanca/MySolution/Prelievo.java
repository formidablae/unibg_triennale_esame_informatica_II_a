
public class Prelievo extends Operazione
{
	// Campi
	String originePrelievo; // bancomat, pagamentoPOS, online
	
	// Costruttori
	
	// Metodi
	@Override
	void stampa()
	{
		System.out.println("Prelievo" +
	                       " con ID: " + super.id +
				           "; Data: " + super.dataOperazione +
				           "; Numero del conto corrente: " + super.numeroContoCorrente +
				           "; Importo dell'operazione: " + super.importoOperazione +
				           "; Origine del prelievo: " + originePrelievo +
				           ".");
	}
}
