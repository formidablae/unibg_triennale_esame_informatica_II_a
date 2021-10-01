package unibg.gestoremuseo;

public class Sala implements Risorsa {
	private String nome;
	private static int contatore = 0;
	
	public Sala() {
		nome = "Sala_" + contatore;
		contatore++;
	}

	public Sala(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}
}