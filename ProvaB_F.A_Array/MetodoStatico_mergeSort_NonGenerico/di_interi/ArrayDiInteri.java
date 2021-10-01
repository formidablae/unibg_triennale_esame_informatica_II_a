package di_interi;

public class ArrayDiInteri
{
	// Media.
	public static int mediaInteriArray(int[] arrayDiInteri)
	{
		int sommaTotale = 0;
		for (int i = 0; i < arrayDiInteri.length; i++)
		{
			sommaTotale = sommaTotale + arrayDiInteri[i];
		}
		return sommaTotale/arrayDiInteri.length;
	}
	
	// Massimo senza sort.
	public static int maxInteriArray(int[] arrayDiInteri) // return -999 per array vuoto.
	{
		int interoMax;
		if (arrayDiInteri.length == 0 || arrayDiInteri == null)
		{
			interoMax = -999;
		} else
		{
			interoMax = arrayDiInteri[0];
			for (int i = 1; i < arrayDiInteri.length; i++)
			{
				if (interoMax < arrayDiInteri[i])
				{
					interoMax = arrayDiInteri[i];
				}
			}
		}
		return interoMax;
	}
	
	// Mediana tramite iniziale sort dell'array.
	public static int medianaInteriArray(int[] arrayDiInteri)
	{
		if (arrayDiInteri.length == 0 || arrayDiInteri == null) // return -999 se arrayDiInteri null o di lunghezza 0.
		{
			return -999;
		} else if (arrayDiInteri.length == 1)
		{
			return arrayDiInteri[0];
		} else
		{
			mergeSort(arrayDiInteri);			// De-commentare una di queste due
			// bubbleSort(arrayDiInteri);		// righe per usare mergeSort o bubbleSort.
			if (arrayDiInteri.length % 2 != 0)	// Se array di lunghezza dispari,
			{									// mediana è l'elemento in mezzo dell'array ordinato
				return arrayDiInteri[(arrayDiInteri.length / 2) + 1];
			} else								// Se array di lunghezza pari,
			{									// mediana è la media dei due elementi in mezzo dell'array ordinato
				return (arrayDiInteri[(arrayDiInteri.length / 2) - 1] + arrayDiInteri[(arrayDiInteri.length / 2)]) / 2;
			}
		}
	}
	
	// mergeSort algorithm.
	public static void mergeSort(int[] arrayDiInteri)
	{
		if (arrayDiInteri.length > 1)
		{
			int mezzo = arrayDiInteri.length / 2;
			
			// Costruisci un array corrispondente alla prima metà dell'arrayDiInteri
			int[] primaMeta = new int[mezzo];
			for (int i = 0; i < mezzo; i++)
			{
				primaMeta[i] = arrayDiInteri[i];
			}
			
			// Costruisci un array corrispondente alla seconda metà dell'arrayDiInteri
			int[] secondaMeta = new int[arrayDiInteri.length - mezzo];
			for (int i = mezzo; i < arrayDiInteri.length; i++)
			{
				secondaMeta[i - mezzo] = arrayDiInteri[i];
			}
			
			// Ordina ricorsivamente le due metà array ottenute.
			mergeSort(primaMeta);
			mergeSort(secondaMeta);

			// Fondi i due metà array.
			int posizioneIndicePrimaMeta = 0;
			int posizioneIndiceSecondaMeta = 0;
			
			for (int i = 0; i < arrayDiInteri.length; i++)
			{
				if (posizioneIndiceSecondaMeta == secondaMeta.length ||
					posizioneIndicePrimaMeta < primaMeta.length &&
					primaMeta[posizioneIndicePrimaMeta] < secondaMeta[posizioneIndiceSecondaMeta])
				{
					arrayDiInteri[i] = primaMeta[posizioneIndicePrimaMeta];
					posizioneIndicePrimaMeta++;
				} else
				{
					arrayDiInteri[i] = secondaMeta[posizioneIndiceSecondaMeta];
					posizioneIndiceSecondaMeta++;
				}
			}
		} // else l'array di un elemento è già ordinato.
	}
	
	// bubbleSort algorithm.
	public static void bubbleSort(int[] arrayDiInteri)
	{
		int temporaneo;
		boolean scambiato;
		do
		{
			scambiato = false;
			for (int i = 1; i < arrayDiInteri.length; i++)
			{
				if (arrayDiInteri[i - 1] > arrayDiInteri[i])
				{
					temporaneo = arrayDiInteri[i - 1];
					arrayDiInteri[i - 1] = arrayDiInteri[i];
					arrayDiInteri[i] = temporaneo;
					scambiato = true;
				}
			}
		} while (scambiato);
	}
	
	// Stampa array.
	public static String arrayToString(int[] arrayDiInteri)
	{
		String result = "";
		for (int element : arrayDiInteri) {
			if (element < 10 && element >= 0)			// ad una cifra.
			{
				result = result + "  " + String.valueOf(element) + " ";
			} else if (element < 100 && element >= -10)	// a due cifre.
			{
				result = result + " " + String.valueOf(element) + " ";
			} else										// a tre cifre.
			{
				result = result + String.valueOf(element) + " ";
			}
		}
		return result;
	}
	
	// Main.
	public static void main(String[] args)
	{
		int[] arrayDiProva = {32,  3, 15, 22, 49, 50, 14, 99, 64, 66,
							   2, 40, 59, 12, 34,  8, 76, 43,  6};
		
		System.out.println("Media:   " + mediaInteriArray(arrayDiProva));
		System.out.println("Massimo: " + maxInteriArray(arrayDiProva));
		System.out.println("Mediana: " + medianaInteriArray(arrayDiProva));
		
		int[] altroArrayDiProva = {22,  1, 35, 12, 39, 40,  4, 89, 74, 76,
				                   12, 30, 49,  2, 24, 18, 66, 33, 16};
		System.out.println("Array prima: " + arrayToString(altroArrayDiProva));
		mergeSort(altroArrayDiProva);
		System.out.println("Array dopo:  " + arrayToString(altroArrayDiProva));
		
		int[] otherArrayDiProva = {23,  3, 51, 22, 94,  5, 41, 29, 46, 76,
				                   20,  4, 95, 21, 43, 80, 67, 34, 62, 88};
		System.out.println("Array prima: " + arrayToString(otherArrayDiProva));
		bubbleSort(otherArrayDiProva);
		System.out.println("Array dopo:  " + arrayToString(otherArrayDiProva));		
	}
}
