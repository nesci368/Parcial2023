package ar.edu.unlam.pb2;

public class Avion {

	
	
	private Integer nroDeAvion;
	private Integer id = 0;
	private String modelo;
	private String fabricante;
	private Integer capacidad;
	private Pasajero [][] asientos;

	public Avion(Integer nroDeAvion, String modelo, String fabricante, Integer fila, Integer columna,
			Integer capacidad) {
		this.nroDeAvion = nroDeAvion;
		this.id++;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.capacidad = capacidad;
		this.asientos = new Pasajero[fila][columna];
	}

	public boolean asientoEstaOcupado(Integer fila, Integer columna, Pasajero pasajero) {

		if(asientos[fila][columna] != null) {
			return true;
		}else {
			return false;
		}
	}

	public boolean sentarPasajeros(Pasajero pasajero) {
		// TODO Auto-generated method stub
		Integer fila = asientos.length;
		Boolean seAsigno = false;
		for(int i = 0; i < asientos.length; i++) {
			for(int j = 0; j < asientos[0].length; j++) {
				if(asientos[i][j] == null ) {
					asientos[i][j] = pasajero;
					seAsigno = true;
					break;
				}
			}
		}
		return seAsigno;
	}

}
