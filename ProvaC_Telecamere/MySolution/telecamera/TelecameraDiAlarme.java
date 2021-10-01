package telecamera;

public class TelecameraDiAlarme extends Telecamera
{
	// CAMPI
	int numeroTelefono;
	private int lunghezzaCampoNumeroTelefono;
	
	// COSTRUTTORI
	public TelecameraDiAlarme()																		// DONE
	{
		super();
		numeroTelefono = 0;
		lunghezzaCampoNumeroTelefono = 0;
	}
	
	public TelecameraDiAlarme(String laDescrizione, double laPosizione)							// DONE
	{
		super(laDescrizione, laPosizione);
		numeroTelefono = 0;
		lunghezzaCampoNumeroTelefono = 0;
	}
	
	public TelecameraDiAlarme(String laDescrizione, double laPosizione, int numeroDiTelefono)	// DONE
	{
		super(laDescrizione, laPosizione);
		numeroTelefono = numeroDiTelefono;
		lunghezzaCampoNumeroTelefono = (String.valueOf(numeroDiTelefono)).length();
	}
	
	// METODI
	
	// METODI STATICI
	
}
