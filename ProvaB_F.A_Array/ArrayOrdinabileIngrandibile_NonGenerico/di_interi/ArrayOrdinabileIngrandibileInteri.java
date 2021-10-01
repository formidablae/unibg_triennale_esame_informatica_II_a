package di_interi;

public class ArrayOrdinabileIngrandibileInteri
{

	// CAMPI
	int[] arrayDiInteri;
	int elementiInArray;
	static int dimension;
	
	// COSTRUTTORI
	// Costruttore senza parametro.
	public ArrayOrdinabileIngrandibileInteri()
	{
		arrayDiInteri = new int[10];
		elementiInArray = 0;
		dimension = 10;
	}
	
	// Costruttore con parametro dimensione.
	public ArrayOrdinabileIngrandibileInteri(int dimensione)
	{
		arrayDiInteri = new int[dimensione];
		elementiInArray = 0;
		dimension = dimensione;
	}
	
	// METODI
	// Inserisci
	void inserisci(int interoDaInserire)
	{
		if (elementiInArray == 0)												// Se l'array è vuoto
		{
			arrayDiInteri[0] = interoDaInserire;								// inseririsci direttamente il numero in posizione 0.
			elementiInArray++;													// Incrementa di uno il contatore degli elementi in array.
		} else
		{
			if (elementiInArray == arrayDiInteri.length)						// Se l'array è pieno
			{
					ArrayOrdinabileIngrandibileInteri nuovoArray = new ArrayOrdinabileIngrandibileInteri(dimension * 2);
					
					for(int i = 0; i < elementiInArray; i++)					// Copia gli elementi dell'array piccolo su quello grande.
					{
						nuovoArray.arrayDiInteri[i] = this.arrayDiInteri[i];
					}
					
					this.arrayDiInteri = nuovoArray.arrayDiInteri;				// References il nuovo array grande a this.arrayDiInteri
					//dimension = dimension * 2;									// Dimensione raddoppiata.
					System.out.println("Dimensione raddoppiata. Nuova dimensione: " + dimension);
					
					this.inserisci(interoDaInserire);							// Una volta raddoppiato l'array,
																				// con nuove posizioni vuote,
																				// riprova l'inserimento.
			} else																// Se c'è spazio nell'array
			{
				for (int i = 0; i < elementiInArray; i++)
				{
					if (interoDaInserire < this.arrayDiInteri[i])				// Se il numero da inserire è più piccolo di this.arrayDiInteri[i]
					{
						for (int j = elementiInArray; j > i; j--)				// Sposta a destra di uno 
						{														// tutti gli elementi sulla destra 
							this.arrayDiInteri[j] = this.arrayDiInteri[j - 1];	// di quella posizione.
						}
						this.arrayDiInteri[i] = interoDaInserire;
						i = elementiInArray;
					} else														// Se il numero da inserire è più grande di this.arrayDiInteri[i]
					{
						if (i == elementiInArray - 1)							// e sono arrivato all'ultimo elemento presente nell'array
						{
							this.arrayDiInteri[i + 1] = interoDaInserire;		// metti il numero da inserire sulla destra di tutti gli altri precedenti.
						}
					}
				}
				elementiInArray++;												// Incrementa di uno il contatore degli elementi in array.
			}
		}
	}
	
	String print()
	{
		String result = "";														// Result all'inizio stringa vuota.
		for (int i = 0; i < elementiInArray; i++)
		{
			result = result + this.arrayDiInteri[i] + " ";						// Aggiungi il testo dell'elemento al result.
		}
		for (int i = elementiInArray; i < dimension; i++)						// Inserisci "--" nei posti dove l'array non ha ancora elementi.
			result = result + "--" + " ";
		return result;															// Restituisci il result finale.
	}
	
