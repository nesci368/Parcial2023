package ar.edu.unlam.pb2;

public class Avion {

	
	
	private Integer nroDeAvion;
	private Integer id = 0;
	private String modelo;
	private String fabricante;
	private Integer capacidad;

	public Avion(Integer nroDeAvion, String modelo, String fabricante, Integer fila, Integer columna,
			Integer capacidad) {
		this.nroDeAvion = nroDeAvion;
		this.id++;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.capacidad = capacidad;
		
	}

}
