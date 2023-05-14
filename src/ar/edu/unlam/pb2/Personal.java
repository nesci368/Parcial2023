package ar.edu.unlam.pb2;

public class Personal {
	
	

	private String nombre;
	private String apellido;
	private Integer legajo;

	public Personal(String nombre, String apellido, Integer legajo) {
		// TODO Auto-generated constructor stub
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the legajo
	 */
	public Integer getLegajo() {
		return legajo;
	}

	/**
	 * @param legajo the legajo to set
	 */
	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}
	
	
	

}
