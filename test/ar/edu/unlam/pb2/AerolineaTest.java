package ar.edu.unlam.pb2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AerolineaTest {

	
	@Test
	public void crearAerolinea() {
		String nombreAero = "Despegar";
		Integer aerolineaId = 1;
		
		Aerolinea aerolinea = new Aerolinea(nombreAero);
		
		assertEquals(aerolineaId, aerolinea.id());
	}
	
	@Test
	public void queSePuedaRegistrarUnUsuarioEnElSistemaValidandoLosDatos() {
		String nombre = "RAmiro";
		String apellido = "Valdez";
		Long dni = 44259234l;
		String eMail = "valdezramiro2002@gmail.com";
		Pasajero usuarios;
		String nombreAero = "Despegar";
		Aerolinea aerolinea;
		
		usuarios = new Pasajero(nombre,apellido,dni,eMail);
		aerolinea = new Aerolinea(nombreAero);
		
		assertTrue(usuarios.validarDatosDelPasajeroParaQuePuedaRegistrarse(usuarios));
	}
	
}
