package ordinata_e_nonordinata;

class ListaDoppiaGenerica<T>
{
	// CAMPI
	NodoLista inizio;
	
	class NodoLista
	{
		// Campi NodoLista
		T dato;
		NodoLista next;
		NodoLista previous;
		
		// Costruttore NodoLista
		NodoLista()
		{
			dato = null;
			next = null;
			previous = null;
		}
	}
	
	// COSTRUTTORE
	ListaDoppiaGenerica()
	{
		inizio = null;
	}
	
	// METODI
	// inserisci
	void inserisci(T elemento, int n) throws ListaException
	{
		NodoLista nuovoNodo = new NodoLista();
		nuovoNodo.dato = elemento;
		
		int posizione = 0;
		
		NodoLista questoNodo = new NodoLista();
		questoNodo = inizio;
		
		NodoLista precedenteNodo = new NodoLista();
		precedenteNodo = null;
		
		if (n == 0 && questoNodo == null)
		{
			inizio = nuovoNodo;
		}
		else if (n == 0 && questoNodo != null)
		{
			nuovoNodo.next = questoNodo;
			questoNodo.previous = nuovoNodo;
			inizio = nuovoNodo;
		}
		else
		{
			while(posizione != n)
			{
				precedenteNodo = questoNodo;
				questoNodo = questoNodo.next;
				posizione++;
				
				if (questoNodo == null && posizione != n)
				{
					throw new ListaException("Eccezione catturata. Oltre il range della lista.");
				}
			}
			
			precedenteNodo.next = nuovoNodo;
			nuovoNodo.previous = precedenteNodo;
			if (questoNodo != null)
			{
				nuovoNodo.next = questoNodo;
				questoNodo.previous = nuovoNodo;
			}
		}
	}
	
	// rimuovi
	void rimuovi(int n) throws ListaException
	{
		int posizione = 0;
		NodoLista questoNodo = new NodoLista();
		questoNodo = inizio;
		
		NodoLista precedenteNodo = new NodoLista();
		precedenteNodo = null;
		
		if (questoNodo == null)
		{
			throw new ListaException("Eccezione catturata. La lista è vuota.");
		}
		else
		{
			while(posizione != n)
			{
				precedenteNodo = questoNodo;
				questoNodo = questoNodo.next;
				posizione++;
				if (questoNodo == null && posizione != n)
				{
					throw new ListaException("Eccezione catturata. Oltre il range della lista.");
				}
			}
			if (posizione == 0 && questoNodo.next == null)
			{
				inizio = null;
			}
			else if (posizione == 0)
			{
				questoNodo.next.previous = null;
				inizio = questoNodo.next;
			}
			else if (questoNodo.next == null)
			{
				precedenteNodo.next = null;
			}
			else
			{
				questoNodo.next.previous = precedenteNodo;
				precedenteNodo.next = questoNodo.next;
			}
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
			questoNodo = questoNodo.next;
		}
		return result;
	}
}

public class ListaDoppiaOrdinataGenerica<T extends Comparable<T>>
{
	// CAMPI
	NodoLista inizio;
	
	class NodoLista
	{
		// Campi NodoLista
		T dato;
		NodoLista next;
		NodoLista previous;
		
		// Costruttore NodoLista
		NodoLista()
		{
			dato = null;
			next = null;
			previous = null;
		}
	}
	
	// COSTRUTTORE
	ListaDoppiaOrdinataGenerica()
	{
		inizio = null;
	}
	
