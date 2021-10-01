package di_stringhe;

import java.util.ArrayList;

public class SortArrayListStringhe
{
	public static void main(String[] args)
	{
		
		// CAMPI
		ArrayList<String> lArrayDiStrighe = new ArrayList<String>();
		lArrayDiStrighe.add("Testo1");
		lArrayDiStrighe.add("Testo3");
		lArrayDiStrighe.add("Testo7");
		lArrayDiStrighe.add("Testo4");
		lArrayDiStrighe.add("Testo2");
		lArrayDiStrighe.add("Testo9");
		System.out.print("L'array:         ");
		for (String s : lArrayDiStrighe)
		{
			System.out.print(s + " ");
		}
		sortList(lArrayDiStrighe);
		System.out.print("\nL'array sortata: ");
		for (String s : lArrayDiStrighe)
		{
			System.out.print(s + " ");
		}
		
		// COSTRUTTORI
		
		// METODI
		
		// METODI STATICI
		// sortList ordinamento con bubblesort
	}
	
	static void sortList(ArrayList<String> lArrayDaOrdinare)
	{
		boolean scambiato;
		do
		{
			scambiato = false;
			for (int i = 1; i < lArrayDaOrdinare.size(); i++)
			{
				if (lArrayDaOrdinare.get(i - 1).compareTo(lArrayDaOrdinare.get(i)) > 0)
				{
					String temp = lArrayDaOrdinare.get(i);
					lArrayDaOrdinare.set(i, lArrayDaOrdinare.get(i - 1));
					lArrayDaOrdinare.set(i - 1, temp);
					scambiato = true;
				}
			}
		}
		while (scambiato);
	}
}
