package di_automobili;

class Automobile
{
	// CAMPI
	String targa;
	
	// COSTRUTTORI
	Automobile()
	{
		targa = null;
	}
	
	Automobile(String laTarga)
	{
		targa = laTarga;
	}
	
	// METODI
	// Stampa
	public String toString()
	{
		return targa;
	}
	
	// compareTo
	public int compareTo(Automobile altraAuto)
	{
		if (this.targa.compareTo(altraAuto.targa) < 0) return -1;
		else if (this.targa.compareTo(altraAuto.targa) > 0) return 1;
		else return 0;
	}
}


public class MergeSortAutomobili
{
	// CAMPI
	
	// COSTRUTTORI

	// METODI
	
	// METODI STATICI
	// mergeSort
	static void mergeSort(Automobile[] arrayDiAuto)
	{
		if (arrayDiAuto.length > 1)
		{
			// Splitting dell'array originale in due metà
			// Creazione delle due metà
			Automobile[] metaSinistra = new Automobile[arrayDiAuto.length / 2];
			Automobile[] metaDestra = new Automobile[arrayDiAuto.length - metaSinistra.length];
			
			// Copia dei valori dell'array originale nelle due metà
			for (int i = 0; i < arrayDiAuto.length; i++)
			{
				if (i < metaSinistra.length)
				{
					metaSinistra[i] = arrayDiAuto[i];
				} else
				{
					metaDestra[i - metaSinistra.length] = arrayDiAuto[i];
				}
			}
			
			// Ordina i due array ricorsivamente.
			mergeSort(metaSinistra);
			mergeSort(metaDestra);
			
			// Fusione dei due array in una in ordine.
			int posSx = 0;
			int posDx = 0;
			
			for (int i = 0; i < arrayDiAuto.length; i++)
			{
				// Metti in arrayDiAuto[i] il minimo tra metaSinistra[posSx] e metaDestra[posDx].
				if (posDx == metaDestra.length || posSx < metaSinistra.length && metaSinistra[posSx].compareTo(metaDestra[posDx]) < 0)
				{
					arrayDiAuto[i] = metaSinistra[posSx];
					posSx++;
				} else
				{
					arrayDiAuto[i] = metaDestra[posDx];
					posDx++;
				}
			}
		} 	// else non fare nulla. L'array è già in ordine.
	}
	
	public static void main(String[] args)
	{
		Automobile[] arrayDiAuto = {
									new Automobile("EF567GH"),
									new Automobile("IJ012KL"),
									new Automobile("AB123CD"),
									new Automobile("BD234DE"),
									new Automobile("FG678HI"),
									new Automobile("GH789IJ"),
									new Automobile("HI901JK"),
									new Automobile("CD345EF"),
									new Automobile("DE456FG")
														     };
		
		String stampaArray = "";
		for (int i = 0; i < arrayDiAuto.length; i++)
		{
			stampaArray = stampaArray + arrayDiAuto[i].targa + " ";
		}
		System.out.println("L'array allo stato disordinato: " + stampaArray);
		
		System.out.println("Metto in ordine le auto nell'array");
		mergeSort(arrayDiAuto);
		
		stampaArray = "";
		for (int i = 0; i < arrayDiAuto.length; i++)
		{
			stampaArray = stampaArray + arrayDiAuto[i].targa + " ";
		}
		System.out.println("L'array dopo il averla sortata: " + stampaArray);
		
	}
}
