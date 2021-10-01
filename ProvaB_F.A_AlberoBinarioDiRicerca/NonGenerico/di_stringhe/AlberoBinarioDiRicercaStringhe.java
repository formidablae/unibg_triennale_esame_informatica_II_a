package di_stringhe;

import java.util.StringTokenizer;

public class AlberoBinarioDiRicercaStringhe<String extends Comparable<? super String>>
{
	// Campi
	NodoAlbero nodoAlbero;
	
	class NodoAlbero
	{
		String contenutoRadice;
		AlberoBinarioDiRicercaStringhe<String> sottoAlberoSinistro;
		AlberoBinarioDiRicercaStringhe<String> sottoAlberoDestro;
	}
	
	// Costruttore
	AlberoBinarioDiRicercaStringhe()
	{
		nodoAlbero = null;
	}
	
	// Metodi
	void inserisci(String stringaDaInserire)
	{
		if (nodoAlbero == null)
		{
			nodoAlbero = new NodoAlbero();
			nodoAlbero.contenutoRadice = stringaDaInserire;
			nodoAlbero.sottoAlberoSinistro = new AlberoBinarioDiRicercaStringhe<String>();
			nodoAlbero.sottoAlberoDestro = new AlberoBinarioDiRicercaStringhe<String>();
		} else if (stringaDaInserire.compareTo(nodoAlbero.contenutoRadice) < 0)
		{
			nodoAlbero.sottoAlberoSinistro.inserisci(stringaDaInserire);
		} else nodoAlbero.sottoAlberoDestro.inserisci(stringaDaInserire);
	}
	
	boolean trova(String stringaDaTrovare)
	{
		boolean result = false;
		if (nodoAlbero == null)
		{
			result = false;
		} else if (stringaDaTrovare.compareTo(nodoAlbero.contenutoRadice) == 0)
		{
			result = true;
		} else if (stringaDaTrovare.compareTo(nodoAlbero.contenutoRadice) < 0)
		{
			result = nodoAlbero.sottoAlberoSinistro.trova(stringaDaTrovare);
		} else if (stringaDaTrovare.compareTo(nodoAlbero.contenutoRadice) > 0)
		{
			result = nodoAlbero.sottoAlberoDestro.trova(stringaDaTrovare);
		}
		return result;
	}
	
	int trovaLivello(String stringaDaTrovare) // livello 0 vuol dire stringa non trovata.
	{
		int livello = 0;
		if (nodoAlbero == null)
		{
			livello = 0;
		} else if (stringaDaTrovare.compareTo(nodoAlbero.contenutoRadice) == 0)
		{
			return 1;
		} else if (stringaDaTrovare.compareTo(nodoAlbero.contenutoRadice) < 0)
		{
			if(nodoAlbero.sottoAlberoSinistro.trovaLivello(stringaDaTrovare) > 0)
			{
				livello = livello + 1 + nodoAlbero.sottoAlberoSinistro.trovaLivello(stringaDaTrovare);
				return livello;
			}
		} else if (stringaDaTrovare.compareTo(nodoAlbero.contenutoRadice) > 0)
		{
			if(nodoAlbero.sottoAlberoDestro.trovaLivello(stringaDaTrovare) > 0)
			{
				livello = livello + 1 + nodoAlbero.sottoAlberoDestro.trovaLivello(stringaDaTrovare);
				return livello;
			}
		}
		return livello;
	}
	
	int trovaMaxLivello() {/* TODO profondità come indicato nel libro*/ return 0;} // livello 0 vuol dire stringa non trovata.
	
	
	AlberoBinarioDiRicercaStringhe sottoAlberoPartendoDa(String stringaRadice) // null se non trovato.
	{
		if (this.nodoAlbero == null)
		{
			return null;
		} else if (stringaRadice.compareTo(this.nodoAlbero.contenutoRadice) < 0)
		{
			return this.nodoAlbero.sottoAlberoSinistro.sottoAlberoPartendoDa(stringaRadice);
		} else if (stringaRadice.compareTo(this.nodoAlbero.contenutoRadice) > 0)
		{
			return this.nodoAlbero.sottoAlberoDestro.sottoAlberoPartendoDa(stringaRadice);
		} else return this;
	}

