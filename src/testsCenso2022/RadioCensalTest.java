package testsCenso2022;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import censo2022.Censista;
import censo2022.Ciudad;
import censo2022.RadioCensal;

public class RadioCensalTest {
	RadioCensal radioAux;
	
	@Before
	public void IniciarRadiocensal() {
		radioAux= new RadioCensal(5);
	}
	
	@Test
	public void agregarCensistaTest() {
		radioAux.agregarCensista("pepe", 1);
		
		assertEquals(1, radioAux.cantCensistas());
		assertTrue(radioAux.hayCensistas());
	}
	
	@Test
	public void censarTest() {
		radioAux.agregarCensista("a", 1);
		radioAux.agregarCensista("a", 2);
		
		radioAux.agregarConexionEntreManzanas(0, 1);
		radioAux.agregarConexionEntreManzanas(1, 2);
		radioAux.agregarConexionEntreManzanas(2, 3);
		radioAux.agregarConexionEntreManzanas(3, 4);
		
		String expectedCen = "Nombre: a"
							+ "DNI: 2"
							+ "Manzanas a censar: "
							+ "Manzana numero: 3"
							+ "Manzana numero: 4"
							+ "Nombre: a"
							+ "DNI: 1"
							+ "Manzanas a censar: "
							+ "Manzana numero: 0"
							+ "Manzana numero: 1"
							+ "Manzana numero: 2";
		String expectedMan = "ID: 0"
							+ "Manzanas vecinas: | 1 |"
							+ "La manzana fue censada"
							+ "ID: 1"
							+ "Manzanas vecinas: | 2 || 0 |"
							+ "La manzana fue censada"
							+ "ID: 2"
							+ "Manzanas vecinas: | 3 || 1 |"
							+ "La manzana fue censada"
							+ "ID: 3Manzanas vecinas: | 4 || 2 |"
							+ "La manzana fue censada"
							+ "ID: 4Manzanas vecinas: | 3 |"
							+ "La manzana fue censada";
		
		radioAux.censar();
		
		assertEquals(2, radioAux.cantDeCensistasAsignados());
		assertEquals(5, radioAux.cantDeManzanasCensadas());
		
		assertEquals(expectedCen, radioAux.censistasToString().replace("\n", ""));
		assertEquals(expectedMan, radioAux.ciudadToString().replace("\n", ""));
	}
	
	@Test
	public void censarMenosCensistasQueManzanasTest() {
		radioAux.agregarCensista("a", 1);
		
		radioAux.agregarConexionEntreManzanas(0, 1);
		radioAux.agregarConexionEntreManzanas(1, 2);
		radioAux.agregarConexionEntreManzanas(2, 3);
		radioAux.agregarConexionEntreManzanas(3, 4);
		
		String expectedCen = "Nombre: a"
							+ "DNI: 1"
							+ "Manzanas a censar: "
							+ "Manzana numero: 0"
							+ "Manzana numero: 1"
							+ "Manzana numero: 2";
		String expectedMan = "ID: 0"
							+ "Manzanas vecinas: | 1 |"
							+ "La manzana fue censada"
							+ "ID: 1"
							+ "Manzanas vecinas: | 2 || 0 |"
							+ "La manzana fue censadaID: 2"
							+ "Manzanas vecinas: | 3 || 1 |"
							+ "La manzana fue censada"
							+ "ID: 3Manzanas vecinas: | 2 || 4 |"
							+ "La manzana no fue censada"
							+ "ID: 4Manzanas vecinas: | 3 |"
							+ "La manzana no fue censada";
		
		radioAux.censar();
		
		assertEquals(1, radioAux.cantDeCensistasAsignados());
		assertEquals(3, radioAux.cantDeManzanasCensadas());
		
		assertEquals(expectedCen, radioAux.censistasToString().replace("\n", ""));
		assertEquals(expectedMan, radioAux.ciudadToString().replace("\n", ""));
	}
	
