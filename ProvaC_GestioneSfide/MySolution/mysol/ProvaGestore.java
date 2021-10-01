package mysol;
import java.text.ParseException;

public class ProvaGestore
{
	public static void main(String[] args) throws SfidaNonValidaException, ParseException
	{
		GestoreVideogiochi unGestore = new GestoreVideogiochi();
		
		SfidaNormale sfidaNormaleUno = new SfidaNormale("Calcio", "2019-02-15 15:00", "Maria", "Daniela", false, "Bergamo");
		SfidaNormale sfidaNormaleDue = new SfidaNormale("Scacchi", "2019-01-02 10:00", "Maria", "Fabrizio", true, "Brescia");
		SfidaNormale sfidaNormaleTre = new SfidaNormale("Calcio", "2019-01-14 15:00", "Davide", "Daniela", false, "Bergamo");
		SfidaNormale sfidaNormaleQuattro = new SfidaNormale("Basket", "2019-01-05 15:00", "Maria", "Marco", true, "Milano");
		SfidaNormale sfidaNormaleCinque = new SfidaNormale("Fifa", "2018-02-25 15:00", "Andrea", "Daniela", false, "Bergamo");
		SfidaNormale sfidaNormaleSei = new SfidaNormale("PES", "2019-02-15 12:00", "Maria", "Daniela", true, "Verona");
		SfidaPacifica sfidaPacificaUno = new SfidaPacifica("Corsa", "2016-02-15 20:00", "Marco", "Andrea", false);
		SfidaPacifica sfidaPacificaDue = new SfidaPacifica("Volley", "2019-02-15 15:00", "Andrea", "Daniela", true);
		SfidaPacifica sfidaPacificaTre = new SfidaPacifica("Scacchi", "2019-02-02 10:00", "Marco", "Fabrizio", true);
		SfidaCompetizione sfidaCompetizioneUno = new SfidaCompetizione("Corsa", "2019-02-02 10:00", "Maria", "Fabrizio", false, 1);
		SfidaCompetizione sfidaCompetizioneDue = new SfidaCompetizione("Fifa", "2019-02-02 10:00", "Andrea", "Fabrizio", true, 2);
		SfidaCompetizione sfidaCompetizioneTre = new SfidaCompetizione("Nuoto", "2019-02-02 10:00", "Maria", "Marco", false, 4);
		SfidaCompetizione sfidaCompetizioneQuattro = new SfidaCompetizione("Calcio", "2019-02-02 10:00", "Davide", "Fabrizio", true, 6);
		
		unGestore.inserimento(sfidaNormaleUno);
		unGestore.inserimento(sfidaNormaleDue);
		unGestore.inserimento(sfidaNormaleTre);
		unGestore.inserimento(sfidaNormaleQuattro);
		unGestore.inserimento(sfidaNormaleCinque);
		unGestore.inserimento(sfidaNormaleSei);
		unGestore.inserimento(sfidaPacificaUno);
		unGestore.inserimento(sfidaPacificaDue);
		unGestore.inserimento(sfidaPacificaTre);
		unGestore.inserimento(sfidaCompetizioneUno);
		unGestore.inserimento(sfidaCompetizioneDue);
		unGestore.inserimento(sfidaCompetizioneTre);
		unGestore.inserimento(sfidaCompetizioneQuattro);
		
		System.out.println("Lista non in ordine.");
		System.out.println(unGestore.stampa());
		System.out.println();
		
		System.out.println("Lista in ordine per punteggio.");
		System.out.println(unGestore.stampaInOrdinePerPunteggio());
		System.out.println();
		
		System.out.println("Lista in ordine per data.");
		System.out.println(unGestore.stampaInOrdinePerData());
		System.out.println();
		
		GestoreVideogiochi unAltroGestore = new GestoreVideogiochi();
		
		unAltroGestore.readAndPopulateFromFile("DataFile.txt");
		System.out.println("Lista di un altro gestore, non in ordine.");
		System.out.println(unAltroGestore.stampa());
		System.out.println();
	}
}
