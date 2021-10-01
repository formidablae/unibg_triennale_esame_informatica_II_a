package di_double;

public class MergeSorterDouble
{
	// mergeSort in ordine crescente per array di double
	public static void mergeSort(double[] arrayDiDouble)
	{
		if (arrayDiDouble.length > 1)
		{
			int mezzo = arrayDiDouble.length / 2;
			double[] primaMeta = new double[mezzo];
			double[] secondaMeta = new double[arrayDiDouble.length - mezzo];
			
			// Split dell'array in due metà.
			for (int i = 0; i < arrayDiDouble.length; i++)
			{
				if (i < mezzo)
				{
					primaMeta[i] = arrayDiDouble[i];
				} else
				{
					secondaMeta[i - mezzo] = arrayDiDouble[i];
				}
			}
			
			// Split, sort e fusione ricorsiva.
			mergeSort(primaMeta);
			mergeSort(secondaMeta);
			
			// La fusione delle metà in un unico array finale.
			int posizionePrimaMeta = 0;
			int posizioneSecondaMeta = 0;
			
			for (int i = 0; i < arrayDiDouble.length; i++)
			{
			if (posizioneSecondaMeta == secondaMeta.length || posizionePrimaMeta < primaMeta.length && primaMeta[posizionePrimaMeta] < secondaMeta[posizioneSecondaMeta])
				{
					arrayDiDouble[i] = primaMeta[posizionePrimaMeta];
					posizionePrimaMeta++;
				} else
				{
					arrayDiDouble[i] = secondaMeta[posizioneSecondaMeta];
					posizioneSecondaMeta++;
				}
			}
		} // else l'array è già ordinato perché di dimensione 1 o 0.
	}
	
	// mergeSort in ordine decrescente per array di double
	public static void mergeSortDecrescente(double[] arrayDiDouble)
	{
		if (arrayDiDouble.length > 1)
		{
			int mezzo = arrayDiDouble.length / 2;
			double[] primaMeta = new double[mezzo];
			double[] secondaMeta = new double[arrayDiDouble.length - mezzo];
			
			// Split dell'array in due metà.
			for (int i = 0; i < arrayDiDouble.length; i++)
			{
				if (i < mezzo)
				{
					primaMeta[i] = arrayDiDouble[i];
				} else
				{
					secondaMeta[i - mezzo] = arrayDiDouble[i];
				}
			}
			
			// Split, sort e fusione ricorsiva.
			mergeSortDecrescente(primaMeta);
			mergeSortDecrescente(secondaMeta);
			
			// La fusione delle metà in un unico array finale.
			int posizionePrimaMeta = 0;
			int posizioneSecondaMeta = 0;
			
			for (int i = 0; i < arrayDiDouble.length; i++)
			{
			if (posizioneSecondaMeta == secondaMeta.length || posizionePrimaMeta < primaMeta.length && primaMeta[posizionePrimaMeta] > secondaMeta[posizioneSecondaMeta])
				{
					arrayDiDouble[i] = primaMeta[posizionePrimaMeta];
					posizionePrimaMeta++;
				} else
				{
					arrayDiDouble[i] = secondaMeta[posizioneSecondaMeta];
					posizioneSecondaMeta++;
				}
			}
		} // else l'array è già ordinato perché di dimensione 1 o 0.
	}
	
	// Invertitore di array
	public static void invertArray(double[] arrayDiDouble)
	{
		double temporaneo;
		for(int i = 0; i < arrayDiDouble.length / 2; i++)
		{
			temporaneo = arrayDiDouble[i];
			arrayDiDouble[i] = arrayDiDouble[arrayDiDouble.length - i - 1];
			arrayDiDouble[arrayDiDouble.length - i - 1] = temporaneo;
		}
	}
	
	// Stampa array
	public static String arrayDoubleToString(double[] arrayDiDouble)
	{
		String result = "";
		for (int i = 0; i < arrayDiDouble.length; i++)
		{
			result = result + arrayDiDouble[i] + "  ";
		}
		return result;
	}
	
	// Main
	public static void main(String[] args)
	{
		double[] arrayDiProvaConDouble = { 0.2, 0.7, 2.6, 9.1, 3.2, 6.4, 3.4, 5.8, 4.9, 7.3};
		System.out.println("Array iniziale come inserita senza sorting: " + arrayDoubleToString(arrayDiProvaConDouble));
		MergeSorterDouble.mergeSort(arrayDiProvaConDouble);
		System.out.println("Array ordinata crescente con mergeSort:     " + arrayDoubleToString(arrayDiProvaConDouble));
		MergeSorterDouble.invertArray(arrayDiProvaConDouble);
		System.out.println("Array ordinata crescente poi invertita:     " + arrayDoubleToString(arrayDiProvaConDouble));
		MergeSorterDouble.mergeSortDecrescente(arrayDiProvaConDouble);
		System.out.println("Array decrescente con mergeSortDecrescente: " + arrayDoubleToString(arrayDiProvaConDouble));
	}
}
