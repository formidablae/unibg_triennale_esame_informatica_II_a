package sistema;

import java.util.ArrayList;

import telecamera.Telecamera;

public class Sistema
{
	// CAMPI
	ArrayList<Telecamera> elencoTelecamere;
	
	// COSTRUTTORI
	public Sistema()
	{
		elencoTelecamere = new ArrayList<Telecamera>();
	}
	
	// METODI
	public void inserisciTelecameraInSistema(Telecamera telecameraDaInserire)
	{
		this.elencoTelecamere.add(telecameraDaInserire);
	}

	public String stampaSistema() {
		String result = "";
		if (elencoTelecamere.size() == 0)
		{
			result = "Sistema senza telecamere.";
		}
		else {
			int larghezzaTabella = elencoTelecamere.get(0).stampaTelecamera().length();
			int contaDash = 0;
			String lineaOrizzontale = "";
			while (larghezzaTabella > contaDash)
			{
				lineaOrizzontale = lineaOrizzontale + "─";
				contaDash++;
			}
			
			result = result + lineaOrizzontale;
			
			for (Telecamera ogniTelecamera : this.elencoTelecamere)
			{
				result = result + "\n";
				result = result + ogniTelecamera.stampaTelecamera() + "\n";
				result = result + lineaOrizzontale;
			}
		}
		
		return result;
	}	
	
	// METODI STATICI
	
}