	// METODI
	// inserisci in ordine
	void inserisci(T elemento)
	{
		NodoLista nuovoNodo = new NodoLista();
		nuovoNodo.dato = elemento;
		
		NodoLista questoNodo = new NodoLista();
		questoNodo = inizio;
		
		
		if (questoNodo == null)
		{
			inizio = nuovoNodo;
		}
		else if (questoNodo != null && nuovoNodo.dato.compareTo(questoNodo.dato) < 0)
		{
			nuovoNodo.next = questoNodo;
			questoNodo.previous = nuovoNodo;
			inizio = nuovoNodo;
		}
		else
		{
			while(questoNodo.next != null && nuovoNodo.dato.compareTo(questoNodo.next.dato) > 0)
			{
				questoNodo = questoNodo.next;
			}
			
			if (questoNodo.next == null)
			{
				nuovoNodo.previous = questoNodo;
				questoNodo.next = nuovoNodo;
			}
			else
			{
				nuovoNodo.next = questoNodo.next;
				nuovoNodo.previous = questoNodo;
				questoNodo.next.previous = nuovoNodo;
				questoNodo.next = nuovoNodo;
			}
		}
	}
	
	// rimuovi
	void rimuovi(int n) throws ListaException
	{
		int posizione = 0;
		NodoLista questoNodo = new NodoLista();
		questoNodo = inizio;
		
		NodoLista precedenteNodo = new NodoLista();
		precedenteNodo = null;
		
		if (questoNodo == null)
		{
			throw new ListaException("Eccezione catturata. La lista è vuota.");
		}
		else
		{
			while(posizione != n)
			{
				precedenteNodo = questoNodo;
				questoNodo = questoNodo.next;
				posizione++;
				if (questoNodo == null && posizione != n)
				{
					throw new ListaException("Eccezione catturata. Oltre il range della lista.");
				}
			}
			if (posizione == 0 && questoNodo.next == null)
			{
				inizio = null;
			}
			else if (posizione == 0)
			{
				questoNodo.next.previous = null;
				inizio = questoNodo.next;
			}
			else if (questoNodo.next == null)
			{
				precedenteNodo.next = null;
			}
			else
			{
				questoNodo.next.previous = precedenteNodo;
				precedenteNodo.next = questoNodo.next;
			}
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
			questoNodo = questoNodo.next;
		}
		return result;
	}
}