	int trovaPosizioneInOrdineSimmetrico(String stringaDaTrovare) // posizione 0 vuol dire stringa non trovata.
	{
		int posizione = 0;
		java.lang.String alberoString = this.toString(" ");
		StringTokenizer alberoTokenized = new StringTokenizer(alberoString);
		while(alberoTokenized.hasMoreTokens())
		{
			posizione++;
			if (alberoTokenized.nextToken().equals(stringaDaTrovare))
			{
				return posizione;
			}
		}  
		return 0;
	}
	
	
	java.lang.String nodoInternoOppureFoglia(String stringaDaTrovare) // nodoGenitoreOppureFiglio
	{
		java.lang.String result = "";
		if (nodoAlbero == null)
		{
			result = "Albero vuoto";
		} else if (stringaDaTrovare.compareTo(this.nodoAlbero.contenutoRadice) == 0 &&
				   this.nodoAlbero.sottoAlberoSinistro == null &&
				   this.nodoAlbero.sottoAlberoDestro == null)   // sottoAlberoPartendoDa(stringaDaTrovare) == null
		{
			result = "Nodo radice unico senza foglie";
		} else if (stringaDaTrovare.compareTo(this.nodoAlbero.contenutoRadice) == 0)
		{
			result = "Nodo radice con foglie";
		} else if (this.sottoAlberoPartendoDa(stringaDaTrovare) == null)
		{
			result = "Tale elemento non è presente nell'albero";
		} else if (this.sottoAlberoPartendoDa(stringaDaTrovare).numeroElementiNellAlbero() == 1)
		{
			result = "Nodo foglia";
		} else
		{
			result = "Nodo interno";
		}
		return result;
	}
	
	int nodoInternoOppureFogliaInt(String stringaDaTrovare) // nodoGenitoreOppureFiglio
	{
		int result = 0;
		if (nodoAlbero == null)
		{
			result = 0; // "Albero vuoto"
		} else if (stringaDaTrovare.compareTo(this.nodoAlbero.contenutoRadice) == 0 &&
				   this.nodoAlbero.sottoAlberoSinistro == null &&
				   this.nodoAlbero.sottoAlberoDestro == null)   // sottoAlberoPartendoDa(stringaDaTrovare) == null
		{
			result = 1; // "Nodo radice unico senza foglie"
		} else if (stringaDaTrovare.compareTo(this.nodoAlbero.contenutoRadice) == 0)
		{
			result = 2; // "Nodo radice con foglie"
		} else if (this.sottoAlberoPartendoDa(stringaDaTrovare) == null)
		{
			result = 3; // "Tale elemento non è presente nell'albero"
		} else if (this.sottoAlberoPartendoDa(stringaDaTrovare).numeroElementiNellAlbero() == 1)
		{
			result = 4; // "Nodo foglia"
		} else
		{
			result = 5; // "Nodo interno"
		}
		return result;
	}
	
	java.lang.String nodoFogliaSinistraOppureDestra(String stringaDaTrovare) {/*TODO*/ return "";} // nodoFiglioSinistroOppureDestro.
	
	int numeroElementiNellAlbero() // TODO Nuova implementazione come indicato nel libro.
	{
		int count = 0;
		java.lang.String alberoString = this.toString(" ");
		StringTokenizer alberoTokenized = new StringTokenizer(alberoString);
		while(alberoTokenized.hasMoreTokens())
		{
			count++;
			alberoTokenized.nextToken();
		}  
		return count;
	}
	
	boolean vuoto()
	{
		return (this.numeroElementiNellAlbero() == 0);
	}
	
	int numeroFoglie() {/* TODO come indicato nel libro */ return 0;} // radice unica senza figli considerata come foglia.
	
	int numeroNodiInterni() {/* TODO */ return 0;} // albero con 2 elementi non ha nodi interni. radice principale non è considerata nodo interno.
	
	/* void visualizza() // ordine simmetrico. simile al toString().
	{
		if(nodoAlbero != null)
		{
			nodoAlbero.sottoAlberoSinistro.visualizza();
			System.out.println(nodoAlbero.contenutoRadice + " ");
			nodoAlbero.sottoAlberoDestro.visualizza();
		}
	} */
	
	java.lang.String toString(java.lang.String string) // ordine simmetrico
	{
		java.lang.String risultato = "";
		if (nodoAlbero != null)
		{
			java.lang.String sinistra = (java.lang.String) nodoAlbero.sottoAlberoSinistro.toString(string);
			java.lang.String centro = (nodoAlbero.contenutoRadice.toString() + string);
			java.lang.String destra = (java.lang.String) nodoAlbero.sottoAlberoDestro.toString(string);
			risultato = sinistra + centro + destra;
		}
		return (java.lang.String) risultato;
	}
	
