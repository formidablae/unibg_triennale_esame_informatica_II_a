import sistema.Sistema;
import telecamera.Telecamera;

public class provaSistema
{
	
	// CAMPI
	
	// COSTRUTTORI
	
	// METODI
	
	// METODI STATICI
	
	// MAIN
	public static void main(String[] args)
	{
		Sistema unSistemaDiTelecamere = new Sistema();
		Telecamera unaTelecamera1 = new Telecamera("La desc", 4);
		unSistemaDiTelecamere.inserisciTelecameraInSistema(unaTelecamera1);
		Telecamera unaTelecamera2 = new Telecamera("La desc2", 118);
		unSistemaDiTelecamere.inserisciTelecameraInSistema(unaTelecamera2);
		System.out.println("Questo sistema contiene queste telecamere\n" + unSistemaDiTelecamere.stampaSistema());
		
		System.out.println();
		
		Sistema unSistemaDiTelecamere2 = new Sistema();
		System.out.println("Questo sistema contiene queste telecamere\n" + unSistemaDiTelecamere2.stampaSistema());
		
		System.out.println();
		
		Sistema unSistemaDiTelecamere3 = new Sistema();
		Telecamera unaTelecamera3 = new Telecamera("La desc3", 33);
		unSistemaDiTelecamere3.inserisciTelecameraInSistema(unaTelecamera3);
		System.out.println("Questo sistema contiene queste telecamere\n" + unSistemaDiTelecamere3.stampaSistema());
		
	}

}
