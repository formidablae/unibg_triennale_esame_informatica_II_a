//package pratiche;
//
//import prog.utili.Data;
//import studioLegale.Cliente;
//
//public class PraticaConGradoGuidizio extends Pratica{
//
//	protected GradoGiudizio grado;
//
//	public PraticaConGradoGuidizio(Cliente richiedente, String descrizione, Data udienza, GradoGiudizio grado) {
//		super(richiedente, descrizione, udienza);
//		this.grado = grado;		
//	}
//	
//	/**
//	 * Vedi commento della superclasse
//	 */
//	public PraticaConGradoGuidizio(Cliente richiedente, String descrizione, Data udienza, Stato stato, int ore, GradoGiudizio grado) {
//		super(richiedente, descrizione, udienza,stato,ore);
//		this.grado = grado;
//	}
//
//	@Override
//	public int getCosto() {
//		return grado.getGrado()*ore*100;
//	}	
//
//	@Override
//	public String toString(){
//		String str = super.toString();
//		str += "\nGrado = " + grado;
//		return str;
//	}
//	
//}
