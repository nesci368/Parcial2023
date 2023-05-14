package ar.edu.unlam.pb2;

import java.util.ArrayList;




public class Aerolinea {
	
	private String nombreAero;
	private Integer id = 0;
	private ArrayList<Vuelo> vuelos;
	private ArrayList<Avion> aviones;
	public Aerolinea(String nombreAero) {
	
		
		this.nombreAero = nombreAero;
		this.vuelos = new ArrayList<>();
		this.aviones = new ArrayList<>();
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

	public void agregarVuelo(Vuelo vuelo) {
		this.vuelos.add(vuelo);
		
	}

	public void agregarAvion(Avion avion, Integer vueloId) {
		
		Vuelo vueloEncontrado = buscarVueloPorId(vueloId);

		if (vueloEncontrado != null) {
			vueloEncontrado.setAvion(avion);
			this.aviones.add(avion);
			vueloEncontrado.setCosasListas((vueloEncontrado.getCosasListas()) + 1);
		
		}

	
	}

	public Vuelo buscarVueloPorId(Integer idVuelo) {
		for (Vuelo vuelo : vuelos) {
			if (vuelo.getId().equals(idVuelo)) {
				return vuelo;
			}
		}

		return null;
	}
}
