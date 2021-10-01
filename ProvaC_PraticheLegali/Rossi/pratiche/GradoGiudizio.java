package pratiche;

public enum GradoGiudizio {
	PRIMO(1),APPELLO(2),CASSAZIONE(3);
	
	private int grado;
	
	private GradoGiudizio(int grado){
		this.grado = grado;
	}
	
	public int getGrado(){//potrei sostituire con ordinal()+1
		return grado;
	}
	
}
