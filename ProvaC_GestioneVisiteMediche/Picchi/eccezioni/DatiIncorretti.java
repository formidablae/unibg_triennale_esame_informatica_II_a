package eccezioni;

@SuppressWarnings("serial") //va benissimo il metodo di default di Java.
public class DatiIncorretti extends Exception {
	public DatiIncorretti() {
		super("I dati forniti non sono corretti");
	}
}
