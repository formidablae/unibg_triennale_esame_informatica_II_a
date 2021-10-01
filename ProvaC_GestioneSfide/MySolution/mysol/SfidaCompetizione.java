package mysol;
import java.text.ParseException;

public class SfidaCompetizione extends Sfida
{
	// CAMPI
	private static final int INCREMENTO = 500;
	private static final int PUNTEGIO_BASE = 1000;
	int puntegGioco;			// da 1 a 10
	
	// COSTRUTTORI
	public SfidaCompetizione() throws SfidaNonValidaException
	{
		super();
		puntegGioco = 0;
		id = "C" + numeroSfideCreate;
		
	}
	
	public SfidaCompetizione(	String idInput,									// Con id per la lettura da file.
								String laDescrizione,
								String lOraTenuta,
								String ilNomePartecipanteUno,
								String ilNomePartecipanteDue,
								Boolean eSfidaCampionato,
								int ilPuntegGioco) throws ParseException
	{
		super(	laDescrizione,
				lOraTenuta,
				ilNomePartecipanteUno,
				ilNomePartecipanteDue,
				eSfidaCampionato);
		id = idInput;
		puntegGioco = ilPuntegGioco;
		punteggio = this.calcolaPunteggio();
	}
	
	public SfidaCompetizione(	String laDescrizione,
								String lOraTenuta,
								String ilNomePartecipanteUno,
								String ilNomePartecipanteDue,
								Boolean eSfidaCampionato,
								int ilPuntegGioco) throws ParseException
	{
		super(	laDescrizione,
				lOraTenuta,
				ilNomePartecipanteUno,
				ilNomePartecipanteDue,
				eSfidaCampionato);
		id = "C" + numeroSfideCreate;
		puntegGioco = ilPuntegGioco;
		punteggio = this.calcolaPunteggio();
	}
	
	// METODI
	@Override
	public int calcolaPunteggio()
	{
		return PUNTEGIO_BASE + this.puntegGioco * INCREMENTO;
	}
	
	// METODI STATICI
	
}
