*** SOLUZIONE FATTA DA ME A PARTIRE DALLA SOLUZIONE (OTTIMA) DI ROSSI METTHEW
*** ho modificato piccole cose e semplicato alcuni metodi (ad esempio i costruttori) per evitare codice duplicato e usare this...
*** ho messo anche le costanti al posto dei numeri


Package:
-(default package): 
	-Test: è la classe in cui vi è il main che prova il funzionamento dei metodi della classe StudioLegale
-eccezioni: Contiene tutte le eccezioni da me definite per la risoluzione dell' "applicazione" e tutte estendono RuntimeException
	-ClienteException
	-DescrizioneException
	-OverflowException
	-ProtocolloException
	-UdienzaException
-pratiche: contiene tutte le classi che rappresentano una pratica e i relativi enumerati
	-Pratica è la classe astratta che rappresenta una generica pratica, viene estesa dalle classi:
		-Penale  è la classe che rappresenta una pratica penale
		-Civile è la classe che rappresenta una pratica civile
		-COnciliazione è la classe che rappresenta una pratica conciliazione
-studioLegale: 
	-Cliente: è la classe che rappresenta l'utente che richiede la creazione della pratica
	-StudioLegale che come da testo contiene i 5 metodi richiesti ed è la classe principale
		-inserisci_pratica(Pratica) inserisce la pratica nella sequenza in ordine di priorità
		-pratiche_per_priorita() ritorna la stringa contenente i dati delle pratiche contenute nella sequenza(che sono già ordinate
		 per priorità)
		-pratiche_per_costo() ritona la stringa contenente i dati delle pratiche contenute nella sequenza attraverso un mergesort 
							  con criterio di scambio basato sui costi
		-pratiche_archiviate_per_costo() ritorna la stringa contenente i dati delle pratiche contenute nella sequenza attraverso un mergesort 
							  con criterio di scambio basato sui costi filtrando sulle pratiche ARCHIVIATE
		-StudioLegale(String) crea la sequenza ordinata a partire dai dati contenuti nel file
		
Il file che leggo deve seguire questo formato:
1. 'p','c','n' specificano il tipo di pratica p -> Penale, c -> Civile e n -> Conciliazione
2. Nome cliente
3. Congome cliente
4. Data di nascita cliente
5. Indirizzo di residenza del cliente
6. Descrizione della pratica
7. Data prossima udienza riferita alla pratica
8. Stato della pratica creato attraverso la chiamata .ordinal()
9. Ore di lavoro sulla pratica
10. GradoGiudizio della pratica creato attraverso la chiamata .ordinal()
Ogni dato deve essere separato dal successivo da un ';' e non da ' ' in modo chè l'applicazione non crei problemi con nomi
contenenti spazi
