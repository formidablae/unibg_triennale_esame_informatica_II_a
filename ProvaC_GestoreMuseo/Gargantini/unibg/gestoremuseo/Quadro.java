package unibg.gestoremuseo;

public class Quadro extends RisorsaMobile {
	private int costoSettimana;
	private String titolo;
	private String autore;
	private int anno;

	public Quadro(Sala ubicazione, int costoSettimana, String titolo, String autore, int anno) {
		super(ubicazione);
		this.costoSettimana = costoSettimana;
		this.titolo = titolo;
		this.autore = autore;
		this.anno = anno;
	}

	public int getCostoSettimana() {
		return costoSettimana;
	}

	@Override
	public String toString() {
		return autore + ". " + titolo + ", " + anno;
	}
}
