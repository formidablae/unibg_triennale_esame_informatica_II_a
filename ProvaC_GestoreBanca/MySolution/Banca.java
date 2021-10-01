import java.util.ArrayList;

public class Banca
{
	// Campi
	String nomeBanca;
	static ArrayList<Conto> elencoContiCorrenti = new ArrayList<Conto>();
	static ArrayList<Operazione> elencoOperazioni;
	
	// Costruttori
	Banca()
	{
		nomeBanca = "";
	}
	
	Banca(String nomeDellaBanca)
	{
		nomeBanca = nomeDellaBanca;
	}
	
	static Conto aperturaContoCorrente(String intestatario)
	{
		Conto nuovoConto = new Conto(intestatario);
		elencoContiCorrenti.add(nuovoConto);
		return nuovoConto;
		// Collections.sort(elencoContiCorrenti);
	}
	
	void stampaElencoConti()
	{
		for(Conto ogniConto : elencoContiCorrenti)
		{
			System.out.println("Conto con numero: " + ogniConto.getNumeroContoCorrente() +
							   "; Nome intestatario: " + ogniConto.getIntestatario() +
							   "; Saldo: " + ogniConto.getSaldo() +
							   ".");
		}
	}
	
	void ordinaElencoConti()
	{
		
	}
	
	// Metodi
	void eseguiOperazione(Object operazione)
	{
		
	}
	
	void stampaMovimenti(int numeroContoCorrente, int n)
	{
		
	}
	
	void leggiFileConti(String file)
	{
		
	}
	
	void stampaSaldi()
	{
		// Collections.sort();
		// Collections.reverse(elencoContiCorrenti);
		for(Conto ogniConto : elencoContiCorrenti)
		{
			System.out.println(ogniConto.getSaldo());
		}
	}
	
	public void eliminaConto()
	{
		for(Conto contoDaEliminare : elencoContiCorrenti)
		{
			int posizione = elencoContiCorrenti.indexOf(contoDaEliminare);
			elencoContiCorrenti.remove(posizione);
		}
	}

	public void eliminaConto(int numeroContoDaEliminare)
	{
		for(Conto contoDaEliminare : elencoContiCorrenti)
		{
			if(contoDaEliminare.getNumeroContoCorrente() == numeroContoDaEliminare)
			{
				int posizione = elencoContiCorrenti.indexOf(contoDaEliminare);
				elencoContiCorrenti.remove(posizione);
			}
		}
	}
	
	public void eliminaConto(float saldoSoglia, String menoPiuPari)
	{
		if(menoPiuPari.equals("Meno"))
		{
			for(Conto contoDaEliminare : elencoContiCorrenti)
			{
				if(contoDaEliminare.getSaldo() < saldoSoglia)
				{
					int posizione = elencoContiCorrenti.indexOf(contoDaEliminare);
					elencoContiCorrenti.remove(posizione);
				}
			}
		}
		else if(menoPiuPari.equals("Piu"))
		{
			for(Conto contoDaEliminare : elencoContiCorrenti)
			{
				if(contoDaEliminare.getSaldo() > saldoSoglia)
				{
					int posizione = elencoContiCorrenti.indexOf(contoDaEliminare);
					elencoContiCorrenti.remove(posizione);
				}
			}
		}
		else if(menoPiuPari.equals("Pari"))
		{
			for(Conto contoDaEliminare : elencoContiCorrenti)
			{
				if(contoDaEliminare.getSaldo() == saldoSoglia)
				{
					int posizione = elencoContiCorrenti.indexOf(contoDaEliminare);
					elencoContiCorrenti.remove(posizione);
				}
			}
		}
	}
	
	public void eliminaConto(String intestatarioDelContoDaEliminare)
	{
		for(Conto contoDaEliminare : elencoContiCorrenti)
		{
			if(contoDaEliminare.getIntestatario().equals(intestatarioDelContoDaEliminare))
			{
				int posizione = elencoContiCorrenti.indexOf(contoDaEliminare);
				elencoContiCorrenti.remove(posizione);
			}
		}
	}

	public void rinominaBanca(String nuovoNomeBancaInput)
	{
		nomeBanca = nuovoNomeBancaInput;
	}

}
