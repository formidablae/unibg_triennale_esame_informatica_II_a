package di_interi;

import java.util.Random;

public class ListaRandomListInteri
{
	// CAMPI
	NodoRandomList inizio;
	
	// nodo
	class NodoRandomList
	{
		int dato;
		NodoRandomList nextNodo;
	}
	
	// COSTRUTTORI
	ListaRandomListInteri()
	{
		inizio = null;
	}
	
	// METODI
	// size
	int size()
	{
		int count = 0;
		NodoRandomList nodoAttuale = this.inizio;
		while (nodoAttuale != null)
		{
			count++;
			nodoAttuale = nodoAttuale.nextNodo;
		}
		return count;
	}
	
	// insert
	void insert(int numero)
	{
		NodoRandomList nuovoNodo = new NodoRandomList();
		nuovoNodo.dato = numero;
		int dimensione = this.size();
		
		if (inizio == null)
		{
			System.out.println("La posizione random generata è  : Niente random");
			System.out.println("Dimensione lista preinserimento : " + size());
			inizio = nuovoNodo;
			nuovoNodo.nextNodo = null;
			System.out.println("Dimensione lista postinserimento: " + size());
		} else
		{
			Random numeroRandom = new Random();
			int prossimoNumeroRandom = numeroRandom.nextInt(dimensione + 1);
			
			NodoRandomList nodoAggancio = inizio;
			System.out.println("La posizione random generata è  : " + prossimoNumeroRandom);
			System.out.println("Dimensione lista preinserimento : " + dimensione);
			for (int i = 0; i <= prossimoNumeroRandom; i++)
			{
				if (prossimoNumeroRandom == dimensione)			// se prossimoNumeroRandom == dimensione
				{
					if (nodoAggancio.nextNodo == null)						// e se arrivati alla fine
					{
						nodoAggancio.nextNodo = nuovoNodo;					// inserimento nuovoNodo alla fine
						nuovoNodo.nextNodo = null;
						System.out.println("Dimensione lista postinserimento: " + size());
						break;
					} else nodoAggancio = nodoAggancio.nextNodo;	// se non ancora arrivati alla fine, vai al prossimo nodo.
				} else if (i == prossimoNumeroRandom)			// se prossimoNumeroRandom < dimensione e i == prossimoNumeroRandom
				{
					if (i == 0)
					{
						nuovoNodo.nextNodo = inizio;
						inizio = nuovoNodo;
						System.out.println("Dimensione lista postinserimento: " + size());
						break;
					} else
					{
						nodoAggancio = nodoAggancio.nextNodo;
					}
				} else if (i == prossimoNumeroRandom - 1)
				{
					nuovoNodo.nextNodo = nodoAggancio.nextNodo;
					nodoAggancio.nextNodo = nuovoNodo;
					System.out.println("Dimensione lista postinserimento: " + size());
					break;
				} else
				{
					nodoAggancio = nodoAggancio.nextNodo;
				}
			}
		}
	}
	
	// toString
	public String toString()
	{
		String result = "";
		NodoRandomList nodoAttuale = this.inizio;
		while (nodoAttuale != null)
		{
			if (nodoAttuale == this.inizio && this.inizio.nextNodo == null)
			{
				result = "|_" + String.valueOf(nodoAttuale.dato) + "_|";
			} else if (nodoAttuale == this.inizio)
			{
				result =  result + "|_" + String.valueOf(nodoAttuale.dato);
			} else if (nodoAttuale.nextNodo == null)
			{
				result = result + "_|_" + String.valueOf(nodoAttuale.dato) + "_|";
			} else
			{
				result = result + "_|_" + String.valueOf(nodoAttuale.dato);
			}
			nodoAttuale = nodoAttuale.nextNodo;
		}
		return result;
	}
	
	// MAIN
	public static void main(String[] args)
	{
		ListaRandomListInteri unaListaRandom = new ListaRandomListInteri();
		System.out.println("Inserimento del numero 4 in lista\n---------------------------------");
		unaListaRandom.insert(4);
		System.out.println("--------------------------------- _____");
		System.out.println("La ListaRandom è composta di    : " + unaListaRandom.toString());
		System.out.println();
		System.out.println();
		System.out.println("Inserimento del numero 7 in lista\n---------------------------------");
		unaListaRandom.insert(7);
		System.out.println("--------------------------------- _________");
		System.out.println("La ListaRandom è composta di    : " + unaListaRandom.toString());
		System.out.println();
		System.out.println();
		System.out.println("Inserimento del numero 2 in lista\n---------------------------------");
		unaListaRandom.insert(2);
		System.out.println("--------------------------------- _____________");
		System.out.println("La ListaRandom è composta di    : " + unaListaRandom.toString());
		System.out.println();
		System.out.println();
		System.out.println("Inserimento del numero 9 in lista\n---------------------------------");
		unaListaRandom.insert(9);
		System.out.println("--------------------------------- _________________");
		System.out.println("La ListaRandom è composta di    : " + unaListaRandom.toString());
		System.out.println();
		System.out.println();
		System.out.println("Inserimento del numero 0 in lista\n---------------------------------");
		unaListaRandom.insert(0);
		System.out.println("--------------------------------- _____________________");
		System.out.println("La ListaRandom è composta di    : " + unaListaRandom.toString());
		System.out.println();
		System.out.println();
		System.out.println("Inserimento del numero 1 in lista\n---------------------------------");
		unaListaRandom.insert(1);
		System.out.println("--------------------------------- _________________________");
		System.out.println("La ListaRandom è composta di    : " + unaListaRandom.toString());
		System.out.println();
		System.out.println();
		System.out.println("Inserimento del numero 3 in lista\n---------------------------------");
		unaListaRandom.insert(3);
		System.out.println("--------------------------------- _____________________________");
		System.out.println("La ListaRandom è composta di    : " + unaListaRandom.toString());
		System.out.println();
		System.out.println();
		System.out.println("Inserimento del numero 6 in lista\n---------------------------------");
		unaListaRandom.insert(6);
		System.out.println("--------------------------------- _________________________________");
		System.out.println("La ListaRandom è composta di    : " + unaListaRandom.toString());
		System.out.println();
		System.out.println();
		System.out.println("Inserimento del numero 5 in lista\n---------------------------------");
		unaListaRandom.insert(5);
		System.out.println("--------------------------------- _____________________________________");
		System.out.println("La ListaRandom è composta di    : " + unaListaRandom.toString());
	}
}
