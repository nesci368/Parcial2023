package ar.edu.unlam.pb2;
import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

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
	
	@Test
	public void quenosepuedanasignarmasde4azafatasAUnVueloYQueSePuedaValidarSegunElNumeroDeLegajoSiEsAzafata() {
		String nombre ="Julieta";
		String apellido = "Hernandez";
		Integer legajo = 501;
		Personal personalGeneral;
		Azafata personal3 = new Azafata("Julieta","Hernandez",501);
		Azafata personal4 = new Azafata("Maria","Hown",502);
		Azafata personal5 = new Azafata("Julieta","Hown",503);
		Azafata personal6 = new Azafata("Julian","Hown",504);
		String origen = "Buenos Aires";
		String destino = "Cancun";
		Integer nro = 12;
		LocalDate fecha = LocalDate.of(2022, Month.MAY, 04);
		LocalTime hora = LocalTime.of(9, 30);
		String nombreAero = "Despegar";
		Aerolinea aerolinea = new Aerolinea(nombreAero);
		Integer nroDeAvion = 520;
		String modelo = "Boing 747";
		String fabricante = "Airbuss";
		Integer capacidad = 200;
		Integer fila = 20;
		Integer columna = 10;
		Avion avion = new Avion(nroDeAvion, modelo, fabricante, capacidad, fila, columna);

		Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);
		personalGeneral = new Personal(nombre, apellido, legajo);
		
		aerolinea.agregarVuelo(vuelo);
		aerolinea.agregarAvion(avion, vuelo.getId());
		aerolinea.validarQueSeaAzafata(personalGeneral);
		aerolinea.agregaAzafatasAlVuelo(personal3, personal4, personal5, personal6, vuelo);
		Integer cantPersonal = 4;
		
		assertEquals(cantPersonal, aerolinea.getCantidadDeAzafatas());
	}
	
	@Test
	public void queSePuedaAsignarPersonalDeMantenimientoAUnVueloYQueSePuedaValidarSegunElNumeroDeLegajoSiEsDeMantenimiento() {
		
		String nombre = "Pablo";
		String apellido = "Juarez";
		Integer legajo = 1001;
		Personal personalGeneral;
		Mantenimiento personal7;
		Mantenimiento personal8;
		Mantenimiento personal9;
		Mantenimiento personal10;
		Mantenimiento personal11;
		
		personal7 = new Mantenimiento("Pablo", "Juarez", 1001);
		personal8 = new Mantenimiento("Leandro", "Pirez", 1005);
		personal9 = new Mantenimiento("Ramiro", "Valdez", 1007);
		personal10 = new Mantenimiento("Alberto", "Rodriguez", 1100);
		personal11 = new Mantenimiento("Diego", "Agudo",1500);
		
		String origen = "Buenos Aires";
		String destino = "Cancun";
		Integer nro = 12;
		LocalDate fecha = LocalDate.of(2022, Month.MAY, 04);
		LocalTime hora = LocalTime.of(9, 30);
		String nombreAero = "Humanos unidos";
		Aerolinea aerolinea = new Aerolinea(nombreAero);
		Integer nroDeAvion = 520;
		String modelo = "Boing 747";
		String fabricante = "Airbuss";
		Integer capacidad = 200;
		Integer fila = 20;
		Integer columna = 10;
		Avion avion = new Avion(nroDeAvion, modelo, fabricante, capacidad, fila, columna);

		Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);

		personalGeneral = new Personal(nombre, apellido, legajo);
		aerolinea.agregarVuelo(vuelo);
		aerolinea.agregarAvion(avion, vuelo.getId());
		
		aerolinea.agregarPersonalDeMantenimientoALaAerolinea(personal8, personal9, personal7, personal10, personal11);
		
		Integer cantidadDePersonalDeMantenimiento = 5;
		
		assertEquals(cantidadDePersonalDeMantenimiento, aerolinea.getCantidadDePersonalDeMantenimiento());
		assertTrue(aerolinea.validarQueSeaPersonalDeMantenimiento(personal7,personal8, personal9, personal10, personal11, vuelo, personalGeneral));
		
		
	}
	
	@Test
	public void queSiComproUnAsientoEntreFila1YFila2SeaPremium() {
		
		ArrayList<Pasajero> pasajeros = new ArrayList<>();
		String nombreAerolinea = "Despegar";
		
		for(int i = 0; i < 20; i++) {
			pasajeros.add(new Pasajero(true,1000000.0));
		}
		
		Aerolinea aerolinea = new Aerolinea(nombreAerolinea);
		String origen = "Buenos Aires";
		String destino = "Cancun";
		Integer nro = 12;
		LocalDate fecha = LocalDate.of(2022, Month.MAY, 04);
		LocalTime hora = LocalTime.of(9, 30);
		Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);
		Integer nroDeAvion = 520;
		String modelo = "Boing 747";
		String fabricante = "Airbuss";
		Integer capacidad = 200;
		Integer fila = 10;
		Integer columna = 20;
		Avion avion = new Avion(nroDeAvion, modelo, fabricante, fila, columna, capacidad);
		
		aerolinea.agregarVuelo(vuelo);
		aerolinea.agregarAvion(avion, vuelo.getId());
		
		assertTrue(aerolinea.comprarVuelo(pasajeros.get(0), vuelo, 1, 1));
		assertTrue(aerolinea.comprarVuelo(pasajeros.get(0), vuelo, 2, 1));
	}
	
	@Test
	public void queSePuedaSubirAUnPasajeroAlVuelo() {
		
		ArrayList<Pasajero>pasajeros = new ArrayList<>();
		for(int i = 0; i <= 20; i++) {
			pasajeros.add(new Pasajero(true, 2000000.0));
			
		}
			String nombre = "Despegar";
			
			
			Aerolinea aerolinea = new Aerolinea(nombre);
			String origen = "Buenos Aires";
			String destino = "Cancun";
			Integer nro = 12;
			LocalDate fecha = LocalDate.of(2022, Month.MAY, 04);
			LocalTime hora = LocalTime.of(9, 30);
			Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);
			Integer nroDeAvion = 520;
			String modelo = "Boing 747";
			String fabricante = "Airbuss";
			Integer capacidad = 200;
			Integer fila = 10;
			Integer columna = 20;
			Avion avion = new Avion(nroDeAvion, modelo, fabricante, fila, columna, capacidad);

			aerolinea.agregarVuelo(vuelo);
			aerolinea.agregarAvion(avion, vuelo.getId());
			
			
			for(Pasajero pasajero : pasajeros) {
				aerolinea.agregarPasajeros(pasajero);
			}
			
			aerolinea.comprarVuelo(pasajeros.get(0), vuelo, 1, 1);
			aerolinea.comprarVuelo(pasajeros.get(1), vuelo, 1, 2);
			
			assertTrue(aerolinea.subirPasajeros(vuelo));
			
		}

	
	@Test
	public void queAUnpasajeroSeLeAsigneUnAsientoDeVueloSiHayAsientoDisponible() {
		Boolean pasaporte = true;
		
		
		Pasajero pasajero = new Pasajero(pasaporte, 1000000.0);
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

		Avion avion = new Avion(nroDeAvion, modelo, fabricante, fila, columna, capacidad);

		Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);
		String nombreAero = "Humanos unidos";
		Aerolinea aerolinea = new Aerolinea(nombreAero);
		aerolinea.agregarVuelo(vuelo);
		aerolinea.agregarAvion(avion, vuelo.getId());
		assertTrue(avion.sentarPasajeros(pasajero));
		
	}
	
	@Test
	public void queSePuedaValidarQueUnAvionEstaAptoParaVolar() {
		String nombreAero = "Despegar";
		String nombre = "Jose";
		String apellido = "Torres";
		Integer legajo = 7;
		
		Integer nroDeAvion = 520;
		
		Integer capacidad = 200;
		Integer cantidadDeGalonesDeCombustible = 2000;
		Boolean mantenimientoRealizado = false;

		Aerolinea aerolinea;
		Mantenimiento personal7;
		Mantenimiento personal8;
		Mantenimiento personal9;
		Mantenimiento personal10;
		Mantenimiento personal11;
		Avion avion;
		
		aerolinea = new Aerolinea(nombreAero);
		personal7 = new Mantenimiento(nombre, apellido, legajo);
		personal8 = new Mantenimiento(nombre, apellido, legajo);
		personal9 = new Mantenimiento(nombre, apellido, legajo);
		personal10 = new Mantenimiento(nombre, apellido, legajo);
		personal11 = new Mantenimiento(nombre, apellido, legajo);
		avion = new Avion(nroDeAvion,capacidad,cantidadDeGalonesDeCombustible,mantenimientoRealizado);
		
		aerolinea.agregarPersonalDeMantenimientoALaAerolinea(personal7, personal8, personal9, personal10, personal11);
		aerolinea.queSeValideQueElAvionTengaElCombustibleNecesarioParaElVuelo(mantenimientoRealizado,
				cantidadDeGalonesDeCombustible);
		
		
		Integer cantidadDePersonalDeMantenimiento = 5;
		
		assertEquals(cantidadDePersonalDeMantenimiento, aerolinea.getCantidadDePersonalDeMantenimiento());
		assertTrue(aerolinea.queSeValideQueElAvionTengaElCombustibleNecesarioParaElVuelo(mantenimientoRealizado, cantidadDeGalonesDeCombustible));
		
	}
	
	@Test
	public void queSePuedaDespegarSiTieneLosPreparativosDeDespegueListos() {
		String nombreAerolinea = "Despegar";
		Aerolinea aerolinea = new Aerolinea(nombreAerolinea);
		String origen = "Buenos Aires";
		String destino = "Cancun";
		Integer nro = 12;
		LocalDate fecha = LocalDate.of(2022, Month.MAY, 04);
		LocalTime hora = LocalTime.of(9, 30);
		Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);
		Integer nroDeAvion = 520;
		String modelo = "Boing 747";
		String fabricante = "Airbuss";
		Integer capacidad = 200;
		Integer fila = 10;
		Integer columna = 20;
		Avion avion = new Avion(nroDeAvion, modelo, fabricante, fila, columna, capacidad);
		
		aerolinea.agregarVuelo(vuelo);
		
		//1
		
		aerolinea.agregarAvion(avion, vuelo.getId());
		
		//2
		Piloto personal1 = new Piloto("Julian", "forza", 585220, 650);
		Piloto personal2 = new Piloto("Julian", "Hown", 585220, 650);

		Azafata personal3 = new Azafata("Julieta", "Hernandez", 0);
		Azafata personal4 = new Azafata("Maria", "Hown", 585222);
		Azafata personal5 = new Azafata("Julieta", "Hown", 585282);
		Azafata personal6 = new Azafata("Julian", "Hown", 58522);

		Mantenimiento mantenimiento1 = new Mantenimiento("Pablo", "Juarez", 1001);
		Mantenimiento mantenimiento2 = new Mantenimiento("Leandro", "Pirez", 1005);

		Mantenimiento mantenimiento3 = new Mantenimiento("Ramiro", "Valdez", 1007);

		Mantenimiento mantenimiento4 = new Mantenimiento("Alberto", "Rodriguez", 1100);

		Mantenimiento mantenimiento5 = new Mantenimiento("Diego", "Agudo", 1500);

		aerolinea.agregarPilotosAlVuelo(personal1, personal2, vuelo);
		aerolinea.agregaAzafatasAlVuelo(personal3, personal4, personal5, personal6, vuelo);
		aerolinea.agregarPersonalDeMantenimientoALaAerolinea(mantenimiento1, mantenimiento2, mantenimiento3,
				mantenimiento4, mantenimiento5);

		aerolinea.agregarPesonalAlVuelo(vuelo);
		
		// 3
		ArrayList<Pasajero> pasajeros = new ArrayList<>();
		for (int i = 0; i <= 20; i++) {
			pasajeros.add(new Pasajero(true, 1000000.0));
		}

		for (Pasajero pasajero : pasajeros) {
			aerolinea.agregarPasajeros(pasajero);
		}

		aerolinea.comprarVuelo(pasajeros.get(0), vuelo, 1, 1);
		aerolinea.comprarVuelo(pasajeros.get(1), vuelo, 1, 2);

		aerolinea.subirPasajeros(vuelo);
		
		assertTrue(aerolinea.despegar(vuelo));
	}
	
}
