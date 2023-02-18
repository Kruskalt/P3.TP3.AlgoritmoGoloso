package testsCenso2022;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import censo2022.Solucion;
import censo2022.SolverGoloso;

public class solverGolosoTest {
	
	
	@Test
	public void resolverTest() {
		SolverGoloso solver = MetodosAuxiliares.crearSolver(MetodosAuxiliares.grafoDeTresVertices(), MetodosAuxiliares.listaCensistas(2));
		Solucion solucion = solver.resolver();
		int [] esperados = {0, 1, 2};
		int [] esperadosVacio = {};
		
		assertEquals(3, MetodosAuxiliares.cantManzanasCensadas(solucion.getCiudad()));
		Assert.iguales(esperados, solucion.getCensistas().get(1).getManzanasACensar()); 
		Assert.iguales(esperadosVacio, solucion.getCensistas().get(0).getManzanasACensar());
	}
	
	@Test
	public void resolverMasCensistasQueManzanasTest() {
		SolverGoloso solver = MetodosAuxiliares.crearSolver(MetodosAuxiliares.grafoDeTresVertices(), MetodosAuxiliares.listaCensistas(4));
		Solucion solucion = solver.resolver();
		int [] esperados = {0, 1, 2};
		int [] esperadosVacio = {};
		
		assertEquals(3, MetodosAuxiliares.cantManzanasCensadas(solucion.getCiudad()));
		Assert.iguales(esperados, solucion.getCensistas().get(3).getManzanasACensar()); 
		
		Assert.iguales(esperadosVacio, solucion.getCensistas().get(0).getManzanasACensar());
		Assert.iguales(esperadosVacio, solucion.getCensistas().get(1).getManzanasACensar());
		Assert.iguales(esperadosVacio, solucion.getCensistas().get(2).getManzanasACensar());
	}
	
	@Test
	public void resolverMasManzanasQueCensistasTest() {
		SolverGoloso solver = MetodosAuxiliares.crearSolver(MetodosAuxiliares.grafoConAntenas(), MetodosAuxiliares.listaCensistas(1));
		Solucion solucion = solver.resolver();
		int [] esperados = {0, 1, 2};
		
		assertEquals(3, MetodosAuxiliares.cantManzanasCensadas(solucion.getCiudad()));
		Assert.iguales(esperados, solucion.getCensistas().get(0).getManzanasACensar());
	}
	
	@Test
	public void resolverDosCensistasNecesariosTest() {
		SolverGoloso solver = MetodosAuxiliares.crearSolver(MetodosAuxiliares.grafoConAntenas(), MetodosAuxiliares.listaCensistas(4));
		Solucion solucion = solver.resolver();
		int [] esperados1 = {0, 1, 2};
		int [] esperados2 = {3};
		int [] esperados3 = {4};
		int [] esperados4 = {5};
		
		assertEquals(6, MetodosAuxiliares.cantManzanasCensadas(solucion.getCiudad()));
		Assert.iguales(esperados4, solucion.getCensistas().get(0).getManzanasACensar());
		Assert.iguales(esperados3, solucion.getCensistas().get(1).getManzanasACensar());
		Assert.iguales(esperados2, solucion.getCensistas().get(2).getManzanasACensar());
		Assert.iguales(esperados1, solucion.getCensistas().get(3).getManzanasACensar());
	}
	
	@Test
	public void resolverUnaManzana() {
		SolverGoloso solver = MetodosAuxiliares.crearSolver(MetodosAuxiliares.grafoUnaManzana(), MetodosAuxiliares.listaCensistas(1));
		Solucion solucion = solver.resolver();
		int [] esperados = {0};
		
		assertEquals(1, MetodosAuxiliares.cantManzanasCensadas(solucion.getCiudad()));
		Assert.iguales(esperados, solucion.getCensistas().get(0).getManzanasACensar());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void sinCensistasTest() {
		MetodosAuxiliares.crearSolver(MetodosAuxiliares.grafoDeTresVertices(), MetodosAuxiliares.listaCensistas(0));
	}

	@Test (expected = IllegalArgumentException.class)
	public void grafoNoConectadoTest() {
		MetodosAuxiliares.crearSolver(MetodosAuxiliares.grafoNoConexo(), MetodosAuxiliares.listaCensistas(2));
	}
}
