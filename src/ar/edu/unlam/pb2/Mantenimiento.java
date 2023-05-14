package ar.edu.unlam.pb2;

public class Mantenimiento extends Personal {
	
	private String nombre;
	private String apellido;
	private Integer legajo;

	public Mantenimiento(String nombre, String apellido, Integer legajo) {
		// TODO Auto-generated constructor stub
		super(nombre, apellido, legajo);
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
	}
	
	

}
