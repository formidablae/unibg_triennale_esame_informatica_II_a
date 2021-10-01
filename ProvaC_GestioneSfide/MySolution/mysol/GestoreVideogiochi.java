package mysol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class GestoreVideogiochi
{
	// CAMPI
	ArrayList<Sfida> elencoSfide;
	
	// COSTRUTTORI
	GestoreVideogiochi()
	{
		elencoSfide = new ArrayList<Sfida>();
	}
	
	// METODI
	public void lettura()				// Leggi file 
	{
		
	}
	
	public void inserimento(Sfida sfidaDaInserire) throws SfidaNonValidaException
	{
		elencoSfide.add(sfidaDaInserire);
	}
	
	public String stampa()
	{
		if (elencoSfide.size() == 0)
		{
			return "Elenco vuoto.";
		}
		else
			{
			String result = "";
			
			int larghezzaTabella = elencoSfide.get(0).stampaSfida().length();
			String linea = "─";
			String lineaOrizzontale = "";
			for (int i = 0; i < larghezzaTabella; i++)
			{
				lineaOrizzontale = lineaOrizzontale + linea;
			}
			
			result = result + lineaOrizzontale + "\n";
			result = result +
			"│ ID     │ Data       │ Ora   │ Descrizione     │ Partecipante 1  │ Partecipante 2  │ Tipo         │ Validità   │ Punteggio  │"
			+ "\n";
			
			for (Sfida ogniSfida : elencoSfide)
			{
				result = result + lineaOrizzontale + "\n";
				result = result + ogniSfida.stampaSfida() + "\n";
			}
			result = result + lineaOrizzontale;
			return result;
		}
	}
	
	public String stampaInOrdinePerPunteggio()
	{
		GestoreVideogiochi unNuovoGestore = new GestoreVideogiochi();
		unNuovoGestore.elencoSfide = this.ordinaPerPunteggio();
		return unNuovoGestore.stampa();
	}
	
	public String stampaInOrdinePerData()
	{
		GestoreVideogiochi unNuovoGestore = new GestoreVideogiochi();
		unNuovoGestore.elencoSfide = this.ordinaPerData();
		return unNuovoGestore.stampa();
	}
	
	public ArrayList<Sfida> ordinaPerPunteggio()
	{
		ArrayList<Sfida> elencoOrdinato = new ArrayList<Sfida>();
		for (int i = 0; i < elencoSfide.size(); i++)
		{
			elencoOrdinato.add(elencoSfide.get(i));
		}
		
		if (elencoOrdinato.size() > 1)
		{
			boolean scambiato = false;
			do
			{
				scambiato = false;
				for (int i = 1; i < elencoOrdinato.size(); i++)
				{
					if(elencoOrdinato.get(i).punteggio < elencoOrdinato.get(i - 1).punteggio)
					{
						Sfida temp = elencoOrdinato.get(i);
						elencoOrdinato.set(i, elencoOrdinato.get(i - 1));
						elencoOrdinato.set(i - 1, temp);
						scambiato = true;
					}
				}
			} while (scambiato);
		}
		return elencoOrdinato;
	}
	
	public ArrayList<Sfida> ordinaPerData()
	{
		ArrayList<Sfida> elencoOrdinato = new ArrayList<Sfida>();
		for (int i = 0; i < elencoSfide.size(); i++)
		{
			elencoOrdinato.add(elencoSfide.get(i));
		}
		
		elencoOrdinato.sort(null);
		return elencoOrdinato;
	}
	
	public Sfida ricerca(String nomePartecipante)
	{
		Sfida risultato = null;
		for (Sfida unaSfida : elencoSfide)
		{
			if (unaSfida.nomePartecipanteUno.equals(nomePartecipante) || unaSfida.nomePartecipanteDue.equals(nomePartecipante))
			{
				risultato = unaSfida;
			}
		}
		return risultato;
	}
	
	public void readAndPopulateFromFile(String nomeDelFile) throws ParseException
	{
		BufferedReader bufferedReader = null;
		
		try																			// Try-catch in case of exceptions.
		{
			String currentLine;
			bufferedReader = new BufferedReader(new FileReader(nomeDelFile));		// Point bufferedReader to read from "DataFile.txt"
			
			while ((currentLine = bufferedReader.readLine()) != null)				// Read from the bufferedReader the currentLine.
			{																		// Create an arrayWithTheData for the elements
				String[] arrayWithTheData = currentLine.split(";");					// obtained by splitting currentLine every ";".
				switch(arrayWithTheData[0].substring(0,1))
				{
				case "N":
					SfidaNormale unaSfidaNormale = new SfidaNormale(	arrayWithTheData[0],			// idInput
																		arrayWithTheData[1],			// laDescrizione
																		arrayWithTheData[2],			// lOraTenuta
																		arrayWithTheData[3],			// ilNomePartecipanteUno
																		arrayWithTheData[4],			// ilNomePartecipanteDue
												   Boolean.parseBoolean(arrayWithTheData[5]),			// eSfidaCampionato
																		arrayWithTheData[6]);			// ilLuogoSfida
					elencoSfide.add(unaSfidaNormale);							// Add unaSfidaNormale to the dynamic list elencoSfide.
					break;
				case "P":
					SfidaPacifica unaSfidaPacifica = new SfidaPacifica(	arrayWithTheData[0],			// idInput
																		arrayWithTheData[1],			// laDescrizione
																		arrayWithTheData[2],			// lOraTenuta
																		arrayWithTheData[3],			// ilNomePartecipanteUno
																		arrayWithTheData[4],			// ilNomePartecipanteDue
												   Boolean.parseBoolean(arrayWithTheData[5]));			// eSfidaCampionato
					elencoSfide.add(unaSfidaPacifica);							// Add unaSfidaPacifica to the dynamic list elencoSfide.
					break;
				case "C":
					SfidaCompetizione unaSfidaCompetizione = new SfidaCompetizione(	arrayWithTheData[0],	// idInput
																					arrayWithTheData[1],	// laDescrizione
																					arrayWithTheData[2],	// lOraTenuta
																					arrayWithTheData[3],	// ilNomePartecipanteUno
																					arrayWithTheData[4],	// ilNomePartecipanteDue
															   Boolean.parseBoolean(arrayWithTheData[5]),	// eSfidaCampionato
																   Integer.parseInt(arrayWithTheData[6]));	// ilPunteggio
					elencoSfide.add(unaSfidaCompetizione);						// Add unaSfidaCompetizione to the dynamic list elencoSfide.
					break;
				default:
					break;
				
				}
			}																	// Repeat the loop until currentLine == null.
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally																	// Finally
		{
			try
			{
				if (bufferedReader != null)										// if bufferedReader hasn't reached the end,
				{
					bufferedReader.close();										// close the bufferedReader.
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}

	}
	
	// METODI STATICI
	
	
}