	// MAIN
	public static void main(String[] args)
	{
		ArrayOrdinabileIngrandibileInteri unArrayInteri = new ArrayOrdinabileIngrandibileInteri();
		System.out.println(" 1° insert in array del 25");
		unArrayInteri.inserisci(25);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();

		System.out.println(" 2° insert in array del 12");
		unArrayInteri.inserisci(12);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println(" 3° insert in array del 66");
		unArrayInteri.inserisci(66);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println(" 4° insert in array del 77");
		unArrayInteri.inserisci(77);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println(" 5° insert in array del 85");
		unArrayInteri.inserisci(85);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println(" 6° insert in array del 36");
		unArrayInteri.inserisci(36);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();

		System.out.println(" 7° insert in array del 61");
		unArrayInteri.inserisci(61);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println(" 8° insert in array del 55");
		unArrayInteri.inserisci(55);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println(" 9° insert in array del 44");
		unArrayInteri.inserisci(44);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("10° insert in array del 60");
		unArrayInteri.inserisci(60);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("Inseriti 10 elementi.");
		System.out.println();
		
		System.out.println("11° insert in array del 89");
		unArrayInteri.inserisci(89);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("12° insert in array del 10");
		unArrayInteri.inserisci(10);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("13° insert in array del 81");
		unArrayInteri.inserisci(81);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("14° insert in array del 26");
		unArrayInteri.inserisci(26);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("15° insert in array del 46");
		unArrayInteri.inserisci(46);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("16° insert in array del 75");
		unArrayInteri.inserisci(75);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();

		System.out.println("17° insert in array del 28");
		unArrayInteri.inserisci(28);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("18° insert in array del 15");
		unArrayInteri.inserisci(15);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("19° insert in array del 84");
		unArrayInteri.inserisci(84);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("20° insert in array del 90");
		unArrayInteri.inserisci(90);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("Inseriti 20 elementi.");
		System.out.println();
		
		System.out.println("21° insert in array del 24");
		unArrayInteri.inserisci(24);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();

		System.out.println("22° insert in array del 11");
		unArrayInteri.inserisci(11);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("23° insert in array del 13");
		unArrayInteri.inserisci(13);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("24° insert in array del 22");
		unArrayInteri.inserisci(22);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("25° insert in array del 99");
		unArrayInteri.inserisci(99);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("26° insert in array del 35");
		unArrayInteri.inserisci(35);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();

		System.out.println("27° insert in array del 62");
		unArrayInteri.inserisci(62);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("28° insert in array del 53");
		unArrayInteri.inserisci(53);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("29° insert in array del 43");
		unArrayInteri.inserisci(43);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("30° insert in array del 70");
		unArrayInteri.inserisci(70);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("Inseriti 30 elementi.");
		System.out.println();
		
		System.out.println("31° insert in array del 96");
		unArrayInteri.inserisci(96);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();

		System.out.println("32° insert in array del 42");
		unArrayInteri.inserisci(42);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("33° insert in array del 16");
		unArrayInteri.inserisci(16);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		
		System.out.println("34° insert in array del 17");
		unArrayInteri.inserisci(17);
		System.out.println("L'array allo stato attuale:  " + unArrayInteri.print());
		System.out.println();
		System.out.println("###########################################################################################################################");
		System.out.println();

		ArrayOrdinabileIngrandibileInteri unAltroArrayInteri = new ArrayOrdinabileIngrandibileInteri(1);
		System.out.println(" 1° insert in array del 25");
		unAltroArrayInteri.inserisci(25);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();

		System.out.println(" 2° insert in array del 12");
		unAltroArrayInteri.inserisci(12);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println(" 3° insert in array del 66");
		unAltroArrayInteri.inserisci(66);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println(" 4° insert in array del 77");
		unAltroArrayInteri.inserisci(77);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println(" 5° insert in array del 85");
		unAltroArrayInteri.inserisci(85);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println(" 6° insert in array del 36");
		unAltroArrayInteri.inserisci(36);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();

		System.out.println(" 7° insert in array del 61");
		unAltroArrayInteri.inserisci(61);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println(" 8° insert in array del 55");
		unAltroArrayInteri.inserisci(55);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println(" 9° insert in array del 44");
		unAltroArrayInteri.inserisci(44);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("10° insert in array del 60");
		unAltroArrayInteri.inserisci(60);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("Inseriti 10 elementi.");
		System.out.println();
		
		System.out.println("11° insert in array del 89");
		unAltroArrayInteri.inserisci(89);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("12° insert in array del 10");
		unAltroArrayInteri.inserisci(10);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("13° insert in array del 81");
		unAltroArrayInteri.inserisci(81);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("14° insert in array del 26");
		unAltroArrayInteri.inserisci(26);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("15° insert in array del 46");
		unAltroArrayInteri.inserisci(46);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("16° insert in array del 75");
		unAltroArrayInteri.inserisci(75);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();

		System.out.println("17° insert in array del 28");
		unAltroArrayInteri.inserisci(28);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("18° insert in array del 15");
		unAltroArrayInteri.inserisci(15);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("19° insert in array del 84");
		unAltroArrayInteri.inserisci(84);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("20° insert in array del 90");
		unAltroArrayInteri.inserisci(90);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("Inseriti 20 elementi.");
		System.out.println();
		
		System.out.println("21° insert in array del 24");
		unAltroArrayInteri.inserisci(24);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();

		System.out.println("22° insert in array del 11");
		unAltroArrayInteri.inserisci(11);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("23° insert in array del 13");
		unAltroArrayInteri.inserisci(13);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("24° insert in array del 22");
		unAltroArrayInteri.inserisci(22);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("25° insert in array del 99");
		unAltroArrayInteri.inserisci(99);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("26° insert in array del 35");
		unAltroArrayInteri.inserisci(35);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();

		System.out.println("27° insert in array del 62");
		unAltroArrayInteri.inserisci(62);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
		
		System.out.println("28° insert in array del 53");
		unAltroArrayInteri.inserisci(53);
		System.out.println("L'array allo stato attuale:  " + unAltroArrayInteri.print());
		System.out.println();
	}
}