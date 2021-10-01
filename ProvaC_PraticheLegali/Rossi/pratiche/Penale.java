//package pratiche;
//
//import prog.utili.Data;
//import studioLegale.Cliente;
//
///** pratica penale*/
//
//public class Penale extends PraticaConGradoGuidizio{
//	
//
//	private static final int COSTO_H_PENALE = 120;
//
//	public Penale(Cliente richiedente, String descrizione, Data udienza, GradoGiudizio grado) {
//		super(richiedente, descrizione, udienza,grado);
//	}
//	
//	/**
//	 * Vedi commento della superclasse
//	 */
//	public Penale(Cliente richiedente, String descrizione, Data udienza, Stato stato, int ore, GradoGiudizio grado) {
//		super(richiedente, descrizione, udienza,stato,ore,grado);
//	}
//
//	@Override
//	public int getCosto() {
//		return grado.getGrado()*ore*COSTO_H_PENALE;
//	}
//	
//	@Override
//	public String toString(){
//		String str = super.toString();
//		str += "\tPENALE";
//		return str;
//	}
//	
//}
