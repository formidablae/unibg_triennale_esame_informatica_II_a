package unibg.gestoremuseo;

public class Personale extends RisorsaMobile {
	private String nome, cognome;
	private TipoPersonale tipo;

	public Personale(Sala ubicazione, String nome, String cognome, TipoPersonale tipo) {
		super(ubicazione);
		this.nome = nome;
		this.cognome = cognome;
		this.tipo = tipo;
	}

	public int getCostoAlGiorno() {
		return tipo.getCostoAlGiorno();
	}

	@Override
	public String toString() {
		return nome + " " + cognome + ". Tipo: " + tipo;
	}
}