public class MioArray<E extends Comparable<E>>
{
	// CAMPI
	E[] ilMioArray;
	
	// COSTRUTTORI
	public MioArray()
	{
		ilMioArray = (E[]) new Object[10];
	}
	
	public MioArray(int dimensione)
	{
		ilMioArray = (E[]) new Object[dimensione];
	}
	
	// METODI
	// Inserisci
	/*void inserisci(E elementoDaInserire)
	{
		if (ilMioArray[0] == null)
		{
			ilMioArray[0] = elementoDaInserire;
		} else
		{
			if (ilMioArray[ilMioArray.length - 1] != null)			// Se l'array è pieno
			{
				this.ilMioArray = new MioArray(this.ilMioArray.length * 2);
			} else
			{
				for (int i = 0; i < ilMioArray.length; i++)
				{
					
				}
			}
		}
	}
	
	String print()
	{
		
	}
	
	// METODI STATICI
	
	// MAIN
	public static void main(String[] args)
	{
		MioArray unArrayOrdinabile = new MioArray();
		unArrayOrdinabile.inserisci(25);
		System.out.println(unArrayOrdinabile.print());
	}*/
}