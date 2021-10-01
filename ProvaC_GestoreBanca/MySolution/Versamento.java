
public class Versamento extends Operazione
{
	// Campi
	String mezzoUsatoVersamento; // contanti, assegno, altro
	String causaleVersamento; // opzionale
	
	// Costruttori
	
	// Metodi
	@Override
	void stampa()
	{
		System.out.println("Versamento" +
	                       " con ID: " + super.id +
				           "; Data: " + super.dataOperazione +
				           "; Numero del conto corrente: " + super.numeroContoCorrente +
				           "; Importo dell'operazione: " + super.importoOperazione +
				           "; Mezzo usato per versare: " + mezzoUsatoVersamento +
				           "; Causale: " + causaleVersamento +
				           ".");
	}
}
