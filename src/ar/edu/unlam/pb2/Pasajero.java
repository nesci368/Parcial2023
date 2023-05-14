package ar.edu.unlam.pb2;

public class Pasajero {
	
	
	private String nombre;
	private String apellido;
	private Long dni;
	private String eMail;
	private Integer contadorDeArrobas = 0, contadorDePuntos = 0;
	
	
	public Pasajero(String nombre, String apellido, Long dni, String eMail) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.eMail = eMail;
		
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
	
	
	
}
