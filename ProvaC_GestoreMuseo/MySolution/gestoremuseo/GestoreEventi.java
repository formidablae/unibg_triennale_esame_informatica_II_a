package gestoremuseo;

import prog.utili.Data;
import prog.utili.Insieme;

/**
 * Rappresenta il gestore degli eventi
 * 
 * @author 
 *
 */
public class GestoreEventi
{
	
	/** The gestore eventi */
	
	//Methods
	
	/** The data inizio evento */
	Data dataInizio;
	
	/** The data fine evento */
	Data dataFine;
	
	/** String type field for the titoloEvento */
	String titoloEvento;
	
	/**  The insieme di risorse dedicate ad un evento */
	Insieme<Risorsa> risorseDedicate;
}