	@Test
	public void censarMasCensistasQueManzanasTest() {
		radioAux.agregarCensista("a", 1);
		radioAux.agregarCensista("a", 2);
		radioAux.agregarCensista("a", 3);
		radioAux.agregarCensista("a", 4);
		radioAux.agregarCensista("a", 5);
		radioAux.agregarCensista("a", 6);
		
		radioAux.agregarConexionEntreManzanas(0, 1);
		radioAux.agregarConexionEntreManzanas(1, 2);
		radioAux.agregarConexionEntreManzanas(2, 3);
		radioAux.agregarConexionEntreManzanas(3, 4);
		
		String expectedCen = "Nombre: a"
							+ "DNI: 3"
							+ "El censista no fue asignado a ninguna manzana"
							+ "Nombre: a"
							+ "DNI: 4"
							+ "El censista no fue asignado a ninguna manzana"
							+ "Nombre: a"
							+ "DNI: 5"
							+ "El censista no fue asignado a ninguna manzana"
							+ "Nombre: a"
							+ "DNI: 6"
							+ "El censista no fue asignado a ninguna manzana"
							+ "Nombre: a"
							+ "DNI: 2"
							+ "Manzanas a censar: "
							+ "Manzana numero: 3"
							+ "Manzana numero: 4"
							+ "Nombre: a"
							+ "DNI: 1"
							+ "Manzanas a censar: "
							+ "Manzana numero: 0"
							+ "Manzana numero: 1"
							+ "Manzana numero: 2";
		
		String expectedMan = "ID: 0"
							+ "Manzanas vecinas: | 1 |"
							+ "La manzana fue censada"
							+ "ID: 1Manzanas vecinas: | 2 || 0 |"
							+ "La manzana fue censada"
							+ "ID: 2Manzanas vecinas: | 3 || 1 |"
							+ "La manzana fue censada"
							+ "ID: 3"
							+ "Manzanas vecinas: | 4 || 2 |"
							+ "La manzana fue censada"
							+ "ID: 4"
							+ "Manzanas vecinas: | 3 |"
							+ "La manzana fue censada";
		
		radioAux.censar();
		
		assertEquals(2, radioAux.cantDeCensistasAsignados());
		assertEquals(5, radioAux.cantDeManzanasCensadas());
		
		assertEquals(expectedCen, radioAux.censistasToString().replace("\n", ""));
		assertEquals(expectedMan, radioAux.ciudadToString().replace("\n", ""));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarCensistaSinNombreTest() {
		radioAux.agregarCensista("", 1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarCensistaDNINegativo() {
		radioAux.agregarCensista("as", -1);
	}

	@Test
	public void	agregaBienLosCensistasTest() {
		RadioCensal censo= new RadioCensal(10);
		censo.agregarCensista("de",1);
		assertEquals(1, censo.cantCensistas());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void	conectar2nuevamente() {
		radioAux.agregarConexionEntreManzanas(0, 2);
		radioAux.agregarConexionEntreManzanas(0, 2);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void	conectarlaManzanaconsigoMisma() {
		radioAux.agregarConexionEntreManzanas(0, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void	censarSinManzanas() {
		radioAux.agregarCensista("a", 1);
		radioAux.agregarCensista("a", 2);
		radioAux.agregarCensista("a", 3);
		radioAux.agregarCensista("a", 4);
		radioAux.agregarCensista("a", 5);
		radioAux.agregarCensista("a", 6);
		
		radioAux.censar();
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void	censarSinCensistasTest() {
		radioAux.agregarConexionEntreManzanas(0, 1);
		radioAux.agregarConexionEntreManzanas(2, 1);
		radioAux.agregarConexionEntreManzanas(2, 3);
		radioAux.agregarConexionEntreManzanas(3, 4);

		radioAux.censar();
	}
	
	
	@Test
	public void	PruebaDelFactoryMethod() {
		Ciudad grafo= new Ciudad(5);
		ArrayList<Censista> censistas = new ArrayList<Censista>();
		Censista cencista1= new Censista(1,"naza");
		Censista cencista2= new Censista(2,"carl");
		censistas.add(cencista1);
		censistas.add(cencista2);
		
		RadioCensal censo= RadioCensal.crearRadioCensal(grafo, censistas);
		
		assertEquals(2, censo.cantCensistas());
		assertEquals(5, censo.getCantidadManzanas());
	}
	
	@Test
	public void	Prueba2DelFactoryMethod() {
		Ciudad grafo= new Ciudad(5);
		ArrayList<Censista> censistas = new ArrayList<Censista>();

		RadioCensal censo= RadioCensal.crearRadioCensal(grafo, censistas);
		
		assertEquals(0, censo.cantCensistas());
		assertEquals(5, censo.getCantidadManzanas());
	}
	
}
