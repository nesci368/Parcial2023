package ar.edu.unlam.pb2;

import java.util.ArrayList;




public class Aerolinea {
	
	private String nombreAero;
	private Integer id = 0;
	private ArrayList<Vuelo> vuelos;
	private ArrayList<Avion> aviones;
	private ArrayList<Personal>personalCompania;
	private ArrayList<Pasajero>pasajeros;
	private Personal[] pilotos = new Piloto[2];
	private final Double precioPremium = 700000.0;
	private final Double precioComercial = 450000.0;
	
	public Aerolinea(String nombreAero) {
	
		
		this.nombreAero = nombreAero;
		this.vuelos = new ArrayList<>();
		this.aviones = new ArrayList<>();
		this.personalCompania = new ArrayList<>();
		this.pasajeros = new ArrayList<>();
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

	public Boolean validarQueSeaAzafata(Personal personalGeneral) {
		
		Boolean esAzafata = false;
		for (Personal azafata : personalCompania) {
			if(personalGeneral.getLegajo() >= 500 && personalGeneral.getLegajo() <= 999) {
				esAzafata = true;
			} else {
				esAzafata = false;
			}
		}
		
		return esAzafata;
		
	}

	public void agregaAzafatasAlVuelo(Azafata personal3, Azafata personal4, Azafata personal5, Azafata personal6,
			Vuelo vuelo) {
		
		personalCompania.add(personal3);
		personalCompania.add(personal4);
		personalCompania.add(personal5);
		personalCompania.add(personal6);
		
	}
	
	public Integer getCantidadDeAzafatas() {
		return personalCompania.size();
	}

	public void agregarPersonalDeMantenimientoALaAerolinea(Mantenimiento personal8, Mantenimiento personal9,
			Mantenimiento personal7, Mantenimiento personal10, Mantenimiento personal11) {
		// TODO Auto-generated method stub
		
		personalCompania.add(personal7);
		personalCompania.add(personal8);
		personalCompania.add(personal9);
		personalCompania.add(personal10);
		personalCompania.add(personal11);
		
	}
	
	public Integer getCantidadDePersonalDeMantenimiento() {
		return personalCompania.size();
	}

	public boolean validarQueSeaPersonalDeMantenimiento(Mantenimiento personal7, Mantenimiento personal8,
			Mantenimiento personal9, Mantenimiento personal10, Mantenimiento personal11, Vuelo vuelo,
			Personal personalGeneral) {
		Boolean esPersonalDeMantenimiento = false;
		for (Personal mantenimiento : personalCompania) {
			if(personalGeneral.getLegajo() >= 1000 && personalGeneral.getLegajo() <= 2000) {
				esPersonalDeMantenimiento = true;
			} else {
				esPersonalDeMantenimiento = false;
			}
		}
		
		return esPersonalDeMantenimiento;
	}

	public boolean comprarVuelo(Pasajero pasajero, Vuelo vuelo, Integer fila, Integer columna) {

		Vuelo vueloEncontrado = buscarVueloPorId(vuelo.getId());
		Integer posicion = 0;
		Boolean estado = false;
		
		for (Vuelo vueloBuscado : vuelos) {
			if(vueloBuscado.getId() == vueloEncontrado.getId()) {
				break;
			}
			
			posicion++;
		}
		
		
		if(vuelos.get(posicion).asientoDisponible(pasajero,fila,columna)) {
			if (fila == 1 || fila == 2 && pasajero.getDineroDisponible() >= precioPremium) {
				pasajero.setComproPremium(true);
			} else {
				pasajero.setComproPremium(false);
			}
			
			pasajero.setVueloComprado(vuelos.get(posicion).getId());
			
			return true;
		}
		
		
		return false;
	}

	public void agregarPasajeros(Pasajero pasajero) {
		// TODO Auto-generated method stub
		this.pasajeros.add(pasajero);
		
	}

	public Boolean subirPasajeros(Vuelo vuelo) {
		
		Vuelo vueloEncontrado = buscarVueloPorId(vuelo.getId());
		Integer posicion = 0;
		
		Boolean estado = false;
		
		for(Vuelo vueloBuscado : vuelos) {
			if(vueloBuscado.getId() == vueloEncontrado.getId()) {
				break;
			}
			
			posicion++;
		}
		for(Pasajero pasajero : this.pasajeros) {
			if(pasajero.getPasaporte()) {
				if(pasajero.getVueloComprado() == vuelos.get(posicion).getId()) {
					vuelos.get(posicion).getAvion().sentarPasajeros(pasajero);
					
					estado = true;
				}
			}
		}
		
		if(estado == true) {
			vuelos.get(posicion).setCosasListas(vuelos.get(posicion).getCosasListas()+1);
		}
		return estado;
	}
}
