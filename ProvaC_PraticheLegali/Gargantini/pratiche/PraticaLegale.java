//package pratiche;
//
//import prog.utili.Data;
//
///**
// * pratiche di uno studio legale.
// */
//abstract public class PraticaLegale implements Comparable<PraticaLegale>{
//
//	// num di pratiche legali costruite 
//	static int numeroPraticheLegali = 0;
//	
//	// client con nome e cognome
//	private String cliente;
//	// descrizione
//	private String descr;
//	// stato della pratica
//	StatoPratica stato;
//	// numerod i ore lavorate su qyesta pratica
//	protected int numeroOre;
//	// prossima udienza, pu� essere anche nel passato
//	protected Data prosUdienza;
//	
//	// ID univoco
//	int ID;
//	/**
//	 * 
//	 * @param c cliente
//	 * @param d descrizione
//	 * @param u prossima udienza
//	 */
//	public PraticaLegale(String c, String d, Data u) {
//		this(c,d,u,0);
//	}
//	/**
//	 * 
//	 * @param c cliente
//	 * @param d descrizione
//	 * @param u prossima udienza
//	 * @param nol numero di ore gi� lavorate
//	 */
//	public PraticaLegale(String c, String d, Data u, int nol) {
//		cliente = c;
//		descr = d;
//		prosUdienza = u;
//		stato = StatoPratica.INCORSO;
//		numeroOre = nol;		
//		ID = ++numeroPraticheLegali;
//	}
//	
//	
//	/**
//	 * Ogni pratica ha priorit� che dipende da quanti giorni mancano
//	 * all'udienza. Nota che valore alto di priorit� vuol dire bassa priorit�.
//	 * Priorit� 0 � quindi il massimo (lavoro da fare oggi) (metti che se � un
//	 * lavoro passato ha valore priorit� Integer.MAX_INT), quando una pratica
//	 * viene chiusa o archiviata la sua priorit� assume un valore standard di
//	 * 1000.
//	 * @return
//	 */
//	public int priorita() {
//		if (stato == StatoPratica.CHIUSA || stato == StatoPratica.ARCHIVIATA)
//			return 1000;
//		Data oggi = new Data();
//		int deltaGiorni = oggi.quantoManca(prosUdienza);
//		if (deltaGiorni < 0){
//			// con data udienza nel passato
//			return Integer.MAX_VALUE;
//		} else{
//			// udienza nel futuro, la priorit� � il numero di giorni
//			// che mancano
//			return deltaGiorni;
//		}
//	}
//	// il costo della pratica (dipende dal tipo di pratica)
//	abstract int costo();
//
//	@Override
//	public String toString() {
//		return "["+ID+"]cliente " + cliente + " udienza " + prosUdienza + " costo :" + costo();
//	}
//	
//	// ordine di priorit�
//	@Override
//	public int compareTo(PraticaLegale o) {
//		return this.priorita() - o.priorita();
//	}
//}
