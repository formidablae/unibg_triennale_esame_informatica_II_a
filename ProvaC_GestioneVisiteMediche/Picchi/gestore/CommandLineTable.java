package gestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Permette di incorniciare un output come una tabella.
 * <br>
 * È possibile specificare varie opzioni
 * <p>
 * Separatori (e valore di default)
 * <ul>
 * <li>Orizzontale: -</li>
 * <li>Verticale: |</li>
 * <li>Congiunzione: +</li>
 * </ul>
 * <p>
 * Allineamento a destra (True di default)
 * @author Federico Picchi
 * @version 1.0
 */
public class CommandLineTable {
    private String horizontalSep = "-";
    private String verticalSep = "|";
    private String joinSep = "+";
    private String[] headers;
    private List<String[]> rows = new ArrayList<>();
    private boolean rightAlign = true;
    private boolean showVerticalLines;
    private boolean showJoinSep = true;

    /**
     * Di default non mostra linee verticali. 
     */
    public CommandLineTable() {
        setShowVerticalLines(false);
    }
    /**
     * Crea una nuovo oggetto specificando esplicitamente se utilizzare o meno i separatori verticali
     * @param showVerticalLines true per far visualizzare i separatori delle colonne, false altrimenti
     */
    public CommandLineTable(boolean showVerticalLines) {
        setShowVerticalLines(showVerticalLines);
    }
    
    /**
     * Crea una nuovo oggetto specificando esplicitamente i separatori<br>
     * Attiva nel contempo tutti i separatori
     * @param verticalSep carattere da usare come separatore per le colonne
     * @param horizontalSep carattere da usare come separatore per le righe
     * @param joinSep carattere da usare come congiunzione
     */
    public CommandLineTable(char verticalSep,char horizontalSep,char joinSep) {
        setShowVerticalLines(verticalSep);
        setHorizontalSep(horizontalSep);
        setShowJoinSep(joinSep);
    }
    
    /**
     * Imposta il carattere da utilizzare per separare le righe.
     * @param horizontalSep carattere da usare come separatore orizzontale 
     */
    public void setHorizontalSep(char horizontalSep) {
		this.horizontalSep = Character.toString(horizontalSep);
		
	}
	public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }
    
    /**
     * Attiva o disattiva i separatori verticali
     * @param showVerticalLines true per far visualizzare i separatori delle colonne, false altrimenti
     */
    public void setShowVerticalLines(boolean showVerticalLines) {
    	this.showVerticalLines = showVerticalLines;
    }
    /**
     * Imposta che carattere usare per separare le colonne.
     * <br>
     * Attiva nel contempo i separatori verticali.
     * @param verticalSep carattere da usare come separatore per le colonne
     */
    public void setShowVerticalLines(char verticalSep) {
    	this.showVerticalLines = true;
    	this.verticalSep = Character.toString(verticalSep);
    }
    
    /**
     * Attiva o disattiva i caratteri di congiunzione
     * @param showVerticalLines true per far visualizzare i caratteri di congiunzione, false altrimenti
     */
    public void setShowJoinSep(boolean showJoinSep) {
    	this.showJoinSep = showJoinSep;
    }
    /**
     * Imposta che carattere usare le congiunzioni.
     * <br>
     * Attiva nel contempo le congiunzioni e le righe verticali
     * @param joinSep carattere da usare come congiunzione
     */
    public void setShowJoinSep(char joinSep) {
    	this.showJoinSep = true;
    	this.joinSep = Character.toString(joinSep);
    	setShowVerticalLines(true);
    }
    
    /**
     * Imposta le testate della tabella (colonne).
     * @param headers tutte le testate da mettere nella tabella.
     */
    public void setHeaders(String... headers) {
        this.headers = headers;
    }
    /**
     * Aggiunge i dati di una riga per la tabella
     * @param cells i dati della riga
     */
    public void addRow(String... cells) {
        rows.add(cells);
    }

    /**
     * Stampa la tabella.
     * @throws 
     */
    public void print(){
        int[] maxWidths = headers != null ?
                Arrays.stream(headers).mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Ogni riga dovrebbe avere un valore per ogni colonna");
            }
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        if (headers != null) {
            printLine(maxWidths);
            printRow(headers, maxWidths);
            printLine(maxWidths);
        }
        for (String[] cells : rows) {
            printRow(cells, maxWidths);
        }
        if (headers != null) {
            printLine(maxWidths);
        }
    }

    private void printLine(int[] columnWidths) {
    	String joinSep = this.showJoinSep ? this.joinSep : horizontalSep;
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    2, horizontalSep));
            System.out.print(joinSep + line + (i == columnWidths.length - 1 ? joinSep : ""));
        }
        System.out.println();
    }

    private void printRow(String[] cells, int[] maxWidths) {
    	String verticalSep = this.showVerticalLines ? this.verticalSep:"";
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalSep : "";
            if (rightAlign) {
                System.out.printf("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            } else {
                System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            }
        }
        System.out.println();
    }
}