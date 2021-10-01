package mysol;
import java.text.ParseException;

public class SfidaNormale extends Sfida
{
	// CAMPI
	String luogoSfida;
	
	// COSTRUTTORI
	public SfidaNormale() throws SfidaNonValidaException
	{
		super();
		id = "N" + numeroSfideCreate;
		
	}
	
	public SfidaNormale(String idInput,									// Con id per la lettura da file.
						String laDescrizione,
						String lOraTenuta,
						String ilNomePartecipanteUno,
						String ilNomePartecipanteDue,
						Boolean eSfidaCampionato,
						String ilLuogoSfida) throws ParseException
	{
		super(	laDescrizione,
		lOraTenuta,
		ilNomePartecipanteUno,
		ilNomePartecipanteDue,
		eSfidaCampionato);
		id = idInput;
		luogoSfida = ilLuogoSfida;
		punteggio = this.calcolaPunteggio();
	}
	
	public SfidaNormale(	String laDescrizione,
							String lOraTenuta,
							String ilNomePartecipanteUno,
							String ilNomePartecipanteDue,
							Boolean eSfidaCampionato,
							String ilLuogoSfida) throws ParseException
	{
		super(	laDescrizione,
				lOraTenuta,
				ilNomePartecipanteUno,
				ilNomePartecipanteDue,
				eSfidaCampionato);
		id = "N" + numeroSfideCreate;
		luogoSfida = ilLuogoSfida;
		punteggio = this.calcolaPunteggio();
	}
	
	// METODI
	@SuppressWarnings("deprecation")
	@Override
	public int calcolaPunteggio()
	{
		if (super.oraTenuta.getHours() < 12)
		{
			return 200;
		}
		else return 300;
	}
	
	// METODI STATICI
}
