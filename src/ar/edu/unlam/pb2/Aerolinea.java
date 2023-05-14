package ar.edu.unlam.pb2;

public class Aerolinea {
	
	private String nombreAero;
	private Integer id = 0;
	
	public Aerolinea(String nombreAero) {
	// TODO Auto-generated constructor stub
		this.nombreAero = nombreAero;
	
	}

	/**
	 * @return the nombreAero
	 */
	public String getNombreAero() {
		return nombreAero;
	}

	/**
	 * @param nombreAero the nombreAero to set
	 */
	public void setNombreAero(String nombreAero) {
		this.nombreAero = nombreAero;
	}

	/**
	 * @return the id
	 */
	public Integer id() {
		return ++id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	
}
