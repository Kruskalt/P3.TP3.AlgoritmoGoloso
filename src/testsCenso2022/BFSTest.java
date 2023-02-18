package testsCenso2022;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import censo2022.BFS;
import censo2022.Ciudad;



public class BFSTest {

	@Test (expected = IllegalArgumentException.class)
	public void testNull() {
		Ciudad g = null;
		
		BFS.esConexo(g);
	}
	
	public void vacioTest() {
		Ciudad g = new Ciudad(0);
		assertTrue(BFS.esConexo(g));
	}
	
	@Test
	public void alcanzablesTest() {
		Ciudad g = inicializarGrafo();
		
		Set<Integer> alcanzables = BFS.alcanzables(g, 0);
		int[] esperados = {0, 1, 2, 3};
		
		Assert.iguales(esperados, alcanzables);
	}
	
	@Test
	public void alcanzables() {
		Ciudad g = inicializarGrafo();
		
		List<Integer> alcanzables = BFS.alcanzablesList(g, 0);
		System.out.println(alcanzables.toString());
		
	}
	
	@Test
	public void conexoTest() {
		Ciudad g = inicializarGrafo();
		
		g.agregarArista(3,4);
		
		assertTrue(BFS.esConexo(g));
		
	}
	
	@Test
	public void noConexoTest() {
		Ciudad g = inicializarGrafo();
		
		assertFalse(BFS.esConexo(g));
		
	}

	
	private Ciudad inicializarGrafo(){
		Ciudad grafo = new Ciudad(5);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(2, 3);
		return grafo;
	}
}
