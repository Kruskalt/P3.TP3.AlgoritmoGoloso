package testsCenso2022;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import censo2022.BFS;
import censo2022.Censista;
import censo2022.Ciudad;
import censo2022.SolverGoloso;

@SuppressWarnings("unused")
public class GrafoTest {

	@Test
	public void test() {
		Ciudad aux = new Ciudad(5);
		aux.agregarArista(1, 0);
		assertTrue(aux.existeArista(1, 0));
		assertTrue(aux.existeArista(0, 1));
	}
	
	@Test(expected =IllegalArgumentException.class)
	public void testex() {
		Ciudad aux = new Ciudad(6);
		aux.agregarArista(1, 1);
		
		
		
	}
	
	@Test(expected =IllegalArgumentException.class)
	public void tes3() {
		Ciudad aux = new Ciudad(6);
		aux.agregarArista(6, 1);
		
		
		
	}
	@Test(expected =IllegalArgumentException.class)
	public void tes4() {
		Ciudad aux = new Ciudad(6);
		aux.agregarArista(1, 0);
		
		aux.agregarArista(0, 1);
		
	}
	@Test
	public void tes5() {
		int[]esperados = {1,2};
		Ciudad aux = new Ciudad(7);
		aux.agregarArista(1, 0);
		
		aux.agregarArista(0, 2);
		assertTrue(aux.existeArista(0, 2));
		assertTrue(aux.existeArista(0, 1));
		
		
		Assert.iguales(esperados, aux.vecinos(0));
	}
	
	@Test
	public void testSolverAMano() {
		Ciudad aux = new Ciudad(16);
		aux.agregarArista(0, 1);
		aux.agregarArista(0, 4);
		
		aux.agregarArista(1, 2);
		aux.agregarArista(1, 5);
		
		aux.agregarArista(2, 3);
		aux.agregarArista(2, 6);
		
		
		
		aux.agregarArista(3, 7);
		
		aux.agregarArista(4, 5);
		aux.agregarArista(4, 8);
		
		aux.agregarArista(5, 6);
		aux.agregarArista(5, 9);
		
		aux.agregarArista(6, 7);
		aux.agregarArista(6, 10);
		
		aux.agregarArista(7, 11);
		
		aux.agregarArista(8, 9);
		aux.agregarArista(8, 12);
		
		aux.agregarArista(9, 10);
		aux.agregarArista(9, 13);
		
		aux.agregarArista(10, 11);
		aux.agregarArista(10, 14);
		
		aux.agregarArista(11, 15);
		
		aux.agregarArista(12, 13);
		
		aux.agregarArista(13, 14);
		
		aux.agregarArista(14, 15);
		
		assertTrue(BFS.esConexo(aux));
//		
//		aux.censar(0);
//		aux.censar(1);
//		aux.censar(2);
//		
//		System.out.println(aux.vecinosList(2));
//		
//		aux.censar(3);
//		System.out.println(aux.vecinosList(3));
//		
//		aux.censar(7);
//		System.out.println(aux.vecinosList(7));
//		
//		aux.censar(6);
//		System.out.println(aux.vecinosList(6));
//		
//		aux.censar(5);
//		System.out.println(aux.vecinosList(5));
//		
//		aux.censar(4);
//		System.out.println(aux.vecinosList(4));
//		
//		aux.censar(8);
//		System.out.println(aux.vecinosList(8));
//		
//		aux.censar(9);
//		System.out.println(aux.vecinosList(9));
//		
//		aux.censar(10);
//		System.out.println(aux.vecinosList(10));
//		
//		aux.censar(11);
//		System.out.println(aux.vecinosList(11));
//		
//		aux.censar(15);
//		System.out.println(aux.vecinosList(15));
//		
//		aux.censar(14);
//		System.out.println(aux.vecinosList(14));
//		
//		aux.censar(13);
//		System.out.println(aux.vecinosList(13));
//		
//		aux.censar(12);
//		System.out.println(aux.vecinosList(12));
//		
//		ArrayList<Censista> cen = new ArrayList<>();
//		for (int i = 0; i < 6; i++) {
//			cen.add(new Censista(i+1, "" + i));
//		}
//		
//		SolverGoloso s = new SolverGoloso(aux,cen);
//		
	}
	
	
}
