package eccezioni;

import java.time.LocalDate;

@SuppressWarnings("serial") //va benissimo il metodo di default di Java.
public class GiornoNonValidoException extends Exception {
	public GiornoNonValidoException(LocalDate date) {
		super("Il giorno: "+ date.toString() + " non è valido (lo studio è chiuso)");
	}
}
