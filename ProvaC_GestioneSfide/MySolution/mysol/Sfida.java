package mysol;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Sfida implements Comparable<Sfida>
{
	// CAMPI
	String id;								// Codice e numero
	String descrizione;
	Date oraTenuta;							// non prima delle 7:00, non dopo le 24:00
	String nomePartecipanteUno;
	String nomePartecipanteDue;
	Boolean sfidaCampionato;				// Sfida campionato o amichevole
	int punteggio;
	static int numeroSfideCreate;
	
	// COSTRUTTORI
	public Sfida() throws SfidaNonValidaException
	{
		descrizione = null;
		oraTenuta = null;
		nomePartecipanteUno = null;
		nomePartecipanteDue = null;
		sfidaCampionato = null;
		
		if (false)
		{
			// TODO
			throw new SfidaNonValidaException("Questa cosa non è valida");
		}
		
		numeroSfideCreate++;
	}
	
	public Sfida(	String laDescrizione,
					String lOraTenuta,
					String ilNomePartecipanteUno,
					String ilNomePartecipanteDue,
					Boolean eSfidaCampionato) throws ParseException
	{
		descrizione = laDescrizione;
		oraTenuta = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(lOraTenuta);
		nomePartecipanteUno = ilNomePartecipanteUno;
		nomePartecipanteDue = ilNomePartecipanteDue;
		sfidaCampionato = eSfidaCampionato;
		numeroSfideCreate++;
	}
	
	// METODI
	@SuppressWarnings("deprecation")
	public String stampaSfida()
	{
		String spazi = "               ";
		String result = "│ ";
		
		result = result + id;
		result = result + spazi.substring(0, 6 - id.length());
		result = result + " │ ";
		
		result = result + (oraTenuta.getYear() + 1900) + "-";
		if ((oraTenuta.getMonth() + 1) / 10 < 1)
		{
			result = result + "0" + (oraTenuta.getMonth() + 1) + "-";
		} else
		{
			result = result + (oraTenuta.getMonth() + 1) + "-";
		}
		if ((oraTenuta.getDate()) / 10 < 1)
		{
			result = result + "0" + (oraTenuta.getDate());
		} else
		{
			result = result + (oraTenuta.getDate());
		}
		result = result + " │ ";
		
		if ((oraTenuta.getHours()) / 10 < 1)
		{
			result = result + "0" + (oraTenuta.getHours());
		} else
		{
			result = result + (oraTenuta.getHours());
		}
		
		result = result + ":";
		
		if ((oraTenuta.getMinutes()) / 10 < 1)
		{
			result = result + "0" + (oraTenuta.getMinutes());
		} else
		{
			result = result + (oraTenuta.getMinutes());
		}
		
		result = result + " │ ";
		
		result = result + descrizione;
		result = result + spazi.substring(0, 15 - descrizione.length());
		result = result + " │ ";
		
		result = result + nomePartecipanteUno;
		result = result + spazi.substring(0, 15 - nomePartecipanteUno.length());
		result = result + " │ ";
		
		result = result + nomePartecipanteDue;
		result = result + spazi.substring(0, 15 - nomePartecipanteDue.length());
		result = result + " │ ";
		
		if (this instanceof SfidaCompetizione)
		{
			result = result + "Competizione" + " │ ";
		}
		else if (this instanceof SfidaPacifica)
		{
			result = result + "Pacifica    " + " │ ";
		}
		else
		{
			result = result + "Normale     " + " │ ";
		}
		
		if (sfidaCampionato)
		{
			result = result + "Campionato" + " │ ";
		}
		else
		{
			result = result + "Amichevole" + " │ ";
		}
		
		result = result + spazi.substring(0, 10 - String.valueOf(this.calcolaPunteggio()).length());
		result = result + this.calcolaPunteggio();
		
		result = result + " │";
		return result;
	}
	
	public int calcolaPunteggio()
	{
		return 0;
	}
	
	public int compareTo(Sfida sfidaDaConfrontare)
	{
		if (this.oraTenuta.before(sfidaDaConfrontare.oraTenuta)) return -1;
		else if (this.oraTenuta.after(sfidaDaConfrontare.oraTenuta)) return 1;
		else return 0;
	}
	// METODI STATICI
}
