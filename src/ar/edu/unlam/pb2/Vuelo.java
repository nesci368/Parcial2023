package ar.edu.unlam.pb2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Vuelo {
	
	private Integer nroDeVuelo;
	private LocalDate fecha;
	private LocalTime hora;
	private String destino;
	private String origen;
	private Integer id = 0;
	private Avion avion;
	private Integer cosasListas = 0;
	private List<Personal> personal;
	

	
	public Vuelo(Integer nro, LocalDate fecha, LocalTime hora, String origen, String destino) {
		// TODO Auto-generated constructor stub
		
		this.nroDeVuelo = nro;
		this.fecha = fecha;
		this.hora = hora;
		this.destino = destino;
		this.origen = origen;
		this.id++;
		this.personal = new ArrayList<>();
		
	}
	
	public Integer getCosasListas() {
		return cosasListas;
	}
	public void setCosasListas(Integer cosasListas) {
		this.cosasListas = cosasListas;
	}
	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	/**
	 * @return the nroDeVuelo
	 */
	public Integer getNroDeVuelo() {
		return nroDeVuelo;
	}

	/**
	 * @param nroDeVuelo the nroDeVuelo to set
	 */
	public void setNroDeVuelo(Integer nroDeVuelo) {
		this.nroDeVuelo = nroDeVuelo;
	}

	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the hora
	 */
	public LocalTime getHora() {
		return hora;
	}

	/**
	 * @param hora the hora to set
	 */
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean asientoDisponible(Pasajero pasajero, Integer fila, Integer columna) {
		
		if (this.avion.asientoEstaOcupado(fila,columna, pasajero) == false) {

			return true;
		}

		return false;
	}

	public void agregarPersonalAlVuelo(Personal personal) {
		this.personal.add(personal);
		
	}

	public List getPersonal() {
		// TODO Auto-generated method stub
		return personal;
	}
	
	
	

}
