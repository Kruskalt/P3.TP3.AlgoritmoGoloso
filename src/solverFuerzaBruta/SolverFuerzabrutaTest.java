package solverFuerzaBruta;

import static org.junit.Assert.*;
import org.junit.Test;

import testsCenso2022.MetodosAuxiliares;

import censo2022.Ciudad;
import censo2022.Solucion;

public class SolverFuerzabrutaTest {

	Ciudad grafo1 = new Ciudad(9);
	Ciudad grafo2 = new Ciudad(11);
	Ciudad grafo3 = new Ciudad(10);
	Ciudad grafo4 = new Ciudad(3);
	Ciudad grafoTrivial = new Ciudad(2);
	Ciudad grafoSinAristas = new Ciudad(5);
	Ciudad grafoConAlgunasAristas = new Ciudad(5);
	SolverFuerzaBruta sFB;
	
	@Test 
	public void solucionGrafo1Test() {
		iniciarGrafo_1();
		
		sFB = new SolverFuerzaBruta(grafo1, MetodosAuxiliares.listaCensistas(3));
		Solucion s = sFB.resolver();
		
		
		assertEquals(9, MetodosAuxiliares.cantManzanasCensadas(s.getCiudad()));
	}
	
	@Test
	public void solucionGrafo2Test() {
		iniciarGrafo_2();
		
		sFB = new SolverFuerzaBruta(grafo2, MetodosAuxiliares.listaCensistas(4));
		Solucion s = sFB.resolver();
		
		assertEquals(11, MetodosAuxiliares.cantManzanasCensadas(s.getCiudad()));
	}
	
	@Test
	public void solucionGrafo3Test() {
		iniciarGrafo_3();
		
		sFB = new SolverFuerzaBruta(grafo3, MetodosAuxiliares.listaCensistas(4));
		Solucion s = sFB.resolver();
		
		assertEquals(10, MetodosAuxiliares.cantManzanasCensadas(s.getCiudad()));
	}
	
	@Test
	public void solucionGrafo4Test() {
		iniciarGrafo_4();
		
		sFB = new SolverFuerzaBruta(grafo4, MetodosAuxiliares.listaCensistas(1));
		Solucion s = sFB.resolver();
		
		assertEquals(3, MetodosAuxiliares.cantManzanasCensadas(s.getCiudad()));
	}
	
	@Test
	public void solucionGrafoTrivialTest() {
		grafoTrivial.agregarArista(0, 1);
		
		sFB = new SolverFuerzaBruta(grafoTrivial, MetodosAuxiliares.listaCensistas(1));
		Solucion s = sFB.resolver();
		
		assertEquals(2, MetodosAuxiliares.cantManzanasCensadas(s.getCiudad()));
	}
	
	@Test
	public void masCensistasQueVerticesTest() {
		iniciarGrafo_1();
		
		sFB = new SolverFuerzaBruta(grafo1, MetodosAuxiliares.listaCensistas(11));
		Solucion s = sFB.resolver();
		
		
		assertEquals(9, MetodosAuxiliares.cantManzanasCensadas(s.getCiudad()));
//		System.out.println(s.getCensistas());
	}
	
	@Test
	public void masVerticesQueCensistasTest() {
		iniciarGrafo_1();
		
		sFB = new SolverFuerzaBruta(grafo1, MetodosAuxiliares.listaCensistas(1));
		Solucion s = sFB.resolver();
		
		
		assertEquals(3, MetodosAuxiliares.cantManzanasCensadas(s.getCiudad()));
		System.out.println(s.getCensistas());
	}
	
	@Test (expected = RuntimeException.class)
	public void solucionGrafoSinAristasTest() {
		sFB = new SolverFuerzaBruta(grafoSinAristas, MetodosAuxiliares.listaCensistas(1));
	}

	@Test
	public void testResolverGrafo_1() {
		iniciarGrafo_1();

		sFB = new SolverFuerzaBruta(grafo1);
		
		assertEquals(3, sFB.generarSolucionOptima().size());
	}

	@Test
	public void testResolverGrafo_2() {
		iniciarGrafo_2();
		
		sFB = new SolverFuerzaBruta(grafo2);
		
		assertEquals(4, sFB.generarSolucionOptima().size());
	}

	@Test
	public void testResolverGrafo_3() {
		iniciarGrafo_3();

		sFB = new SolverFuerzaBruta(grafo3);
		
		assertEquals(4, sFB.generarSolucionOptima().size());
	}

	@Test
	public void testResolverGrafo_3Contiguos() {
		iniciarGrafo_4();
	
		sFB = new SolverFuerzaBruta(grafo4);
		
		assertEquals(1, sFB.generarSolucionOptima().size());
	}

	@Test
	public void testResolverGrafoTrivial() {
		grafoTrivial.agregarArista(0, 1);

		sFB = new SolverFuerzaBruta(grafoTrivial);
		
		assertEquals(1, sFB.generarSolucionOptima().size());
	}
	
	@Test (expected = RuntimeException.class)
	public void testResolverGrafoSinAristas() {
	
		sFB = new SolverFuerzaBruta(grafoSinAristas);
		
		sFB.generarSolucionOptima();
	}
	
	@Test (expected = RuntimeException.class)
	public void testResolverGrafoConAlgunasAristas() {
		grafoConAlgunasAristas.agregarArista(0, 1);
		grafoConAlgunasAristas.agregarArista(2, 3);
		
		sFB = new SolverFuerzaBruta(grafoConAlgunasAristas);
		
		sFB.generarSolucionOptima();
	}

	private void iniciarGrafo_1() {
		grafo1.agregarArista(0, 1);
		grafo1.agregarArista(1, 2);
		grafo1.agregarArista(1, 8);
		grafo1.agregarArista(2, 3);
		grafo1.agregarArista(3, 4);
		grafo1.agregarArista(3, 6);
		grafo1.agregarArista(4, 5);
		grafo1.agregarArista(5, 6);
		grafo1.agregarArista(6, 7);
		grafo1.agregarArista(7, 8);
	}

	private void iniciarGrafo_2() {
		grafo2.agregarArista(0, 1);
		grafo2.agregarArista(1, 2);
		grafo2.agregarArista(2, 5);
		grafo2.agregarArista(4, 5);
		grafo2.agregarArista(1, 4);
		grafo2.agregarArista(5, 8);
		grafo2.agregarArista(9, 6);
		grafo2.agregarArista(6, 5);
		grafo2.agregarArista(7, 6);
		grafo2.agregarArista(3, 7);
		grafo2.agregarArista(10, 9);
	}

	private void iniciarGrafo_3() {
		grafo3.agregarArista(0, 1);
		grafo3.agregarArista(1, 2);
		grafo3.agregarArista(1, 4);
		grafo3.agregarArista(2, 3);
		grafo3.agregarArista(2, 5);
		grafo3.agregarArista(3, 6);
		grafo3.agregarArista(4, 5);
		grafo3.agregarArista(4, 7);
		grafo3.agregarArista(5, 8);
		grafo3.agregarArista(5, 6);
		grafo3.agregarArista(6, 9);
		grafo3.agregarArista(7, 8);
		grafo3.agregarArista(8, 9);
	}

	private void iniciarGrafo_4() {
		grafo4.agregarArista(0, 1);
		grafo4.agregarArista(1, 2);
	}
}
