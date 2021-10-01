package di_interi;

import java.util.Arrays;

public class RicercaDicotomicaDiInteri
{
	public static void main(String[] args)
	{
		int[] unArrayOrdinatoDiInteri = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("L'array è " + Arrays.toString(unArrayOrdinatoDiInteri));
		System.out.println("Il 4 si trova in posizione: " + ricercaNormale(unArrayOrdinatoDiInteri, 4));
		System.out.println("Il 4 si trova in posizione: " + ricercaDicotomica(unArrayOrdinatoDiInteri, 4));
	}
	
	static int ricercaNormale(int[] arrayDiInteri, int intero)
	{
		int result = -1;
		for (int i = 0; i < arrayDiInteri.length; i++)
		{
			if (arrayDiInteri[i] == intero)
			{
				result = i;
				break;
			}
		}
		return result;
	}
	
	static int ricercaDicotomica(int[] arrayDiInteri, int intero)
	{
		int posizioneSx = 0;
		int posizioneDx = arrayDiInteri.length - 1;
		int meta;
		
		while (posizioneSx < posizioneDx)
		{
			meta = (posizioneSx + posizioneDx) / 2;
			
			if (intero < arrayDiInteri[meta]) posizioneDx = meta - 1;
			else if (intero > arrayDiInteri[meta]) posizioneSx = meta + 1;
			else posizioneSx = posizioneDx = meta;
		}
		
		if (intero == arrayDiInteri[posizioneSx]) return posizioneSx;
		else return -1;
	}
}
