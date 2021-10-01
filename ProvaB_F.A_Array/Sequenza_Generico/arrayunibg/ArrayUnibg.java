package arrayunibg;

@SuppressWarnings("unchecked")
public class ArrayUnibg<T>
{
	// CAMPI
	T[] lArrayUnibg;
	final int N;
	static int elementiInseriti = 0;
	
	// COSTRUTTORI
	ArrayUnibg()
	{
		this(10);
	}
	
	ArrayUnibg(int dimensione)
	{
		N = dimensione;
		lArrayUnibg = (T[]) new Object[N];
	}
	
	// METODI
	void inserisci(T oggetto)
	{
		try
		{
			this.lArrayUnibg[elementiInseriti] = oggetto;
			elementiInseriti++;
		} catch (Exception e)
		{
			System.out.println("Eccezione catturata. Indice fuori dal range.");
		}
	}
	
	// MAIN
	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{
		ArrayUnibg arrayUnibg = new ArrayUnibg();
		System.out.println("PROVE CON INTERI.");
		System.out.println("Inserisco un numero.");
		arrayUnibg.inserisci(5);
		System.out.println("Inserisco un numero.");
		arrayUnibg.inserisci(3);
		System.out.println("Inserisco un numero.");
		arrayUnibg.inserisci(2);
		System.out.println("Inserisco un numero.");
		arrayUnibg.inserisci(6);
		System.out.println("Inserisco un numero.");
		arrayUnibg.inserisci(4);
		System.out.println("Inserisco un numero.");
		arrayUnibg.inserisci(7);
		System.out.println("Inserisco un numero.");
		arrayUnibg.inserisci(9);
		//System.out.println("Inserisco un numero.");
		//arrayUnibg.inserisci(10);
		//System.out.println("Inserisco un numero.");
		//arrayUnibg.inserisci(14);
		//System.out.println("Inserisco un numero.");
		//arrayUnibg.inserisci(1);
		//System.out.println("Inserisco un numero.");
		//arrayUnibg.inserisci(8);
		System.out.println("PROVE CON STRINGHE.");
		System.out.println("Inserisco una stringa.");
		arrayUnibg.inserisci("sedia");
		System.out.println("Inserisco una stringa.");
		arrayUnibg.inserisci("tavolo");
		System.out.println("Inserisco una stringa.");
		arrayUnibg.inserisci("libro");
		System.out.println("Inserisco una stringa.");
		arrayUnibg.inserisci("pc");
		System.out.println("Inserisco una stringa.");
		arrayUnibg.inserisci(4);
		System.out.println("Inserisco una stringa.");
		arrayUnibg.inserisci(7);
		System.out.println("Inserisco una stringa.");
		arrayUnibg.inserisci(9);
		System.out.println("Inserisco una stringa.");
		arrayUnibg.inserisci(10);
		System.out.println("Inserisco una stringa.");
		arrayUnibg.inserisci(14);
		System.out.println("Inserisco una stringa.");
		arrayUnibg.inserisci(1);
		System.out.println("Inserisco una stringa.");
		arrayUnibg.inserisci(8);
	}
	
}