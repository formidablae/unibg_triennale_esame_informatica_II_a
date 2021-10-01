package telecamera;

public class Telecamera
{
	// CAMPI
	int id;
	String descrizione;
	double posizione;
	private int lunghezzaCampoId;
	private int lunghezzaCampoDescrizione;
	private int lunghezzaCampoPosizione;
	
	// COSTRUTTORI
	public Telecamera()													// DONE
	{
		id = 0;
		descrizione = null;
		posizione = 0;
		lunghezzaCampoId = 0;
		lunghezzaCampoDescrizione = 0;
		lunghezzaCampoPosizione = 0;
	}
	
	public Telecamera(String laDescrizione, double laPosizione)			// DONE
	{
		id = 0;
		descrizione = laDescrizione;
		posizione = laPosizione;
		lunghezzaCampoId = String.valueOf(id).length();
		lunghezzaCampoDescrizione = descrizione.length();
		lunghezzaCampoPosizione = String.valueOf(laPosizione).length();
	}
	
	// METODI
	public String stampaTelecamera()									// DONE
	{
		int contatoreSpaziId = 0;
		int contatoreSpaziDescrizione = 0;
		int contatoreSpaziPosizione = 0;
		String result;
		
		result = "│ ";
		result = result + "ID: ";
		while (lunghezzaCampoId != 4 - contatoreSpaziId)
		{
			result = result + " ";
			contatoreSpaziId++;
		}
		
		result = result + id;
		result = result + " │ ";
		result = result + "Descrizione: ";
		result = result + descrizione;
		
		while (lunghezzaCampoDescrizione != 30 - contatoreSpaziDescrizione)
		{
			result = result + " ";
			contatoreSpaziDescrizione++;
		}
		
		result = result + " │ ";
		result = result + "Posizione: ";
		result = result + "Km ";
		
		while (lunghezzaCampoPosizione != 5 - contatoreSpaziPosizione)
		{
			result = result + " ";
			contatoreSpaziPosizione++;
		}
		
		result = result + posizione;
		result = result + " │";
		
		return result;
	}
	
	
	
	
	// METODI STATICI
}
