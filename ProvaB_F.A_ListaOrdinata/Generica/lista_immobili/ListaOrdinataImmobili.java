package lista_immobili;

class ListaOrdinataDiImmobili<T extends Comparable<T>>
{
	// CAMPI
	Immobile inizio;
	
	class Immobile				// NodoLista
	{
		T dato;					// NodoLista.dato
		Immobile prossimo;		// NodoLista.prossimo
		
		// Costruttore Immobile
		public Immobile()		// Costruttore NodoLista()
		{
			dato = null;
			prossimo = null;
		}
	}
	
	// COSTRUTTORI
	// Costruttore ListaOrdinataDiImmobili()
	public ListaOrdinataDiImmobili()
	{
		inizio = null;
	}
	
	// METODI
	// Insert in ordine
	void insert(T costoImmobileDaInserire)
	{
		Immobile nuovoImmobile = new Immobile();
		nuovoImmobile.dato = costoImmobileDaInserire;
		
		if (inizio == null)		// Se la lista è vuota
		{
			inizio = nuovoImmobile;
			nuovoImmobile.prossimo = null;
		} else if (inizio.prossimo == null)			// Se la lista ha 1 solo elemento
		{
			if (nuovoImmobile.dato.compareTo(inizio.dato) < 0)
			{										// Inserisci prima
				nuovoImmobile.prossimo = inizio;
				inizio = nuovoImmobile;
			} else {								// Inserisci dopo
				inizio.prossimo = nuovoImmobile;
				nuovoImmobile.prossimo = null;
			}
		} else										// Se la lista ha più di 1 elemento
		{
			if ((inizio.dato).compareTo(nuovoImmobile.dato) > 0)
			{
				nuovoImmobile.prossimo = inizio;
				inizio = nuovoImmobile;
			} else
			{
				Immobile questoImmobile = new Immobile();
				questoImmobile = inizio;
				while (questoImmobile.prossimo != null && (questoImmobile.prossimo.dato).compareTo(nuovoImmobile.dato) < 0)
				{
					System.out.println("questoImmobile punta al momento a: " + questoImmobile.dato);
					questoImmobile = questoImmobile.prossimo;
				}
				nuovoImmobile.prossimo = questoImmobile.prossimo;
				questoImmobile.prossimo = nuovoImmobile;
			}
		}
	}
	
	void remove(T immobiliDiCostoRimuovere)
	{
		/*if (inizio == null)
		{
			System.out.println("Lista senza elementi")
		}*/
		// TODO
	}
	
	// Stampa
	String print()
	{
		String result = "";
		Immobile questoImmobile = new Immobile();
		questoImmobile = inizio;
		while (questoImmobile != null)
		{
			result = result + questoImmobile.dato + " ";
			questoImmobile = questoImmobile.prossimo;
		}
		return result;
	}
	
	// Get il max prezzo contenuto in dato
	T getMax()
	{
		T result;
		if (inizio == null)
		{
			result = null;
		}
		else
		{
			result = inizio.dato;
			Immobile questoImmobile = new Immobile();
			questoImmobile = inizio;
			while (questoImmobile != null)
			{
				if(result.compareTo(questoImmobile.dato) < 0)
				{
					result = questoImmobile.dato;
				}
				questoImmobile = questoImmobile.prossimo;
			}
		}
		
		return result;
	}
	
}

public class ListaOrdinataImmobili
{
	public static void main(String[] args)
	{
		ListaOrdinataDiImmobili<Integer> unaListaOrdinataDiImmobili = new ListaOrdinataDiImmobili<Integer>();
		System.out.println("Il max è: " + unaListaOrdinataDiImmobili.getMax());
		System.out.println();
		
		System.out.println("Inserimento di un immobile di prezzo 5");
		unaListaOrdinataDiImmobili.insert(5);
		System.out.println("Lo stato attuale della lista: " + unaListaOrdinataDiImmobili.print());
		System.out.println();
		
		System.out.println("Il max è: " + unaListaOrdinataDiImmobili.getMax());
		System.out.println();
		
		System.out.println("Inserimento di un immobile di prezzo 1");
		unaListaOrdinataDiImmobili.insert(1);
		System.out.println("Lo stato attuale della lista: " + unaListaOrdinataDiImmobili.print());
		System.out.println();
		
		System.out.println("Inserimento di un immobile di prezzo 9");
		unaListaOrdinataDiImmobili.insert(9);
		System.out.println("Lo stato attuale della lista: " + unaListaOrdinataDiImmobili.print());
		System.out.println();
		
		System.out.println("Inserimento di un immobile di prezzo 2");
		unaListaOrdinataDiImmobili.insert(2);
		System.out.println("Lo stato attuale della lista: " + unaListaOrdinataDiImmobili.print());
		System.out.println();
		
		System.out.println("Inserimento di un immobile di prezzo 3");
		unaListaOrdinataDiImmobili.insert(3);
		System.out.println("Lo stato attuale della lista: " + unaListaOrdinataDiImmobili.print());
		System.out.println();
		
		System.out.println("Inserimento di un immobile di prezzo 6");
		unaListaOrdinataDiImmobili.insert(6);
		System.out.println("Lo stato attuale della lista: " + unaListaOrdinataDiImmobili.print());
		System.out.println();
		
		System.out.println("Inserimento di un immobile di prezzo 0");
		unaListaOrdinataDiImmobili.insert(0);
		System.out.println("Lo stato attuale della lista: " + unaListaOrdinataDiImmobili.print());
		System.out.println();
		
		System.out.println("Inserimento di un immobile di prezzo 15");
		unaListaOrdinataDiImmobili.insert(15);
		System.out.println("Lo stato attuale della lista: " + unaListaOrdinataDiImmobili.print());
		System.out.println();
		
		System.out.println("Il max è: " + unaListaOrdinataDiImmobili.getMax());
	}
	
}