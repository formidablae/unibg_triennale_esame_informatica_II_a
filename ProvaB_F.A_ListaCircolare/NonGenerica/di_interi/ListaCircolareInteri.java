package di_interi;

public class ListaCircolareInteri
{
	// Campi
	NodoListaCircolare primo;
	NodoListaCircolare ultimo;
	
	class NodoListaCircolare
	{
		int dato;
		NodoListaCircolare nextNodo;
	}
	
	// Costruttori
	ListaCircolareInteri()
	{
		primo = null;
		ultimo = null;
	}
	
	// Metodi
	
	// Inserimento in coda
	void inserimentoInCoda(int numeroDaInserireInCoda)
	{
		NodoListaCircolare nuovoNodo = new NodoListaCircolare();
		nuovoNodo.dato = numeroDaInserireInCoda;
		
		if (primo == null)				// lista vuota
		{
			ultimo = nuovoNodo;
			primo = nuovoNodo;
			ultimo.nextNodo = primo;
			nuovoNodo.nextNodo = primo;
		} else							// lista con 1 o più elementi
		{
			ultimo.nextNodo = nuovoNodo;
			nuovoNodo.nextNodo = primo;
			ultimo = nuovoNodo;
		}
	}
	
	// Inserimento in testa
	void inserimentoInTesta(int numeroDaInserireInTesta)
	{
		NodoListaCircolare nuovoNodo = new NodoListaCircolare();
		nuovoNodo.dato = numeroDaInserireInTesta;
		
		if (primo == null)				// lista vuota
		{
			ultimo = nuovoNodo;
			primo = nuovoNodo;
			ultimo.nextNodo = primo;
			nuovoNodo.nextNodo = primo;
		} else							// lista con 1 o più elementi
		{
			nuovoNodo.nextNodo = primo;
			primo = nuovoNodo;
			ultimo.nextNodo = primo;
		}
	}
	
	// Ricerca se l'intero è presente in lista 
	boolean ricerca(int interoDaCercare)
	{
		boolean trovato = false;
		if (primo == null)
		{
			trovato = false;
		} else
		{
			NodoListaCircolare temporaneo = primo;
			do
			{
				if (interoDaCercare == temporaneo.dato)
				{
					trovato = true;
				} else
				{
					temporaneo = temporaneo.nextNodo;
				}
				
			} while (!trovato && temporaneo != primo);
		}
		return trovato;
	}
	
	// Stampa la lista
	String stampa()
	{
		String result = "";
		if (primo == null)
		{
			result = "";
		} else
		{
			NodoListaCircolare temporaneo = primo;
			do
			{
				result = result + temporaneo.dato + " ";
				temporaneo = temporaneo.nextNodo;
			} while (temporaneo != primo);
		}
		return result;
	}
	
	// Main
	public static void main(String[] args)
	{
		ListaCircolareInteri unaListaCircolareDiInteri = new ListaCircolareInteri();
		unaListaCircolareDiInteri.inserimentoInCoda(3);
		unaListaCircolareDiInteri.inserimentoInCoda(7);
		unaListaCircolareDiInteri.inserimentoInCoda(2);
		unaListaCircolareDiInteri.inserimentoInCoda(6);
		unaListaCircolareDiInteri.inserimentoInCoda(9);
		unaListaCircolareDiInteri.inserimentoInCoda(0);
		unaListaCircolareDiInteri.inserimentoInCoda(5);
		unaListaCircolareDiInteri.inserimentoInCoda(1);
		unaListaCircolareDiInteri.inserimentoInCoda(4);
		System.out.println("Lista con i numeri inseriti in coda:\n" + unaListaCircolareDiInteri.stampa());
		System.out.println();
		unaListaCircolareDiInteri.inserimentoInTesta(23);
		unaListaCircolareDiInteri.inserimentoInTesta(37);
		unaListaCircolareDiInteri.inserimentoInTesta(92);
		unaListaCircolareDiInteri.inserimentoInTesta(56);
		unaListaCircolareDiInteri.inserimentoInTesta(79);
		unaListaCircolareDiInteri.inserimentoInTesta(60);
		unaListaCircolareDiInteri.inserimentoInTesta(55);
		unaListaCircolareDiInteri.inserimentoInTesta(31);
		unaListaCircolareDiInteri.inserimentoInTesta(64);
		System.out.println("La lista precedente con altri numeri inseriti in testa:\n" + unaListaCircolareDiInteri.stampa());
		System.out.println();
		System.out.println("Ricerca di presenza del  4: " + unaListaCircolareDiInteri.ricerca(4));
		System.out.println("Ricerca di presenza del 10: " + unaListaCircolareDiInteri.ricerca(10));
		System.out.println("Ricerca di presenza del 26: " + unaListaCircolareDiInteri.ricerca(26));
		System.out.println("Ricerca di presenza del 31: " + unaListaCircolareDiInteri.ricerca(31));
	}
}