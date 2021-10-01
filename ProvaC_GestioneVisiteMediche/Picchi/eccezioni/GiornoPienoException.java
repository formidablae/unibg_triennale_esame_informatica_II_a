package eccezioni;

import java.time.LocalDate;

@SuppressWarnings("serial") //va benissimo il metodo di default di Java.
public class GiornoPienoException extends Exception {
	public GiornoPienoException(LocalDate date) {
		super("Non è possibile aggiungere ulteriori visite per il giorno: "+ date.toString());
	}
}
