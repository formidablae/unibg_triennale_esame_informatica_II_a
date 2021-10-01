package orderedfruitlist;

/**
 * Collezione di frutti con nome e quantità
 * elencati in ordine decrescente di quantità.
 * 
 * @author 
 *
 */
public class OrderedListFruit
{
	// Campi
	NodoLista inizio;
	
	class NodoLista
	{
		Fruit theFruit;
		NodoLista prossimo;
	}
	
	// Costruttori
	OrderedListFruit()
	{
		inizio = null;
	}
	
	// Metodi
	void insFruit(Fruit frutto)
	{
		NodoLista p = inizio;
		NodoLista q = null;
		NodoLista r = new NodoLista();
		r.theFruit = frutto;
		
		while(p != null && p.theFruit.compareTo(frutto) < 0)
		{
			q = p;
			p = p.prossimo;
		}
		r.prossimo = p;
		if(q == null) inizio = r;
		else q.prossimo = r;
	}
	
	void cancella(Fruit frutto)
	{
		NodoLista p = inizio;
		NodoLista q = null;
		while(p != null && p.theFruit.compareTo(frutto) < 0)
		{
			q = p;
			p = p.prossimo;
		}
		
		if(p != null && p.theFruit.compareTo(frutto) == 0)
		{
			if(q == null) inizio = inizio.prossimo;
			else q.prossimo = p.prossimo;
		}
	}
	
	boolean find(String nomeDiUnFrutto) throws OrderedListFruitException
	{
		if(this.length() == 0)
		{
			// throw new OrderedListFruitException("Eccezione lanciata. Lista vuota.");	// de/commentare una di queste due righe
			return false;																// per dis/attivare l'eccezione.
		} else
		{
			NodoLista p = this.inizio;
			while(p != null && !((p.theFruit.fruitName.equals(nomeDiUnFrutto))))
			{
				p = p.prossimo;
			}
			if(p == null) return false;
			else return true;
		}
	}
	
	int length()
	{
		int lunghezza = 0;
		NodoLista p = this.inizio;
		while(p != null)
		{
			p = p.prossimo;
			lunghezza++;
		}
		return lunghezza;
	}
	
	public String toString()
	{
		String risultato = "";
		for(NodoLista p = inizio; p!=null; p = p.prossimo)
		{
			risultato = risultato + p.theFruit.toString();
			risultato = risultato + "\n";
		}
		return risultato;
	}
	
	// Il main
	public static void main(String[] args)
	{
		OrderedListFruit lista1 = new OrderedListFruit();
		System.out.println(lista1.length());
		System.out.println(lista1.find("banane"));
		
		OrderedListFruit lista2 = new OrderedListFruit();
		lista2.insFruit(new Fruit("banane", 10));
		lista2.insFruit(new Fruit("arance", 20));
		System.out.println(lista2.toString());
		Fruit fruttoK = new Fruit("kiwi", 15);
		lista2.insFruit(fruttoK);
		System.out.println(lista2.find("arance"));
		System.out.println(lista2.toString());
		
		lista2.cancella(fruttoK);
		System.out.println(lista2.toString());
	}
}

class Fruit implements Comparable<Fruit>
{
	// Campi
	String fruitName;
	int quantity;
	
	// Costruttori
	public Fruit(String fruitName, int quantity)
	{
		this.fruitName = fruitName;
		this.quantity = quantity;
	}
	
	// Metodi
	@Override
	public String toString()
	{
		return this.fruitName + " " + this.quantity;
	}
	
	public int compareTo(Fruit compareFruit)
	{
		return quantity - this.quantity;
	}
}
