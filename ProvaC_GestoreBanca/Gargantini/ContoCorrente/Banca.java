package ContoCorrente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import prog.utili.SequenzaOrdinata;
import Eccezioni.NumeroContoNonValidoException;
import OperazioniBancarie.OperazioneBancaria;

/**
 * BANCA: gestore dei conti con le operazioni richieste.
 * 
 * @author garganti
 */
public class Banca {

	/** The lista dei conti (in ordine di saldo). */
	private SequenzaOrdinata<Conto> listaConti;

	/**
	 * Costruttore.
	 */
	public Banca() {
		listaConti = new SequenzaOrdinata<Conto>();
	}

	/**
	 * Crea un conto corrente nuovo, lo aggiunge alla lista e ne stampa le
	 * informazioni.
	 * 
	 * @param s
	 *            Nome dell'intestatario
	 */
	public void creaConto(String s) {
		Conto a = new Conto(s);
		listaConti.add(a);
		System.out.println("Conto creato con successo");
		System.out.println("Dettagli conto: ");
		System.out.println(a.toString() + "\n");
	}

	/**
	 * Esegue un'operazione bancaria che gli viene passata, e aggiorna saldo e
	 * lista del conto corrente relativo.
	 * 
	 * @param a
	 *            OperazioneBancaria da passare
	 */
	public void eseguiOperazione(OperazioneBancaria a) {
		Conto c = findConto(a.getCC());
		// aggiunge l'operazione
		c.operazioni.add(a);
		// aggiorna saldo
		// se è bonifico dovrei anche togliere il saldo dallaltro conto, ma per
		// ora assumo che un bonifico venga processato due volte.
		c.saldo += a.getValore();
	}

	/**
	 * Find conto.
	 * 
	 * @param numeroConto
	 *            da cercare
	 * @return il numero o solleva eccezione se non è valido
	 */
	private Conto findConto(int numeroConto) {
		Iterator<Conto> it = listaConti.iterator();
		while (it.hasNext()) {
			Conto k = it.next();
			if (k.numeroConto == numeroConto) {
				return k;
			}
		}
		throw new NumeroContoNonValidoException("conto non valido"
				+ numeroConto);
	}

	/**
	 * Stampa gli ultimi "numeroOperazioni" elementi del conto "numeroConto" in
	 * ordine di data decrescente.
	 * 
	 * @param numeroConto
	 *            Conto del quale voglio sapere l'informazione
	 * @param numeroOperazioni
	 *            numero di operazioni richieste
	 */
	public void stampaMovimentiperData(int numeroConto, int numeroOperazioni) {
		// cerca il conto
		Conto k = findConto(numeroConto);
		// creo un nuovo iterator per scorrere la lista delle operazioni
		Iterator<OperazioneBancaria> op = k.operazioni.iterator();
		OperazioneBancaria a = null;

		// stampo il numero di operazioni richieste, se ne vengono chieste di
		// più si ferma
		for (int i = 0; i < numeroOperazioni && op.hasNext(); i++) {
			a = op.next();
			a.stampa();
		}
	}

	/**
	 * Stampa l'intera lista dei conti in ordine crescente di saldo (essendo
	 * ordinati già per saldo).
	 */
	public void stampaContiperOrdinediSaldo() {
		System.out.println("LISTA DEI CONTI");
		for (Conto c : listaConti) {
			System.out.println(c.toString());
		}
	}

	/**
	 * Legge e carica dal file letturaContiDaFile.txt i conti presenti in esso
	 */
	public void leggieCaricadaFile() {
		BufferedReader br = null;

		try {

			String sCurrentLine;
			br = new BufferedReader(new FileReader("letturaContidaFile.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				String[] dati = sCurrentLine.split(";");
				Conto a = new Conto(Integer.parseInt(dati[0]), dati[1],
						Float.parseFloat(dati[2]));
				listaConti.add(a);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
