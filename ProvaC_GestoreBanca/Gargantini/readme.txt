======= SOLUZIONE PROPOSTA DAL PROFESSSORE
======= DALLA SOLUZIONE DI FORLINI NICCOLO'


PACKAGE OPERAZIONIBANCARIE
Per gestire le operazioni bancarie ho creato una classe astratta OperazioneBancaria che includesse tutti i parametri condivisi indicati dalla consegna, 
come dataOperazione, numeroConto, importo e costoOperazione.
Prima di creare un nuovo oggetto di OperazioneBancaria, il costruttore verifica che il numero del conto passato e l'importo siano entrambi positivi, 
altrimenti viene sollevata un'eccezione (più precisamente una RuntimeException) che impedisce di proseguire.
Ho creato anche un metodo stampaNumeroconto, che restituisce il numero del conto corrente che invoca il metodo, e getImporto, che restituisce invece il saldo.
Per descrivere l'operazione ho creato un metodo descOperazione() che restituisce una stringa contenente tutte le informazioni relative all'operazione bancaria in questione.
Infine, ho dichiarato il metodo getCosto abstract così da poterlo ridefinire nelle sottoclassi che estendono OperazioneBancaria.
Le classi Bonifico, Prelievo e Versamento estendono la classe OperazioneBancaria, e per definire i metodi/tipologie di prelievo e 
di versamento mi sono affidato agli enumerativi (mi risultava più semplice, per esempio, creare un oggetto Prelievo passando un integer per indicare 
il metodo e poi usare il metodo TipoPrelievo.values()[integer]).


PACKAGE CONTOCORRENTE
In questo Package ho inserito la classe Banca, che include tutti i metodi della consegna, e la classe Conto.
La classe Conto presenta una variabile statica intera che consente di assegnare a ogni conto corrente un numero identificativo diverso tramite 
il costruttore Conto(String Intestatario). L'altro costruttore l'ho creato per permettere la creazione dei conti corrente da file, 
in modo da consentire l'impostazione del numero del conto e del saldo (vedere sotto per il formato del file che viene letto).
La classe Banca presenta tutte le funzionalità richieste dalla consegna (vedere il commento in javadoc per ognuna di esse).

NB: Per organizzare Conti e Operazioni ho utilizzato in entrambi i casi una struttura dati dinamica (Vector).


PACKAGE ECCEZIONI
In questo package ho raccolto tutte le eccezioni necessarie al controllo dei dati forniti, come il nome dell'intestatario del conto, la cui lunghezza deve essere maggiore di 0, o il numero del conto corrente passato a un'operazione bancaria.


PACKAGE MAINDIPROVA
Ho creato un main in Prova.java per creare dei conti correnti a caso (ho semplicemente utilizzato il costruttore Conto(String Intestatario) assegnando dei nomi come Utente 1, Utente 2 ecc. Successivamente ho testato subito il metodo per stampare tutti i conti correnti, e iniziato a creare le prime operazioni bancarie. Ho  provato a creare un oggetto per i vari tipi, e poi ad eseguirli con il metodo della classe Banca chiamato eseguiOperazione(). Questo metodo controlla con un instanceof il tipo di operazione richiesta (riceve come parametro una generica OperazioneBancaria), e a seconda di questa svolge un compito preciso. Per il prelievo e il versamento mi è bastato creare un iterator del vector e scorrerlo finché non trovavo il conto da me scelto. Utilizzo una variabile booleana "trovato" che imposto a true una volta che ho trovato il conto (se non lo trovo lancio un'eccezione) e successivamente reimposto i valori saldo e aggiungo l'operazione alla lista delle operazioni del conto.

Successivamente ho stampato la lista in ordine di saldo (ordinandola con Collections.sort) e stampato i movimenti in ordine di data. Per la data ho utilizzato il prog.utili così da velocizzare il confronto tra una data e l'altra (metodo quantomanca()).

La lettura da file ho inizialmente voluto testarla in un main a parte (presente in ProvaLetturaDaFile) e successivamente l'ho implementata nel main presente in Prova.java.

----------

FORMATO DEL FILE DA LEGGERE
Ogni riga del file "letturaContidaFile.txt" corrisponde a un conto differente. La lettura avviene riga per riga, e tramite il metodo split la divido in tante parti quanti sono i punti e virgola presenti.
Il primo campo che viene letto corrisponde al numero del conto, il secondo al nome dell'intestatario e il terzo al saldo del conto stesso. 

ESEMPIO:
"150;NomeDaFile1;160"

Lo split creerà un vettore di String che ho chiamato dati, e, tramite il costruttore, verrà creato un nuovo oggetto Conto con le seguenti caratteristiche:
ID: 150
Intestatario: NomeDaFile1
Saldo: 160

