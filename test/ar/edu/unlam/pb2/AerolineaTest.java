package ar.edu.unlam.pb2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

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
	
	@Test
	public void queSePuedaCrearUnVuelo() {
		String origen = "Buenos Aires";
		String destino = "Cancun";
		Integer nro = 12;
		LocalDate fecha = LocalDate.of(2023, Month.MAY, 04);
		LocalTime hora = LocalTime.of(9, 30);
		
		Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);
				
		Integer idVuelo = 1;
		assertEquals(idVuelo, vuelo.getId());
	}
	
}
