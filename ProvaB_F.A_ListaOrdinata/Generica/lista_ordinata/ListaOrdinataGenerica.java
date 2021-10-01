package lista_ordinata;

class ListaOrdinata<T extends Comparable<T>>
{
	// CAMPI
	NodoLista inizio;
	
	// Costruttore NodoLista
	class NodoLista
	{
		T dato;
		NodoLista prossimo;
		
		NodoLista()
		{
			dato = null;
			prossimo = null;
		}
	}
	
	// COSTRUTTORI
	// Costruttore ListaOrdinata
	ListaOrdinata()
	{
		inizio = null;
	}
	
	// METODI
	// Inserisci in ordine
	void inserisci(T oggetto)
	{
		NodoLista nuovoNodo = new NodoLista();
		nuovoNodo.dato = oggetto;
		nuovoNodo.prossimo = null;
		
		NodoLista questoNodo = new NodoLista();
		questoNodo = inizio;
		
		NodoLista precedenteNodo = new NodoLista();
		precedenteNodo = null;
		
		while (questoNodo != null && nuovoNodo.dato.compareTo(questoNodo.dato) > 0)
		{
			precedenteNodo = questoNodo;
			questoNodo = questoNodo.prossimo;
		}
		
		nuovoNodo.prossimo = questoNodo;		// 
		if (precedenteNodo == null)				// Inserisci all'inizio
		{
			inizio = nuovoNodo;
		} else									// Inserisci dopo il precedenteNodo
		{
			precedenteNodo.prossimo = nuovoNodo;
		}
	}
	
	// Inserisci alla posizione n o solleva un'eccezione se tale posizione non esiste.
	void inserisciAt(T x, int n) throws LaPosizioneNonEsisteException
	{
		NodoLista nuovoNodo = new NodoLista();
		nuovoNodo.dato = x;
		nuovoNodo.prossimo = null;
		
		NodoLista questoNodo = new NodoLista();
		questoNodo = inizio;
		
		NodoLista precedenteNodo = new NodoLista();
		precedenteNodo = null;
		
		int posizione = 0;										// Primo elemento in lista considerato 0
		
		while (posizione != n && questoNodo != null)
		{
			precedenteNodo = questoNodo;
			questoNodo = questoNodo.prossimo;
			posizione++;
		}
		
		if (posizione != n)
		{
			throw new LaPosizioneNonEsisteException("Exception catturata. Tale posizione non esiste.");
		} else if (posizione == 0)
		{
			nuovoNodo.prossimo = questoNodo;
			inizio = nuovoNodo;
		} else
		{
			precedenteNodo.prossimo = nuovoNodo;
			nuovoNodo.prossimo = questoNodo;
		}
	}
	
	// Inserisci in fondo alla lista.
	void inserisciInFondo(T oggetto)
	{
		NodoLista questoNodo = new NodoLista();
		questoNodo = this.inizio;
		
		int contatore = 0;
		
		while (questoNodo != null)
		{
			contatore++;
			questoNodo = questoNodo.prossimo;
		}
		
		inserisciAt(oggetto, contatore);
	}
	
	// Set un dato x in una posizione n
	void set(T x, int n)
	{
		NodoLista nuovoNodo = new NodoLista();
		nuovoNodo.dato = x;
		nuovoNodo.prossimo = null;
		
		NodoLista questoNodo = new NodoLista();
		questoNodo = inizio;
		
		int posizione = 0;										// Primo elemento in lista considerato 0
		
		while (posizione != n && questoNodo != null)
		{
			questoNodo = questoNodo.prossimo;
			posizione++;
		}
		
		if (posizione != n)
		{
			throw new LaPosizioneNonEsisteException("Exception catturata. Tale posizione non esiste.");
		} else
		{
			nuovoNodo.prossimo = questoNodo.prossimo;
			questoNodo = nuovoNodo;
		}
	}
	
	// Rimuove l'elemento in posizione n o solleva un'eccezione se tale posizione non esiste.
	void rimuovi(int n)
	{
		NodoLista questoNodo = new NodoLista();
		questoNodo = inizio;
		
		NodoLista precedenteNodo = new NodoLista();
		precedenteNodo = null;
		
		int posizione = 0;										// Primo elemento in lista considerato 0
		
		while (posizione != n && questoNodo != null)
		{
			precedenteNodo = questoNodo;
			questoNodo = questoNodo.prossimo;
			posizione++;
		}
		
		if (posizione != n)
		{
			throw new LaPosizioneNonEsisteException("Exception catturata. Tale posizione non esiste.");
		} else if (posizione == 0)
		{
			inizio = questoNodo.prossimo;
		} else
		{
			precedenteNodo.prossimo = questoNodo.prossimo;
		}
	}
	
