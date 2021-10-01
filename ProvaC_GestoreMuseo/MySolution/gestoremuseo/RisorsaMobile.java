package gestoremuseo;

public abstract class RisorsaMobile implements Risorsa
{
	private Sala ubicazione;
	
	public RisorsaMobile(Sala ubicazione)
	{
		this.ubicazione = ubicazione;
	}
	
	public void cambioUbicazione(Sala sala)
	{
		ubicazione = sala;
	}
	
	public Sala getUbicazione()
	{
		return ubicazione;
	}
}
