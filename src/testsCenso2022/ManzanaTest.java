package testsCenso2022;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import censo2022.Manzana;

public class ManzanaTest {

	@Test
	public void CensarTest() {
		Manzana m = CrearManzana(0);
		m.censar();
		
		assertTrue(m.fueCensada());
	}
	
	@Test
	public void ExisteAristaTest() {
		Manzana m = CrearManzana(0);
		Manzana i = CrearManzana(1);
		
		m.aņadirArista(i);
		
		assertTrue(m.existeArista(i.getID()));
	}
	
	@Test
	public void vecinosTest() {
		Manzana m = CrearManzana(0);
		Manzana i = CrearManzana(1);
		Manzana j = CrearManzana(2);
		
		int [] esperados = {1,2};
		
		m.aņadirArista(i);
		m.aņadirArista(j);
		
		Assert.iguales(esperados, new HashSet<Integer>(m.vecinosList()));
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void aņadirAristaDosVecesTest() {
		Manzana m = CrearManzana(0);
		Manzana i = CrearManzana(1);
		
		m.aņadirArista(i);
		m.aņadirArista(i);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void ExisteAristaExcTest() {
		Manzana m = CrearManzana(0);
		
		m.existeArista(0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void aņadirAristaTest() {
		Manzana m = CrearManzana(0);
		
		m.aņadirArista(m);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void CensarYaCensadaTest() {
		Manzana m = CrearManzana(0);
		m.censar();
		m.censar();
	}
	
	private Manzana CrearManzana(int n) {
		Manzana manzana1 = new Manzana(n);
		return manzana1;
	}

}
