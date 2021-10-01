import prog.io.ConsoleInputManager;
import prog.utili.Data;

public class TestGestoreBanca
{
	private static Banca entitaBanca;

//	public static void main(String[] args)
//	{
//		ConsoleInputManager in = new ConsoleInputManager();
//		
//		System.out.println("Creazione della banca.");
//		String nomeBancaInput = in.readLine("Inserire il nome della banca: ");
//		setEntitaBanca(new Banca(nomeBancaInput));
//		System.out.println("Banca creata.");
//		
//		int sceltaMenu = 0;
//		while(sceltaMenu != 5)
//		{
//			System.out.println("Menu principale.\n" +
//							   "1. Entra nel sottomenu della gestione della banca.\n" +
//							   "2. Entra nel sottomenu della gestione dei conti.\n" +
//							   "3. Entra nel sottomenu per il caricamento e salvataggio dei dati.\n" +
//					           "4. Leggi readme.txt\n"+
//					           "5. Esci.");
//			sceltaMenu = in.readInt("Inserire il numero del menu scelto: ");
//			if(sceltaMenu == 1)
//	        {
//				int sceltaMenuGestioneBanca = 0;
//	        	while(sceltaMenuGestioneBanca != 2)
//	        	{
//		        	System.out.println("Menu gestione banca.");
//		        	sceltaMenuGestioneBanca = in.readInt("Inserire:\n" +
//		        			 	                          "1. per rinominare la banca.\n" +
//		        				                          "2. per tornare al menu principale.\n" +
//		        			 	                          "Scelta: ");
//		        	if(sceltaMenuGestioneBanca == 1)
//		        	{
//		        		String nuovoNomeBancaInput = in.readLine("Rinomina la banca. Inserire il nuovo nome: ");
//		        		entitaBanca.rinominaBanca(nuovoNomeBancaInput);
//		        		System.out.println("La banca è stata rinominata.");
//		        	}
//			        else if (sceltaMenuGestioneBanca == 2)
//			        {
//			        	System.out.println("Tornando al menu principale.");
//			        }
//			        else
//			        {
//			        	System.out.println("Scelta non valida.");
//			        }
//	        	}
//	        }
//	        if(sceltaMenu == 2)
//	        {
//	        	int sceltaMenuGestioneConto = 0;
//	        	while(sceltaMenuGestioneConto != 7)
//	        	{
//		        	System.out.println("Menu gestione conto.");
//		        	sceltaMenuGestioneConto = in.readInt("Inserire:\n" +
//		        			 	                          "1. per aprire un nuovo conto.\n" +
//		        			 	                          "2. per stampare l'elenco dei conti.\n" +
//		        			 	                          "3. per eliminare uno o più conti.\n" +
//		        			 	                          "4. per eseguire un'operazione bancaria.\n" +
//		        			 	                          "5. per stampare l'elenco delle operazioni.\n" +
//		        			 	                          "6. per stampare il saldo dei conti in ordine decrescente.\n" +
//		        				                          "7. per tornare al menu principale.\n" +
//		        			 	                          "Scelta: ");
//		        	if(sceltaMenuGestioneConto == 1)
//		        	{
//			        	String nomeIntestatarioInput = in.readLine("L'apertura del nuovo conto è in corso.\n" +
//			            										   "Inserire il nome dell'intestatario: ");
//			        	Conto apriamoUnConto = Banca.aperturaContoCorrente(nomeIntestatarioInput);
//			        	System.out.println("Il conto è stato aperto.");
//		        	}
//			        else if (sceltaMenuGestioneConto == 2)
//			        {
//			        	entitaBanca.stampaElencoConti();
//			        }
//			        else if (sceltaMenuGestioneConto == 3)
//			        {
//			        	int sceltaMenuEliminazioneConto = 0;
//			        	while(sceltaMenuEliminazioneConto != 6 && sceltaMenuEliminazioneConto != 7)
//			        	{
//				        	System.out.println("Menu eliminazione conto.");
//				        	sceltaMenuEliminazioneConto = in.readInt("Inserire:\n" +
//				        			 	                             "1. per eliminare un conto mediante il numero di conto.\n" +
//				        			 	                             "2. per eliminare un conto inserendo il nome dell'intestatario del conto.\n" +
//				        			 	                             "3. per eliminare tutti i conti con saldo negativo.\n" +
//				        			 	                             "4. per eliminare tutti i conti con saldo zero.\n" +
//				        			 	                             "5. per eliminare tutti i conti in memoria.\n" +
//				        				                             "6. per tornare al menu gestione conto.\n" +
//				        			 	                             "7. per tornare al menu principale.\n" +
//				        			 	                             "Scelta: ");
//				        	if(sceltaMenuEliminazioneConto == 1)
//				        	{
//				        		int numeroContoDaEliminare = in.readInt("Inserire il numero del conto da eliminare: ");
//					        	entitaBanca.eliminaConto(numeroContoDaEliminare);
//					        	System.out.println("Il conto con numero " + numeroContoDaEliminare + " è stato eliminato.");
//				        	}
//				        	else if (sceltaMenuEliminazioneConto == 2)
//				        	{
//				        		String nomeIntestatarioContoDaEliminare = in.readLine("Inserire il nome del intestatario del conto o dei conti da eliminare\n" +
//				        															  "(se tale intestatario ha più di un conto, tutti i suoi conti saranno eliminati).\n" +
//				        															  "Nome: ");
//					        	entitaBanca.eliminaConto(nomeIntestatarioContoDaEliminare);
//					        	System.out.println("Tutti i conti di " + nomeIntestatarioContoDaEliminare + " sono stati eliminati.");
//				        	}
//				        	else if (sceltaMenuEliminazioneConto == 3)
//				        	{
//				        		entitaBanca.eliminaConto((float) 0, "Meno");
//				        		System.out.println("Tutti i conti con saldo negativo sono stati eliminati.");
//				        	}
//				        	else if (sceltaMenuEliminazioneConto == 4)
//				        	{
//				        		entitaBanca.eliminaConto((float) 0, "Pari");
//				        		System.out.println("Tutti i conti con saldo zero sono stati eliminati.");
//				        	}
//				        	else if (sceltaMenuEliminazioneConto == 5)
//				        	{
//				        		boolean continuaLoop == true;
//				        		while(continuaLoop)
//				        		{
//				        			String confermaEliminazione = in.readLine("Confermi di voler eliminare tutti i conti? 'Y', 'N': ");
//				        			if(confermaEliminazione.equals("y") || confermaEliminazione.equals("Y"))
//				        			{
//					        			entitaBanca.eliminaConto();
//					        			System.out.println("Tutti i conti sono stati eliminati.");
//					        			continuaLoop == false;
//				        			}
//				        			else if(confermaEliminazione.equals("n") || confermaEliminazione.equals("N"))
//				        			{
//				        				continuaLoop == false;
//				        			}
//				        			else
//				        			{
//				        				System.out.println("Valore inserito non valido.");
//				        			}
//				        		}
//				        	}
//				        	else if (sceltaMenuEliminazioneConto == 6)
//				        	{
//				        		System.out.println("Tornando al menu gestione conto.");
//				        	}
//				        	else if (sceltaMenuEliminazioneConto == 7)
//				        	{
//				        		sceltaMenuGestioneConto = 6;
//				        		System.out.println("Tornando al menu principale.");
//				        	}
//				        	else
//					        {
//					        	System.out.println("Scelta non valida.");
//					        }
//			        	}
//			        }
//			        else if (sceltaMenuGestioneConto == 4)
//			        {
//			        	int dataGiornoOperazioneDaEseguireInput = in.readInt("Inserire la data dell'operazione da eseguire.\nGiorno:");
//			        	int dataMeseOperazioneDaEseguireInput = in.readInt("Mese:");
//			        	int dataAnnoOperazioneDaEseguireInput = in.readInt("Anno:");
//			        	Data dataOperazioneDaEseguireInput = new Data(dataGiornoOperazioneDaEseguireInput, dataMeseOperazioneDaEseguireInput, dataAnnoOperazioneDaEseguireInput);
//			        	float importoOperazioneDaEseguireInput = (float) in.readDouble("Inserire l'importo dell'operazione da eseguire. Usare \".\" come separatore decimale:");
//			        	boolean tipoDiOperazioneValid = false;
//			        	while(!tipoDiOperazioneValid)
//			        	{
//				        	String tipoDiOperazioneDaEseguireInput = in.readLine("Inserire il tipo di operazione da eseguire: Bonifico, Prelievo, Versamento\n");
//				        	if(tipoDiOperazioneDaEseguireInput.equals("Bonifico"))
//				        	{
//				        		tipoDiOperazioneValid = true;
//				        		
//				        		boolean contoInseritoEsiste = false;
//				        		boolean continuaLoop = true;
//				        		while(continuaLoop)
//				        		{
//				        			int coordinateBancaBeneficiarioBonificoInput = in.readInt("Inserire le coordinate del conto del beneficiario: ");
//				        			for(Conto ogniConto : elencoContiCorrenti)
//				        			{
//					        			if(ogniConto.getNumeroContoCorrente() == coordinateBancaBeneficiarioBonificoInput)
//					        			{
//					        				contoInseritoEsiste = true;
//					        				continuaLoop = false;
//					        			}
//				        			}
//				        			if(!contoInseritoEsiste)
//				        			{
//				        				boolean rimaniNelLoop = true;
//				        				System.out.println("Coordinate non parte dell'attuale banca.");
//				        				while(rimaniNelLoop)
//				        				{
//				        					rimaniNelLoop = false;
//						        			String confermaCoordinateCorrete = in.readLine("Confermi le coordinate siano corrette? 'Y', 'N': ");
//						        			if(confermaCoordinateCorrete.equals("y") || confermaCoordinateCorrete.equals("Y"))
//						        			{
//						        				contoInseritoEsiste = false;
//						        				continuaLoop = false;
//						        			}
//						        			else if (confermaCoordinateCorrete.equals("n") || confermaCoordinateCorrete.equals("N"))
//						        			{
//						        				contoInseritoEsiste = false;
//						        				continuaLoop = true;
//						        			}
//						        			else
//						        			{
//						        				System.out.println("Risposta non valida.");
//						        				rimaniNelLoop = true;
//						        			}
//				        				}
//				        			}
//				        		}
//				        		String causaleBonificoDaEseguire = in.readLine("Inserire la causale del bonifico da eseguire: ");
//				        		if(contoInseritoEsiste == true)
//				        		{
//				        			Bonifico bonificoEseguito = new Bonifico(int id,
//				        					                                 importoOperazioneDaEseguireInput,
//				        					                                 dataOperazioneDaEseguireInput,
//				        					                                 numeroContoCorrenteInput,
//				        					                                 coordinateBancaBeneficiarioBonificoInput,
//				        					                                 causaleBonificoDaEseguire);
//				        			elencoOperazioni.add // DOING
//				        		}
//				        	}
//				        	if(tipoDiOperazioneDaEseguireInput.equals("Prelievo"))
//				        	{
//				        		tipoDiOperazioneValid = true;
//				        	}
//				        	if(tipoDiOperazioneDaEseguireInput.equals("Versamento"))
//				        	{
//				        		tipoDiOperazioneValid = true;
//				        	}
//					        else
//					        {
//					        	System.out.println("Inserimento non valido.");
//					        }
//			        	}
//			        }
//			        else if (sceltaMenuGestioneConto == 5)
//			        {
//			        	// stampa tutte le operazioni.
//			        	// stampa stampa tutte le operazioni di un prescelto conto.
//			        	// stampa tutte le operazioni di un tipo scelto bonifico, prelievo, versamento.
//			        	// stampa stampa tutte le operazioni di un prescelto conto.
//			        }
//			        else if (sceltaMenuGestioneConto == 6)
//			        {
//			        	// stampare il saldo dei conti in ordine decrescente. 
//			        }
//			        else if (sceltaMenuGestioneConto == 7)
//			        {
//			        	System.out.println("Tornando al menu principale.");
//			        }
//			        else
//			        {
//			        	System.out.println("Scelta non valida.");
//			        }
//	        	}
//	        }
//	        else if (sceltaMenu == 3)
//	        {
//	        	// sottomenu per il caricamento e salvataggio dei dati.
//	        	// Caricamento dati da File.\n" +
//		        // "7. Salvataggio dati su File.\n"+
//	        }
//	        else if (sceltaMenu == 4)
//	        {
//	        	// leggi readme.txt
//	        }
//	        else if (sceltaMenu == 5)
//	        {
//	        	System.out.println("Chiusura programma.");
//	        }
//	        else
//	        {
//	        	System.out.println("Scelta non valida.");
//	        }
//		}
//	}
	public static Banca getEntitaBanca()
	{
		return entitaBanca;
	}

	public static void setEntitaBanca(Banca nomeDellaBanca)
	{
		TestGestoreBanca.entitaBanca = nomeDellaBanca;
	}
}