	// Main
	public static void main(java.lang.String[] args)
	{
		AlberoBinarioDiRicercaStringhe<java.lang.String> albero = new AlberoBinarioDiRicercaStringhe<java.lang.String>();
		System.out.println("Livello specchio: " + albero.trovaLivello("specchio"));
		System.out.println("Vuoto? " + albero.vuoto());
		
		albero.inserisci("tavolo");
		System.out.println("Albero: " + albero.toString(" "));
		
		albero.inserisci("sedia");
		System.out.println("Albero: " + albero.toString(" "));
		
		albero.inserisci("computer");
		System.out.println("Albero: " + albero.toString(" "));
		
		albero.inserisci("mouse");
		System.out.println("Albero: " + albero.toString(" "));
		System.out.println(albero.numeroElementiNellAlbero());
		
		albero.inserisci("schermo");
		System.out.println("Albero: " + albero.toString(" "));
		
		albero.inserisci("mano");
		System.out.println("Albero: " + albero.toString(" "));
		System.out.println("Vuoto? " + albero.vuoto());
		
		albero.inserisci("piede");
		System.out.println("Albero: " + albero.toString(" "));
		
		albero.inserisci("gamba");
		System.out.println("Albero: " + albero.toString(" "));
		
		albero.inserisci("testa");
		System.out.println("Albero: " + albero.toString(" "));
		
		albero.inserisci("braccio");
		System.out.println("Albero: " + albero.toString(" "));
		System.out.println(albero.numeroElementiNellAlbero());
		
		albero.inserisci("teiera");
		albero.inserisci("party");

		System.out.println("Trovato computer? " + albero.trova("computer"));
		System.out.println("Trovato tastiera? " + albero.trova("tastiera"));
		
		System.out.println("Livello tavolo: " + albero.trovaLivello("tavolo"));
		System.out.println("Livello sedia: " + albero.trovaLivello("sedia"));
		System.out.println("Livello computer: " + albero.trovaLivello("computer"));
		System.out.println("Livello mouse: " + albero.trovaLivello("mouse"));
		System.out.println("Livello telefono: " + albero.trovaLivello("telefono"));
		System.out.println("Livello schermo: " + albero.trovaLivello("schermo"));
		System.out.println("Livello mano: " + albero.trovaLivello("mano"));
		System.out.println("Livello piede: " + albero.trovaLivello("piede"));
		System.out.println("Livello gamba: " + albero.trovaLivello("gamba"));
		System.out.println("Livello testa: " + albero.trovaLivello("testa"));
		System.out.println("Livello muscolo: " + albero.trovaLivello("muscolo"));
		System.out.println("Livello braccio: " + albero.trovaLivello("braccio"));
		
		System.out.println("Posizione mouse: " + albero.trovaPosizioneInOrdineSimmetrico("mouse"));
		System.out.println("Posizione telefono: " + albero.trovaPosizioneInOrdineSimmetrico("telefono"));
		System.out.println("Posizione schermo: " + albero.trovaPosizioneInOrdineSimmetrico("schermo"));
		System.out.println("Posizione mano: " + albero.trovaPosizioneInOrdineSimmetrico("mano"));
		System.out.println("Posizione piede: " + albero.trovaPosizioneInOrdineSimmetrico("piede"));
		System.out.println("Posizione testa: " + albero.trovaPosizioneInOrdineSimmetrico("testa"));
		
		System.out.println("Sottoalbero: " + (albero.sottoAlberoPartendoDa("mouse")).toString(" "));
		System.out.println("Sottoalbero: " + (albero.sottoAlberoPartendoDa("schermo")).toString(" "));
		System.out.println("Sottoalbero: " + (albero.sottoAlberoPartendoDa("piede")).toString(" "));
		System.out.println("Sottoalbero: " + (albero.sottoAlberoPartendoDa("testa")).toString(" "));
		
		System.out.println("tavolo:   Nodo interno o foglia? " + albero.nodoInternoOppureFoglia("tavolo"));
		System.out.println("mouse:    Nodo interno o foglia? " + albero.nodoInternoOppureFoglia("mouse"));
		System.out.println("piede:    Nodo interno o foglia? " + albero.nodoInternoOppureFoglia("piede"));
		System.out.println("telefono: Nodo interno o foglia? " + albero.nodoInternoOppureFoglia("telefono"));
		System.out.println("computer: Nodo interno o foglia? " + albero.nodoInternoOppureFoglia("computer"));
		System.out.println("testa:    Nodo interno o foglia? " + albero.nodoInternoOppureFoglia("testa"));
		System.out.println("muscolo:  Nodo interno o foglia? " + albero.nodoInternoOppureFoglia("muscolo"));
		System.out.println("braccio:  Nodo interno o foglia? " + albero.nodoInternoOppureFoglia("braccio"));
	}
}
