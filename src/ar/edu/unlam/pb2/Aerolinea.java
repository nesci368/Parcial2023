package ar.edu.unlam.pb2;

import java.util.ArrayList;




public class Aerolinea {
	
	private String nombreAero;
	private Integer id = 0;
	private ArrayList<Vuelo> vuelos;
	private ArrayList<Avion> aviones;
	private ArrayList<Personal>personalCompania;
	private Personal[] pilotos = new Piloto[2];
	
	
	public Aerolinea(String nombreAero) {
	
		
		this.nombreAero = nombreAero;
		this.vuelos = new ArrayList<>();
		this.aviones = new ArrayList<>();
		this.personalCompania = new ArrayList<>();
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

	public Boolean validarQueSeaPiloto(Personal personalGeneral) {
		// TODO Auto-generated method stub
		Boolean esPiloto = false;
		for(int i = 0; i < pilotos.length; i++) {
			if(personalGeneral.getLegajo() > 0 && personalGeneral.getLegajo() <= 499) {
				esPiloto = true;
			}
			
		}return esPiloto;
	}

	public Boolean queLaCantidadDePilotosPorVueloNoSupereLaPermitida(Piloto piloto1, Piloto piloto2) {
		
		Boolean pilotosPermitidosPorVuelo = false;
		
		for(Personal pilotos : personalCompania) {
			
			if(personalCompania.size() < 2) {
				pilotosPermitidosPorVuelo = true;
			}
		}return pilotosPermitidosPorVuelo;
	}

	public void agregarPilotosAlVuelo(Piloto piloto1, Piloto piloto2, Vuelo vuelo) {
		// TODO Auto-generated method stub
		
		this.personalCompania.add(piloto1);
		this.personalCompania.add(piloto2);
		
	}
	
	public Integer getCantidadDePilotos() {
		
		return personalCompania.size();
	}
}
