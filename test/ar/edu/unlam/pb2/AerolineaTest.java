package ar.edu.unlam.pb2;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AerolineaTest {

	
	@Test
	public void crearAerolinea() {
		String nombreAero = "Despegar";
		Integer aerolineaId = 1;
		
		Aerolinea aerolinea = new Aerolinea(nombreAero);
		
		assertEquals(aerolineaId, aerolinea.id());
	}
	
}