class Main
{
	public static void main(String[] args) throws ListaException
	{
		System.out.println("TEST LISTA DOPPIA ORDINATA\n");
		// TEST LISTA DOPPIA ORDINATA
		ListaDoppiaOrdinataGenerica unaListaDoppiaOrdinataDiStringhe = new ListaDoppiaOrdinataGenerica();
		
		System.out.println("INSERIMENTI DI STRINGHE IN LISTA ORDINATA\n");
		// INSERIMENTI DI STRINGHE IN LISTA ORDINATA
		System.out.println("Inserimento in lista ordinata di Pallone");
		unaListaDoppiaOrdinataDiStringhe.inserisci("Pallone");
		System.out.println("Stampa lista ordinata di stringhe: " + unaListaDoppiaOrdinataDiStringhe.toString());

		System.out.println("Inserimento in lista ordinata di Partita");
		unaListaDoppiaOrdinataDiStringhe.inserisci("Partita");
		System.out.println("Stampa lista ordinata di stringhe: " + unaListaDoppiaOrdinataDiStringhe.toString());

		System.out.println("Inserimento in lista ordinata di Giocare");
		unaListaDoppiaOrdinataDiStringhe.inserisci("Giocare");
		System.out.println("Stampa lista ordinata di stringhe: " + unaListaDoppiaOrdinataDiStringhe.toString());

		System.out.println("Inserimento in lista ordinata di Squadra");
		unaListaDoppiaOrdinataDiStringhe.inserisci("Squadra");
		System.out.println("Stampa lista ordinata di stringhe: " + unaListaDoppiaOrdinataDiStringhe.toString());
		
		ListaDoppiaOrdinataGenerica unaListaDoppiaOrdinataDiInteri = new ListaDoppiaOrdinataGenerica();
		
		System.out.println("\n\nINSERIMENTI DI INTERI IN LISTA ORDINATA\n");
		
		// INSERIMENTI DI INTERI IN LISTA ORDINATA
		
		System.out.println("Inserimento in lista ordinata di 32");
		unaListaDoppiaOrdinataDiInteri.inserisci(32);
		System.out.println("Stampa lista ordinata di interi: " + unaListaDoppiaOrdinataDiInteri.toString());
		
		System.out.println("Inserimento in lista ordinata di 35");
		unaListaDoppiaOrdinataDiInteri.inserisci(35);
		System.out.println("Stampa lista ordinata di interi: " + unaListaDoppiaOrdinataDiInteri.toString());

		System.out.println("Inserimento in lista ordinata di 36");
		unaListaDoppiaOrdinataDiInteri.inserisci(36);
		System.out.println("Stampa lista ordinata di interi: " + unaListaDoppiaOrdinataDiInteri.toString());

		System.out.println("Inserimento in lista ordinata di 39");
		unaListaDoppiaOrdinataDiInteri.inserisci(39);
		System.out.println("Stampa lista ordinata di interi: " + unaListaDoppiaOrdinataDiInteri.toString());
		
		System.out.println("Inserimento in lista ordinata di 45");
		unaListaDoppiaOrdinataDiInteri.inserisci(45);
		System.out.println("Stampa lista ordinata di interi: " + unaListaDoppiaOrdinataDiInteri.toString());
		
		System.out.println("\n\nTESTING DI RIMUOVI IN LISTA ORDINATA\n");
		
		// TESTING DI RIMUOVI IN LISTA ORDINATA
		System.out.println("Rimozione dalla lista ordinata dell'elemento in posizione 0");
		unaListaDoppiaOrdinataDiInteri.rimuovi(0);
		System.out.println("Stampa lista ordinata di stringhe: " + unaListaDoppiaOrdinataDiInteri.toString());
		
		System.out.println("Rimozione dalla lista ordinata dell'elemento in posizione 1");
		unaListaDoppiaOrdinataDiInteri.rimuovi(1);
		System.out.println("Stampa lista ordinata di stringhe: " + unaListaDoppiaOrdinataDiInteri.toString());
		
		System.out.println("Rimozione dalla lista ordinata dell'elemento in posizione 2");
		unaListaDoppiaOrdinataDiInteri.rimuovi(2);
		System.out.println("Stampa lista ordinata di stringhe: " + unaListaDoppiaOrdinataDiInteri.toString());
		
		System.out.println("\n\nTEST LISTA DOPPIA NON ORDINATA\n");
		
		// TEST LISTA DOPPIA NON ORDINATA
		ListaDoppiaGenerica unaListaDoppiaDiStringhe = new ListaDoppiaGenerica();
		
		System.out.println("INSERIMENTI DI STRINGHE IN LISTA NON ORDINATA\n");
		
		// INSERIMENTI DI STRINGHE IN LISTA NON ORDINATA
		System.out.println("Inserimento in lista non ordinata di Pallone in posizione 0");
		unaListaDoppiaDiStringhe.inserisci("Pallone", 0);
		System.out.println("Stampa lista non ordinata di stringhe: " + unaListaDoppiaDiStringhe.toString());
		
		System.out.println("Inserimento in lista non ordinata di Partita in posizione 1");
		unaListaDoppiaDiStringhe.inserisci("Partita", 1);
		System.out.println("Stampa lista non ordinata di stringhe: " + unaListaDoppiaDiStringhe.toString());
		
		System.out.println("Inserimento in lista non ordinata di Giocare in posizione 1");
		unaListaDoppiaDiStringhe.inserisci("Giocare", 1);
		System.out.println("Stampa lista non ordinata di stringhe: " + unaListaDoppiaDiStringhe.toString());
		
		System.out.println("Inserimento in lista non ordinata di Squadra in posizione 0");
		unaListaDoppiaDiStringhe.inserisci("Squadra", 0);
		System.out.println("Stampa lista non ordinata di stringhe: " + unaListaDoppiaDiStringhe.toString());
		
		System.out.println("Inserimento in lista non ordinata di Arbitro in posizione 3");
		unaListaDoppiaDiStringhe.inserisci("Arbitro", 3);
		System.out.println("Stampa lista non ordinata di stringhe: " + unaListaDoppiaDiStringhe.toString());
		
		System.out.println("Inserimento in lista non ordinata di Correre in posizione 5");
		unaListaDoppiaDiStringhe.inserisci("Correre", 5);
		System.out.println("Stampa lista non ordinata di stringhe: " + unaListaDoppiaDiStringhe.toString());
		
		ListaDoppiaGenerica unaListaDoppiaDiInteri = new ListaDoppiaGenerica();
		
		System.out.println("\n\nINSERIMENTI DI INTERI IN LISTA NON ORDINATA\n");
		
		// INSERIMENTI DI INTERI IN LISTA NON ORDINATA
		System.out.println("Inserimento in lista non ordinata di 32 in posizione 0");
		unaListaDoppiaDiInteri.inserisci(32, 0);
		System.out.println("Stampa lista non ordinata di interi: " + unaListaDoppiaDiInteri.toString());

		System.out.println("Inserimento in lista non ordinata di 35 in posizione 1");
		unaListaDoppiaDiInteri.inserisci(35, 1);
		System.out.println("Stampa lista non ordinata di interi: " + unaListaDoppiaDiInteri.toString());

		System.out.println("Inserimento in lista non ordinata di 36 in posizione 2");
		unaListaDoppiaDiInteri.inserisci(36, 2);
		System.out.println("Stampa lista non ordinata di interi: " + unaListaDoppiaDiInteri.toString());

		System.out.println("Inserimento in lista non ordinata di 39 in posizione 2");
		unaListaDoppiaDiInteri.inserisci(39, 2);
		System.out.println("Stampa lista non ordinata di interi: " + unaListaDoppiaDiInteri.toString());

		System.out.println("Inserimento in lista non ordinata di 27 in posizione 1");
		unaListaDoppiaDiInteri.inserisci(27, 1);
		System.out.println("Stampa lista non ordinata di interi: " + unaListaDoppiaDiInteri.toString());

		System.out.println("Inserimento in lista non ordinata di 40 in posizione 0");
		unaListaDoppiaDiInteri.inserisci(40, 0);
		System.out.println("Stampa lista non ordinata di interi: " + unaListaDoppiaDiInteri.toString());

		System.out.println("Inserimento in lista non ordinata di 42 in posizione 6");
		unaListaDoppiaDiInteri.inserisci(42, 6);
		System.out.println("Stampa lista non ordinata di interi: " + unaListaDoppiaDiInteri.toString());
		
		System.out.println("\n\nTESTING DI RIMUOVI IN LISTA NON ORDINATA\n");
		
		// TESTING DI RIMUOVI IN LISTA NON ORDINATA
		
		System.out.println("Rimozione dalla lista non ordinata dell'elemento in posizione 0");
		unaListaDoppiaDiInteri.rimuovi(0);
		System.out.println("Stampa lista non ordinata di stringhe: " + unaListaDoppiaDiInteri.toString());
		
		System.out.println("Rimozione dalla lista non ordinata dell'elemento in posizione 1");
		unaListaDoppiaDiInteri.rimuovi(1);
		System.out.println("Stampa lista non ordinata di stringhe: " + unaListaDoppiaDiInteri.toString());
		
		System.out.println("Rimozione dalla lista non ordinata dell'elemento in posizione 2");
		unaListaDoppiaDiInteri.rimuovi(2);
		System.out.println("Stampa lista non ordinata di stringhe: " + unaListaDoppiaDiInteri.toString());
		
		System.out.println("\n\nTESTING DI ECCEZIONE\n");
		
		// TESTING DI ECCEZIONE
		System.out.println("Inserimento in lista non ordinata di 29 in posizione 10");
		unaListaDoppiaDiInteri.inserisci(29, 10);
		System.out.println("Stampa lista non ordinata di interi: " + unaListaDoppiaDiInteri.toString());
	}
}