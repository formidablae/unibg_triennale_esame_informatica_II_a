package insieme_di_automobili;

class Automobile implements Comparable<Automobile>
{
	// CAMPI
	String targa;
	
	// COSTRUTTORE
	Automobile()
	{
		targa = null;
	}
	
	Automobile(String stringTarga)
	{
		targa = stringTarga;
	}
	
	// METODI
	void drive()
	{
		
	}
	
	public int compareTo(Automobile unAltraAuto)
	{
		if (this.targa.compareTo(unAltraAuto.targa) < 0) return -1;
		else if (this.targa.compareTo(unAltraAuto.targa) > 0) return 1;
		else return 0;
	}
	
	public String toString()
	{
		return targa;
	}
}

class AlberoDiRicerca<T extends Comparable<T>>
{
	// CAMPI
	NodoAlbero nodo;
	
	class NodoAlbero
	{
		T dato;
		AlberoDiRicerca<T> sottoAlberoSinistro;
		AlberoDiRicerca<T> sottoAlberoDestro;
		
		NodoAlbero()
		{
			dato = null;
			sottoAlberoSinistro = null;
			sottoAlberoDestro = null;
		}
	}
	
	// COSTRUTTORI
	
	AlberoDiRicerca()
	{
		nodo = null;
	}
	
	// METODI
	// Insert
	void insert(T oggetto)
	{
		NodoAlbero nuovoNodo = new NodoAlbero();
		nuovoNodo.dato = oggetto;
		nuovoNodo.sottoAlberoSinistro = new AlberoDiRicerca<T>();
		nuovoNodo.sottoAlberoDestro = new AlberoDiRicerca<T>();
		
		if (this.nodo == null)
		{
			this.nodo = nuovoNodo;
		} else
		{
			if (nuovoNodo.dato.compareTo(this.nodo.dato) < 0)
			{
				this.nodo.sottoAlberoSinistro.insert(oggetto);
			} else
			{
				this.nodo.sottoAlberoDestro.insert(oggetto);
			}
		}
	}
	
	// Find
	boolean find(T oggetto)
	{
		NodoAlbero nodoDaCercare = new NodoAlbero();
		nodoDaCercare.dato = oggetto;
		
		if (this.nodo == null)
		{
			return false;
		} else
		{
			System.out.println("Arriva qui");
			if (nodoDaCercare.dato.compareTo(this.nodo.dato) == 0)
			{
				return true;
			} else if(nodoDaCercare.dato.compareTo(this.nodo.dato) < 0)
			{
				System.out.println("Anche qui");
				return this.nodo.sottoAlberoSinistro.find(oggetto);
			} else
			{
				return this.nodo.sottoAlberoSinistro.find(oggetto);
			}
		}
	}
	
	// Stampa
	String print()
	{
		if (this.nodo != null)
		{
			String sinistra = this.nodo.sottoAlberoSinistro.print();
			String centro = this.nodo.dato + " ";
			String destra = this.nodo.sottoAlberoDestro.print();
			return sinistra + centro + destra;
		} else
		{
			return "";
		}
	}
}

public class AlberoDiRicercaGenerico
{
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public static void main(String[] args)
	{
		AlberoDiRicerca unAlberoDiAuto = new AlberoDiRicerca();
		Automobile autoA = new Automobile("AB123CD");
		Automobile autoD = new Automobile("DE456FG");

		System.out.println("Cerco l'auto D tagata DE456FG");
		System.out.println("L'auto è presente in lista? " + unAlberoDiAuto.find(autoD));
		System.out.println();
		
		System.out.println("Inserisco l'auto A tagata AB123CD");
		unAlberoDiAuto.insert(autoA);
		System.out.println("Stato attuale dell'albero: " + unAlberoDiAuto.print());
		System.out.println();
		
		Automobile autoC = new Automobile("CD345EF");

		System.out.println("Inserisco l'auto C tagata CD345EF");
		unAlberoDiAuto.insert(autoC);
		System.out.println("Stato attuale dell'albero: " + unAlberoDiAuto.print());
		System.out.println();
		
		Automobile autoB = new Automobile("BC234DE");
		
		System.out.println("Inserisco l'auto B tagata BC234DE");
		unAlberoDiAuto.insert(autoB);
		System.out.println("Stato attuale dell'albero: " + unAlberoDiAuto.print());
		System.out.println();
		
		Automobile autoG = new Automobile("GH789IJ");

		System.out.println("Inserisco l'auto G tagata GH789IJ");
		unAlberoDiAuto.insert(autoG);
		System.out.println("Stato attuale dell'albero: " + unAlberoDiAuto.print());
		System.out.println();
		
		Automobile autoF = new Automobile("FG678HI");
		
		System.out.println("Inserisco l'auto F tagata FG678HI");
		unAlberoDiAuto.insert(autoF);
		System.out.println("Stato attuale dell'albero: " + unAlberoDiAuto.print());
		System.out.println();
		
		
		System.out.println("Cerco l'auto tagata CD345EF");
		System.out.println("L'auto è presente in lista? " + unAlberoDiAuto.find(autoC));
		
		System.out.println();

		System.out.println("Cerco l'auto tagata DE456FG");
		System.out.println("L'auto è presente in lista? " + unAlberoDiAuto.find(autoD));
	}
}