	// Stampa
	public String toString()
	{
		String result = "";
		NodoLista questoNodo = new NodoLista();
		questoNodo = inizio;
		
		while (questoNodo != null)
		{
			result = result + questoNodo.dato + " ";
			questoNodo = questoNodo.prossimo;
		}
		return result;
	}

	// Stampa gli ultimi 5 elementi in lista
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String toString5()
	{
		ListaOrdinata listaCopiaCinque = new ListaOrdinata();
		
		NodoLista questoNodo = new NodoLista();
		questoNodo = this.inizio;
		
		int contatore = 0;
		
		while (questoNodo != null)
		{
			listaCopiaCinque.inserisciInFondo(questoNodo.dato);
			questoNodo = questoNodo.prossimo;
			
			contatore++;
			if (contatore == 5 && questoNodo != null)
			{
				listaCopiaCinque.rimuovi(0);
				contatore--;
			}
		}
		return listaCopiaCinque.toString();
	}
}

public class ListaOrdinataGenerica
{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args)
	{
		System.out.println("TEST CON INTERI\n");												// Prova con interi
		ListaOrdinata unaListaA = new ListaOrdinata();
		
		System.out.println("Insert 17 alla posizione 0");
		unaListaA.inserisciAt(17, 0);
		System.out.println("La lista A: " + unaListaA.toString());
		System.out.println();
		
		System.out.println("Insert 5");
		unaListaA.inserisci(5);
		System.out.println("La lista A: " + unaListaA.toString());
		System.out.println();
		
		System.out.println("Rimuovi l'elemento in posizione 0");
		unaListaA.rimuovi(0);
		System.out.println("La lista A: " + unaListaA.toString());
		System.out.println();
		
		System.out.println("Insert 8");
		unaListaA.inserisci(8);
		System.out.println("La lista A: " + unaListaA.toString());
		System.out.println();
		
		System.out.println("Insert 3");
		unaListaA.inserisci(3);
		System.out.println("La lista A: " + unaListaA.toString());
		System.out.println();
		
		System.out.println("Rimuovi l'elemento in posizione 2");
		unaListaA.rimuovi(2);
		System.out.println("La lista A: " + unaListaA.toString());
		System.out.println();
		
		System.out.println("Insert 1");
		unaListaA.inserisci(1);
		System.out.println("La lista A: " + unaListaA.toString());
		System.out.println();
		
		System.out.println("Insert 9");
		unaListaA.inserisci(9);
		System.out.println("La lista A: " + unaListaA.toString());
		System.out.println();
		
		System.out.println("Insert 7");
		unaListaA.inserisci(7);
		System.out.println("La lista A: " + unaListaA.toString());
		System.out.println();
		
		System.out.println("Insert 2");
		unaListaA.inserisci(2);
		System.out.println("La lista A: " + unaListaA.toString());
		System.out.println();
		
		System.out.println("Insert 13 alla posizione 4");
		unaListaA.inserisciAt(13, 4);
		System.out.println("La lista A: " + unaListaA.toString());
		System.out.println();
		
		System.out.println("Stampa gli ultimi 5 elementi in lista A");
		System.out.println("Gli elementi sono: " + unaListaA.toString5());
		System.out.println();
		

		
		ListaOrdinata unaListaB = new ListaOrdinata();
		
		System.out.println("Insert 4");
		unaListaB.inserisci(4);
		System.out.println("La lista B: " + unaListaB.toString());
		System.out.println();
		
		System.out.println("Insert 9");
		unaListaB.inserisci(9);
		System.out.println("La lista B: " + unaListaB.toString());
		System.out.println();
		
		System.out.println("Insert 2");
		unaListaB.inserisci(2);
		System.out.println("La lista B: " + unaListaB.toString());
		System.out.println();
		
		System.out.println("Stampa gli ultimi 5 elementi in lista B");
		System.out.println("Gli elementi sono: " + unaListaB.toString5());
		System.out.println();
		
		System.out.println("Insert 8");
		unaListaB.inserisci(8);
		System.out.println("La lista B: " + unaListaB.toString());
		System.out.println();
		
		System.out.println("Insert 7");
		unaListaB.inserisci(7);
		System.out.println("La lista B: " + unaListaB.toString());
		System.out.println();
		
		System.out.println("Insert 6");
		unaListaB.inserisci(6);
		System.out.println("La lista B: " + unaListaB.toString());
		System.out.println();
		
		System.out.println("Insert 1");
		unaListaB.inserisci(1);
		System.out.println("La lista B: " + unaListaB.toString());
		System.out.println();
		
		System.out.println("TEST CON STRINGHE\n");														// Prova con stringhe
		
		ListaOrdinata unaListaC = new ListaOrdinata();
		
		System.out.println("Insert sedia alla posizione 0");
		unaListaC.inserisciAt("sedia", 0);
		System.out.println("La lista C: " + unaListaC.toString());
		System.out.println();
		
		System.out.println("Insert tavolo");
		unaListaC.inserisci("tavolo");
		System.out.println("La lista C: " + unaListaC.toString());
		System.out.println();
		
		System.out.println("Rimuovi l'elemento in posizione 0");
		unaListaC.rimuovi(0);
		System.out.println("La lista C: " + unaListaC.toString());
		System.out.println();
		
		System.out.println("Insert computer");
		unaListaC.inserisci("computer");
		System.out.println("La lista C: " + unaListaC.toString());
		System.out.println();
		
		System.out.println("Insert mano");
		unaListaC.inserisci("mano");
		System.out.println("La lista C: " + unaListaC.toString());
		System.out.println();
		
		System.out.println("Rimuovi l'elemento in posizione 2");
		unaListaC.rimuovi(2);
		System.out.println("La lista C: " + unaListaC.toString());
		System.out.println();
		
		System.out.println("Insert internet");
		unaListaC.inserisci("internet");
		System.out.println("La lista C: " + unaListaC.toString());
		System.out.println();
		
		System.out.println("Insert muro");
		unaListaC.inserisci("muro");
		System.out.println("La lista C: " + unaListaC.toString());
		System.out.println();
		
		System.out.println("Insert finestra");
		unaListaC.inserisci("finestra");
		System.out.println("La lista C: " + unaListaC.toString());
		System.out.println();
		
		System.out.println("Insert chiave");
		unaListaC.inserisci("chiave");
		System.out.println("La lista C: " + unaListaC.toString());
		System.out.println();
		
		System.out.println("Insert mela alla posizione 4");
		unaListaC.inserisciAt("mela", 4);
		System.out.println("La lista C: " + unaListaC.toString());
		System.out.println();
		
		System.out.println("Stampa gli ultimi 5 elementi in lista A");
		System.out.println("Gli elementi sono: " + unaListaC.toString5());
		System.out.println();
		

		
		ListaOrdinata unaListaD = new ListaOrdinata();
		
		System.out.println("Insert arancia");
		unaListaD.inserisci("arancia");
		System.out.println("La lista D: " + unaListaD.toString());
		System.out.println();
		
		System.out.println("Insert chiavetta");
		unaListaD.inserisci("chiavetta");
		System.out.println("La lista D: " + unaListaD.toString());
		System.out.println();
		
		System.out.println("Insert web");
		unaListaD.inserisci("web");
		System.out.println("La lista D: " + unaListaD.toString());
		System.out.println();
		
		System.out.println("Stampa gli ultimi 5 elementi in lista B");
		System.out.println("Gli elementi sono: " + unaListaD.toString5());
		System.out.println();
		
		System.out.println("Insert manovra");
		unaListaD.inserisci("manovra");
		System.out.println("La lista D: " + unaListaD.toString());
		System.out.println();
		
		System.out.println("Insert laptop");
		unaListaD.inserisci("laptop");
		System.out.println("La lista D: " + unaListaD.toString());
		System.out.println();
		
		System.out.println("Insert forse");
		unaListaD.inserisci("forse");
		System.out.println("La lista D: " + unaListaD.toString());
		System.out.println();
		
		System.out.println("Insert gioco");
		unaListaD.inserisci("gioco");
		System.out.println("La lista D: " + unaListaD.toString());
		System.out.println();
		
		System.out.println("TEST DELLE ECCEZIONI\n");
		
		System.out.println("Insert mandorla alla posizione 15. Test dell'eccezione.");					// Prova dell'eccezione
		unaListaD.inserisciAt("mandorla", 15);
		System.out.println("La lista D: " + unaListaD.toString());
		System.out.println();
	}
}