//package studioLegale;
//
//import java.util.ArrayList;
//
//import eccezioni.ProtocolloException;
//
//import pratiche.Civile;
//import pratiche.Conciliazione;
//import pratiche.GradoGiudizio;
//import pratiche.Penale;
//import pratiche.Pratica;
//import pratiche.Stato;
//import prog.io.FileInputManager;
//import prog.utili.Data;
//import prog.utili.SequenzaOrdinata;
//
///**
// * Potevo salvarmi anch� un ArrayList ordinata rispetto ai costi, e una booleana
// * che mi 'dicesse' se i dati in essa contenuti ordinati. Su ogni inserimento
// * alla SequenzaOrdinata, aggiungerei in fondo anche all'ArrayList controllando
// * che se il dato inserito ha il costo maggiore la variabile booleana rimane a
// * true (se lo era) altrimenti va a false. Ogni qual volta eseguissi il metodo
// * pratiche_per_costo controllo se la booleana fosse a false ordino altrimenti
// * sono gi� ordinati e devo solo stampare. Questo ottimizzerebbe la velocit�
// * dell'esecuzione di pratiche_per_costo e pratiche_archiviate_per_costo.
// * Quest'ultimo pu� venir ottimizzato ulteriormente limitando l'esecuzione
// * dell'ordinamento solo quando le pratiche ARCHIVIATE fossero in ordine usando
// * un altra booleana.
// */
//public class StudioLegale {
//
//	private SequenzaOrdinata<Pratica> pratiche;
//
//	public StudioLegale() {
//		pratiche = new SequenzaOrdinata<>();
//	}
//
//	/**
//	 * Ho pensato che in scrittura salvassi gli ordinal degli enum cos� al posto
//	 * di utilizzare degli switch posso sfruttando la funzione values fare la
//	 * stessa operazione occupando meno sul file e riducendo il codice
//	 * 
//	 * @param path
//	 *            E' l'indirizzo assoluto o relativo in cui si trova il file
//	 */
//	public StudioLegale(String path) {
//		this();
//		loadFromFile(path);
//	}
//
//	// load the data from file (attensione non gestisce conlitto ID)
//	public void loadFromFile(String path) {
//		long maxId = 0, newId;
//		int i_stati, i_gradi;
//		Stato[] stati = Stato.values();
//		GradoGiudizio[] gradi = GradoGiudizio.values();
//		Data nascita, udienza;
//		Cliente c;
//		Pratica p;
//		String record, campi[];
//		FileInputManager in = new FileInputManager(path);
//		do {
//			record = in.readLine();
//			if (record != null) {
//				campi = record.split(";");// non uso spazio perch� il nome ne
//											// pu� contenere
//				nascita = new Data(campi[4]);
//				newId = Long.parseLong(campi[1]);
//				if (newId > maxId)
//					maxId = newId;
//				Pratica.setId(newId);
//				c = new Cliente(campi[2], campi[3], nascita, campi[5]);
//				udienza = new Data(campi[7]);
//				i_stati = Integer.parseInt(campi[8]);
//				if (i_stati < 0 || i_stati > 2)
//					throw new ProtocolloException("Il file � malformato");
//				switch (campi[0]) {
//				case "p":
//					i_gradi = Integer.parseInt(campi[10]);
//					if (i_gradi < 0 || i_gradi > 2)
//						throw new ProtocolloException("Il file � malformato");
//					p = new Penale(c, campi[6], udienza, stati[i_stati],
//							Integer.parseInt(campi[9]), gradi[i_gradi]);
//					break;
//				case "c":
//					i_gradi = Integer.parseInt(campi[10]);
//					if (i_gradi < 0 || i_gradi > 2)
//						throw new ProtocolloException("Il file � malformato");
//					p = new Civile(c, campi[6], udienza, stati[i_stati],
//							Integer.parseInt(campi[9]), gradi[i_gradi]);
//					break;
//				case "n":
//					p = new Conciliazione(c, campi[6], udienza, stati[i_stati],
//							Integer.parseInt(campi[9]));
//					break;
//				default:
//					throw new ProtocolloException("File malformato");
//				}
//				pratiche.add(p);
//			}
//		} while (record != null);
//		Pratica.setId(maxId);
//	}
//
//	public void inserisci_pratica(Pratica p) {
//		pratiche.add(p);
//	}
//
//	/**
//	 * 
//	 * @return La stringa contenente le pratiche ordinate per priorit�
//	 */
//	public String pratiche_per_priorita() {
//		return pratiche.toString();
//	}
//
//	/**
//	 * Non potendo sfruttare il compareTo gi� definito affinch� la
//	 * SequenzaOrdinata ordini le pratiche in base alla priorit� sfrutto il
//	 * mergesort da me implementato
//	 * 
//	 * @return La stringa contenente le pratiche ordinate per costo
//	 */
//	public String pratiche_per_costo() {
//		ArrayList<Pratica> copia_pratiche = new ArrayList<>();
//		for (Pratica p : pratiche)
//			copia_pratiche.add(p);
//		mergesort(copia_pratiche, 0, copia_pratiche.size() - 1);
//		return copia_pratiche.toString();
//	}
//
//	/**
//	 * Come soppra
//	 * 
//	 * @return La stringa contenente le pratiche ARCHIVIATE ordinate per costo
//	 */
//	public String pratiche_archiviate_per_costo() {
//		ArrayList<Pratica> copia_pratiche = new ArrayList<>();
//		for (Pratica p : pratiche)
//			if (p.getStato().equals(Stato.ARCHIVIATA))
//				copia_pratiche.add(p);
//		mergesort(copia_pratiche, 0, copia_pratiche.size() - 1);
//		return copia_pratiche.toString();
//	}
//
//	private void mergesort(ArrayList<Pratica> ps, int min, int max) {
//		if (max == min)
//			return;
//		int med = (max + min) / 2;
//		mergesort(ps, min, med);
//		mergesort(ps, med + 1, max);
//		merge(ps, min, med, max);
//	}
//
//	private void merge(ArrayList<Pratica> ps, int min, int med, int max) {
//		int sx = min, dx = med + 1, i = 0;
//		ArrayList<Pratica> temp = new ArrayList<>();
//		while (sx <= med && dx <= max) {
//			if (ps.get(sx).getCosto() <= ps.get(dx).getCosto())
//				temp.add(ps.get(sx++));
//			else
//				temp.add(ps.get(dx++));
//			i++;
//		}
//		if (sx > med)
//			for (; dx <= max; dx++, i++)
//				temp.add(ps.get(dx));
//		else
//			for (; sx <= med; sx++, i++)
//				temp.add(ps.get(sx));
//		for (i = 0; i < temp.size(); i++)
//			ps.set(min + i, temp.get(i));
//	}
//
//}
