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
	
	@Test
	public void queAVueloSeLePuedaAsignarUnAvion() {
		
		String origen = "Buenos Aires";
		String destino = "Cancun";
		Integer nro = 12;
		LocalDate fecha = LocalDate.of(2022, Month.MAY, 04);
		LocalTime hora = LocalTime.of(9, 30);
		
		Integer nroDeAvion = 520;
		String modelo = "Boing 747";
		String fabricante = "Airbuss";
		Integer capacidad = 200;
		Integer fila = 10;
		Integer columna = 20;
		
		Avion avion = new Avion(nroDeAvion, modelo, fabricante,fila,columna,capacidad);
		
		Vuelo vuelo = new Vuelo(nro,fecha,hora,origen,destino);
		
		String nombre = "Despegar";
		
		Aerolinea aerolinea = new Aerolinea(nombre);
		
		aerolinea.agregarVuelo(vuelo);
		
		aerolinea.agregarAvion(avion,vuelo.getId());
		
		assertEquals(avion, aerolinea.buscarVueloPorId(vuelo.getId()).getAvion());
	}
	
	@Test
	public void queSePuedaValidarUnPilotoYQueAUnVueloNoPuedanAsignarseMasDeDosPilotos() {
		
		String nombre = "Julian";
		String apellido = "Forza";
		Integer legajo = 102;
		Integer horasDeVuelo = 100;
		Personal personalGeneral;
		Piloto piloto1 = new Piloto("Julian", "Forza", 102, 1000);
		Piloto piloto2 = new Piloto("Julian", "Hown", 103, 1000);
		String origen = "Buenos Aires";
		String destino = "Cancun";
		Integer nro = 12;
		LocalDate fecha = LocalDate.of(2022, Month.MAY, 04);
		LocalTime hora = LocalTime.of(9, 30);
		Integer nroDeAvion = 520;
		String modelo = "Boing 747";
		String fabricante = "Airbuss";
		Integer capacidad = 200;
		Integer fila = 20;
		Integer columna = 10;
		Avion avion = new Avion(nroDeAvion, modelo, fabricante, capacidad, fila, columna);
		Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);
		String nombreAero = "Despegar";
		Aerolinea aerolinea = new Aerolinea(nombreAero);
		personalGeneral = new Personal(nombre, apellido, legajo);
		aerolinea.agregarVuelo(vuelo);
		aerolinea.agregarAvion(avion, vuelo.getId());
		
		aerolinea.validarQueSeaPiloto(personalGeneral);
		
		aerolinea.queLaCantidadDePilotosPorVueloNoSupereLaPermitida(piloto1, piloto2);
		
		aerolinea.agregarPilotosAlVuelo(piloto1, piloto2, vuelo);
		
		Integer cantDePilotos = 2;
		
		assertTrue(aerolinea.validarQueSeaPiloto(personalGeneral));
		assertEquals(cantDePilotos, aerolinea.getCantidadDePilotos());
		
		
				
	}
}
