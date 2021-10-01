package di_interi;

public class ListaOrdinataInteri
{
	// Campi
	NodoLista inizio;
	
	class NodoLista
	{
		Integer ilNumero;
		NodoLista nextNodo;
	}
	
	// Costruttori
	ListaOrdinataInteri()
	{
		this.inizio = null;
	}
	
	// Metodi
	
	void insInt(Integer unIntero)
	{
		NodoLista nuovoNodo = new NodoLista();
		nuovoNodo.ilNumero = unIntero;
		
		NodoLista nodoDopo = new NodoLista();
		nodoDopo = this.inizio;
		
		NodoLista nodoPrima = new NodoLista();
		nodoPrima = null;
		
		while(nodoDopo != null && nodoDopo.ilNumero.compareTo(unIntero) < 0)
		{
			nodoPrima = nodoDopo;
			nodoDopo = nodoDopo.nextNodo;
		}
		
		nuovoNodo.nextNodo = nodoDopo;
		if(nodoPrima == null) this.inizio = nuovoNodo;
		else nodoPrima.nextNodo = nuovoNodo;
	}
	
	private void cancella(Integer numeroDaCancellare)
	{
		if(this.length() == 0)
		{
			// throw new ListaOrdinataInteriException("Eccezione lanciata. Lista vuota.");	// de/commentare per dis/attivare l'eccezione.																// per dis/attivare l'eccezione.
		} else
		{
			NodoLista nodoPrima = new NodoLista();
			nodoPrima = null;
			
			NodoLista nodoDopo = new NodoLista();
			nodoDopo = this.inizio;
			
			
			
			while(nodoDopo != null && nodoDopo.ilNumero.compareTo(numeroDaCancellare) < 0)
			{
				nodoPrima = nodoDopo;
				nodoDopo = nodoDopo.nextNodo;
			}
			
			if(nodoDopo != null && nodoDopo.ilNumero.compareTo(numeroDaCancellare) == 0)
			{
				nodoPrima.nextNodo = nodoDopo.nextNodo;
			}
		}
	}
	
	boolean find(Integer interoDaTrovare)
	{
		if(this.length() == 0)
		{
			// throw new ListaOrdinataInteriException("Eccezione lanciata. Lista vuota.");	// de/commentare una di queste due righe
			return false;																// per dis/attivare l'eccezione.
		} else
		{
			NodoLista nuovoNodo = new NodoLista();
			nuovoNodo = this.inizio;
			
			while(nuovoNodo != null && nuovoNodo.ilNumero.compareTo(interoDaTrovare) < 0)
			{
				nuovoNodo = nuovoNodo.nextNodo;
			}
			
			if(nuovoNodo == null) return false;
			else return true;
		}
	}
	
	private int length()
	{
		int lunghezza = 0;
		NodoLista nuovoNodo = new NodoLista();
		nuovoNodo = this.inizio;
		while(nuovoNodo != null)
		{
			nuovoNodo = nuovoNodo.nextNodo;
			lunghezza++;
		}
		return lunghezza;
	}

	@Override
	public String toString()
	{
		String risultato = "";
		for(NodoLista nuovoNodo = inizio; nuovoNodo != null; nuovoNodo = nuovoNodo.nextNodo)
		{
			risultato = risultato + nuovoNodo.ilNumero + " ";
		}
		return risultato;
	}
	
	// Main
	public static void main(String[] args)
	{
		ListaOrdinataInteri lista1 = new ListaOrdinataInteri();
		System.out.println(lista1.length());
		System.out.println(lista1.find(3));
		
		ListaOrdinataInteri lista2 = new ListaOrdinataInteri();
		lista2.insInt(10);
		lista2.insInt(7);
		lista2.insInt(11);
		lista2.insInt(3);
		lista2.insInt(4);
		System.out.println(lista2.toString());
		lista2.insInt(6);
		System.out.println(lista2.toString());
		
		System.out.println(lista2.find(11));
		
		lista2.cancella(7);
		System.out.println(lista2.toString());
	}
}