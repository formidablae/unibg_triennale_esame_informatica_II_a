package prenotazioni;

public enum TipoVisita {
	VACCINO("Vaccino"), MALATTIA_CRONICA("Malattia Cronica"), MALATTIA("Malattia");
	private String tipoEnum;

	private TipoVisita(String tipoEnum) {
		this.tipoEnum = tipoEnum;
	}

	public String getTipo() {
		return this.tipoEnum;
	}

}
