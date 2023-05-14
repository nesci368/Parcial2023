package ar.edu.unlam.pb2;

public class Pasajero {
	
	
	private String nombre;
	private String apellido;
	private Long dni;
	private String eMail;
	private Integer contadorDeArrobas = 0, contadorDePuntos = 0;
	private Boolean pasaporte = false;
	private Double dineroDisponible;
	private Boolean comproPremium;
	private Integer vueloComprado = 0;
	
	
	

	public Pasajero(String nombre, String apellido, Long dni, String eMail) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.eMail = eMail;
		
	}

	public Pasajero(Boolean pasaporte, Double dineroDisponible) {
		this.setPasaporte(pasaporte);
		this.dineroDisponible = dineroDisponible;
	}

	public Boolean getComproPremium() {
		return comproPremium;
	}

	public void setComproPremium(Boolean comproPremium) {
		this.comproPremium = comproPremium;
	}

	public Double getDineroDisponible() {
		return dineroDisponible;
	}

	public void setDineroDisponible(Double dineroDisponible) {
		this.dineroDisponible = dineroDisponible;
	}
	public void setVueloComprado(Integer vueloComprado) {
		this.vueloComprado  = vueloComprado;
	}
	
	public Integer getVueloComprado() {
		return vueloComprado;
	}
	
	public Boolean validarDatosDelPasajeroParaQuePuedaRegistrarse(Pasajero usuarios) {
		
		for (int i = 0; i < eMail.length(); i++) {
			if (eMail.charAt(i) == '@') {
				contadorDeArrobas++;
			}
			if (eMail.charAt(i) == '.') {
				contadorDePuntos++;
			}
		}
		if (contadorDePuntos >= 1 && contadorDeArrobas == 1) {
			return true;
		} else {
			return false;
		}
		
	}

	public Boolean getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(Boolean pasaporte) {
		this.pasaporte = pasaporte;
	}
	
	
	
}
