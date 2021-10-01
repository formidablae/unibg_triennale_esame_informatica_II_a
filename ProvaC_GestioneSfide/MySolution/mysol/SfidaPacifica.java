package mysol;
import java.text.ParseException;
import java.util.Date;

public class SfidaPacifica extends Sfida
{
	// CAMPI
	
	// COSTRUTTORI
	public SfidaPacifica() throws SfidaNonValidaException
	{
		super();
		id = "P" + numeroSfideCreate;
		
	}
	
	public SfidaPacifica(	String idInput,									// Con id per la lettura da file.
							String laDescrizione,
							String lOraTenuta,
							String ilNomePartecipanteUno,
							String ilNomePartecipanteDue,
							Boolean eSfidaCampionato) throws ParseException
	{
		super(	laDescrizione,
		lOraTenuta,
		ilNomePartecipanteUno,
		ilNomePartecipanteDue,
		eSfidaCampionato);
		id = idInput;
		punteggio = this.calcolaPunteggio();
	}
	
	public SfidaPacifica(	String laDescrizione,
							String lOraTenuta,
							String ilNomePartecipanteUno,
							String ilNomePartecipanteDue,
							Boolean eSfidaCampionato) throws ParseException
	{
		super(	laDescrizione,
				lOraTenuta,
				ilNomePartecipanteUno,
				ilNomePartecipanteDue,
				eSfidaCampionato);
		id = "P" + numeroSfideCreate;
		punteggio = this.calcolaPunteggio();
	}
	
	// COSTRUTTORI
	
	
	// METODI
	@Override
	public int calcolaPunteggio()
	{
		if (super.sfidaCampionato)
		{
			return 100;
		}
		else return 10;
	}
	
	// METODI STATICI
	
}
