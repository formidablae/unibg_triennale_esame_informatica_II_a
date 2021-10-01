package unibg.gestoremuseo;

import java.util.ArrayList;

import prog.utili.Data;
import prog.utili.SequenzaOrdinata;

//public class GestoreEventi {
//	private SequenzaOrdinata<Evento> eventi;
//	
//	public GestoreEventi() {
//		eventi = new SequenzaOrdinata<Evento>();
//	}
//
//	public boolean inserisciEvento(Evento newEv) {
//		Data now = new Data();
//		Data inizioNewEv = newEv.getInizio();
//		Data fineNewEv = newEv.getFine();
//		if(inizioNewEv.isMaggiore(now)) {
//			for(Risorsa r: newEv.getRisorse()) {
//				for(Evento ev: eventi) {
//					Data inizioEv = ev.getInizio();
//					Data fineEv = ev.getFine();
//					ArrayList<Risorsa> risorseEv = ev.getRisorse();
//					if((inizioNewEv.isMaggiore(inizioEv) && inizioNewEv.isMinore(fineEv)) ||
//					   (inizioEv.isMaggiore(inizioNewEv) && inizioEv.isMinore(fineNewEv))) {
//						if(risorseEv.contains(r)) {
//							return false;
//						}
//					}
//				}
//			}
//			eventi.add(newEv);
//			return true;
//		}
//		return false;
//	}
//
//	public double costoEvento(Evento evento) {
//		int durataEvGiorni = evento.getInizio().quantoManca(evento.getFine());
//		double costo = 0;
//		for(Risorsa r: evento.getRisorse()) {
//			if(r instanceof Personale) {
//				int costoAlGiorno = ((Personale)r).getCostoAlGiorno();
//				costo = costo + costoAlGiorno*durataEvGiorni;
//			}
//			if(r instanceof Quadro) {
//				int costoAsettimana = ((Quadro)r).getCostoSettimana();
//				costo = costo + (costoAsettimana/7.0)*durataEvGiorni; 
//			}
//		}
//		return costo;
//	}
//
//	public void setupUbicazioniGiornataOdierna() {
//		Data today = new Data();
//		for(Evento e: eventi) {
//			Data dataInizio = e.getInizio();
//			Data dataFine = e.getFine();
//			if(today.equals(dataInizio) || today.equals(dataFine) ||
//					(today.isMaggiore(dataInizio) && today.isMinore(dataFine))) {
//				//TODO
//			}
//		}
//	}
//
//	public void stampaEventiProgrammati() {
//		for(Evento e: eventi) {
//			System.out.println(e.getTitolo() + " da " + e.getInizio() + " a " + e.getFine());
//			System.out.println("RISORSE:");
//			for(Risorsa r: e.getRisorse()) {
//				System.out.println(" " + r);
//			}
//			System.out.println();
//		}
//	}
//}