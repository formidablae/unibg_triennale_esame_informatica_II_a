import java.util.Random;
import prog.utili.Sequenza;

class Conto
{
	// Campi
	int numeroContoCorrente; // > 0
	String intestatarioConto;
	static float saldo; // <>= 0
	Sequenza<Operazione> operazioni;
	
	// Costruttori
	Conto() // Conto creato con intestatario vuoto.
	{
		intestatarioConto = "";
		saldo = 0;
		numeroContoCorrente = definizioneNumeroUnivocoConto();
	}
	
	Conto(String intestatario)
	{
		intestatarioConto = intestatario;
		saldo = 0;
		numeroContoCorrente = definizioneNumeroUnivocoConto();
	}

	// Metodi
	int getNumeroContoCorrente()
	{
		return numeroContoCorrente;
	}
	
	private void setNumeroContoCorrente(int nuovoNumeroContoCorrente)
	{
		this.numeroContoCorrente = nuovoNumeroContoCorrente;
	}
	
	String getIntestatario()
	{
		return intestatarioConto;
	}
	
	private void setIntestatario(String nuovoIntestatario)
	{
		this.intestatarioConto = nuovoIntestatario;
	}
	
	float getSaldo()
	{
		return saldo;
	}
	
	private void setSaldo(float nuovoSaldo)
	{
		this.saldo = nuovoSaldo;
	}
	
	static void updateSaldo(float somma)
	{
		saldo = saldo + somma;
	}
	
	private int definizioneNumeroUnivocoConto()
	{
		boolean contoEsistente = true;
		int numeroContoRandom = 0;
		Random rand = new Random();
		while(contoEsistente){
			contoEsistente = false;
			numeroContoRandom = rand.nextInt(1000000) + 1;
			
			for (int i = 0; i < Banca.elencoContiCorrenti.size(); i++) {
				if ( Banca.elencoContiCorrenti.get(i).getNumeroContoCorrente() == numeroContoRandom) {
					contoEsistente = true;
					break;
				}
			}
		}
		return numeroContoRandom;
	}

}
