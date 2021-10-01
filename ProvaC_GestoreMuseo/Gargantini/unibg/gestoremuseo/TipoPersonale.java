package unibg.gestoremuseo;

public enum TipoPersonale {
	TEMPORANEO(50), AUSILIARIO(70), STABILE(100);

	private int costoAlGiorno;

	private TipoPersonale(int costoAlGiorno) {
		this.costoAlGiorno = costoAlGiorno;
	}

	public int getCostoAlGiorno() {
		return costoAlGiorno;
	}
}