//package pratiche;
//
//import prog.utili.Data;
//import studioLegale.Cliente;
//
//public class Civile extends PraticaConGradoGuidizio{
//
//	private static final int COSTO_H_CIVILE = 100;
//
//	public Civile(Cliente richiedente, String descrizione, Data udienza, GradoGiudizio grado) {
//		super(richiedente, descrizione, udienza,grado);
//	}
//	
//	/**
//	 * Vedi commento della superclasse
//	 */
//	public Civile(Cliente richiedente, String descrizione, Data udienza, Stato stato, int ore, GradoGiudizio grado) {
//		super(richiedente, descrizione, udienza,stato,ore,grado);
//	}
//
//	@Override
//	public int getCosto() {
//		return grado.getGrado()*ore*COSTO_H_CIVILE;
//	}	
//
//	@Override
//	public String toString(){
//		String str = super.toString();
//		str += "\tCIVILE";
//		return str;
//	}
//	
//}
