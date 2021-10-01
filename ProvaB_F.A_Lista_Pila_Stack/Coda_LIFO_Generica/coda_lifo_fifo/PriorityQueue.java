package coda_lifo_fifo;

public class PriorityQueue<E>
{
	// CAMPI
	NodoCoda primo;
	NodoCoda ultimo;
	
	class NodoCoda
	{
		E dato;
		NodoCoda prossimo;
	}
	
	// COSTRUTTORI
	PriorityQueue()
	{
		primo = null;
		ultimo = null;
	}
	
	// METODI
	// Insert in coda
	void insert(E oggetto)				// inserimento alla fine
	{
		NodoCoda nuovoNodo = new NodoCoda();
		nuovoNodo.dato = oggetto;
		nuovoNodo.prossimo = null;
		if (primo == null)				// se la coda è vuota
		{
			primo = nuovoNodo;
			ultimo = nuovoNodo;
		} else							// coda non vuota
		{
			ultimo.prossimo = nuovoNodo;
			ultimo = nuovoNodo;
		}
	}
	
	// Insert in testa
	void insertInTesta(E oggetto)		// inserimento all'inizio
	{
		NodoCoda nuovoNodo = new NodoCoda();
		nuovoNodo.dato = oggetto;
		nuovoNodo.prossimo = primo;
		primo = nuovoNodo;
		if (ultimo == null)				// se la coda era vuota
		{
			ultimo = nuovoNodo;
		}
	}
	
	// Next
	@SuppressWarnings("finally")
	NodoCoda next()
	{
		NodoCoda result = new NodoCoda();
		try
		{
			result.dato = primo.dato;
			result.prossimo = primo.prossimo;
			primo = primo.prossimo;
		} catch (Exception e)
		{
			System.out.println("Eccezione catturata. Coda vuota.");
			return null;
		} finally
		{
			return result;
		}
	}
	
	// Stampa
	String print()
	{
		String result = "";
		NodoCoda nodoPresente = new NodoCoda();
		nodoPresente = primo;
		while (nodoPresente != null)
		{
			result = result + nodoPresente.dato + " ";
			/*if (nodoPresente == ultimo)
			{
				nodoPresente = null;
			} else */nodoPresente = nodoPresente.prossimo;
		}
		return result;
	}
	
	// MAIN
	public static void main(String[] args)
	{
		PriorityQueue<Integer> codaPioritaria = new PriorityQueue<Integer>();
		
		System.out.print("Restituisci e togli il nodo all'inizio: ");
		System.out.print(codaPioritaria.next().dato);
		System.out.println("\n");
		
		System.out.println("Insert 13 all'inizio");
		codaPioritaria.insertInTesta(13);
		System.out.println("Stato coda: " + codaPioritaria.print());
		System.out.println();
		
		System.out.println("Insert 1 alla fine");
		codaPioritaria.insert(1);
		System.out.println("Stato coda: " + codaPioritaria.print());
		System.out.println();
		
		System.out.print("Restituisci e togli il nodo all'inizio: ");
		System.out.print(codaPioritaria.next().dato);
		System.out.println("\n");
		
		System.out.println("Insert 16 all'inizio");
		codaPioritaria.insertInTesta(16);
		System.out.println("Stato coda: " + codaPioritaria.print());
		System.out.println();
		
		System.out.println("Insert 9 alla fine");
		codaPioritaria.insert(9);
		System.out.println("Stato coda: " + codaPioritaria.print());
		System.out.println();
		
		System.out.println("Insert 0 all'inizio");
		codaPioritaria.insertInTesta(0);
		System.out.println("Stato coda: " + codaPioritaria.print());
		System.out.println();
		
		System.out.print("Restituisci e togli il nodo all'inizio: ");
		System.out.print(codaPioritaria.next().dato);
		System.out.println("\n");
		
		System.out.print("Restituisci e togli il nodo all'inizio: ");
		System.out.print(codaPioritaria.next().dato);
		System.out.println("\n");
		
		System.out.print("Restituisci e togli il nodo all'inizio: ");
		System.out.print(codaPioritaria.next().dato);
		System.out.println("\n");
		
		System.out.print("Restituisci e togli il nodo all'inizio: ");
		System.out.print(codaPioritaria.next().dato);
		System.out.println("\n");
		
		System.out.print("Restituisci e togli il nodo all'inizio: ");
		System.out.print(codaPioritaria.next().dato);
		System.out.println("\n");

		System.out.println("Insert 3 alla fine");
		codaPioritaria.insert(3);
		System.out.println("Stato coda: " + codaPioritaria.print());
		System.out.println();
		
		System.out.println("Insert 5 alla fine");
		codaPioritaria.insert(5);
		System.out.println("Stato coda: " + codaPioritaria.print());
		System.out.println();
		
		System.out.println("Insert 17 all'inizio");
		codaPioritaria.insertInTesta(17);
		System.out.println("Stato coda: " + codaPioritaria.print());
		System.out.println();
		
		System.out.println("Insert 7 alla fine");
		codaPioritaria.insert(7);
		System.out.println("Stato coda: " + codaPioritaria.print());
		System.out.println();
		
		System.out.println("Insert 6 alla fine");
		codaPioritaria.insert(6);
		System.out.println("Stato coda: " + codaPioritaria.print());
		System.out.println();
		
		System.out.println("Insert 8 alla fine");
		codaPioritaria.insert(8);
		System.out.println("Stato coda: " + codaPioritaria.print());
		System.out.println();

		System.out.println("Insert 4 all'inizio");
		codaPioritaria.insertInTesta(4);
		System.out.println("Stato coda: " + codaPioritaria.print());
		System.out.println();
		
		System.out.println("Insert 10 all'inizio");
		codaPioritaria.insertInTesta(10);
		System.out.println("Stato coda: " + codaPioritaria.print());
		System.out.println();
	}
}