package censo2022;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import solverFuerzaBruta.SolverFuerzaBruta;
import testsCenso2022.MetodosAuxiliares;

public class StressTest {
	private Ciudad c;
	private ArrayList<Censista> censistas;
	
	public StressTest(int cantVertices, int cantCensistas) {
		if (cantVertices <= 1) {
			throw new IllegalArgumentException("La cantidad de vertices no puede ser: "+cantVertices);
		}
		if (cantCensistas <=0) {
			throw new IllegalArgumentException("La cantidad de censistas no puede ser: "+cantCensistas);
		}
		c = aleatorio(cantVertices);
		censistas = MetodosAuxiliares.listaCensistas(cantCensistas);
	}
	
	public String stressTestGoloso() {
		reset();
		
		StringBuilder ret = new StringBuilder();
		
		long inicio2 = System.currentTimeMillis();
			
		SolverGoloso solver = new SolverGoloso(c, censistas);
		Solucion s = solver.resolver();
			
		long fin2 =System.currentTimeMillis();
		double tiempo= (fin2-inicio2)/1000.0;
		
		DecimalFormat de = new DecimalFormat("###.###");
		
		ret.append("Tiempo Solver Goloso: ");
		ret.append(de.format((double)(tiempo))).append("\n");
		
		ret.append("Solucion: ").append("\n");
		ret.append(s.getCiudad());
		ret.append(s.getCensistas());
		
		return ret.toString();
	}

	public String stressTestFuerzaBruta() {
		reset();
		
		StringBuilder ret = new StringBuilder();
		
		long inicio2 = System.currentTimeMillis();
			
		SolverFuerzaBruta solver = new SolverFuerzaBruta(c, censistas);
		Solucion s = solver.resolver();
			
		long fin2 =System.currentTimeMillis();
		double tiempo= (fin2-inicio2)/1000.0;
		
		DecimalFormat de = new DecimalFormat("###.###");
		
		ret.append("Tiempo Solver Fuerza Bruta: ");
		ret.append(de.format((double)(tiempo))).append("\n");
		
		ret.append("Solucion: ").append("\n");
		ret.append(s.getCiudad());
		ret.append(s.getCensistas());
		
		return ret.toString();
	}
	
	private void reset() {
		for (int i = 0; i < c.getTamanio(); i++) {
			c.desCensar(i);
		}
		for (Censista censista : censistas) {
			censista.resetManzanas();
		}
	}

	private Ciudad aleatorio(int n) {
		Ciudad grafo = new Ciudad(n) ;
		Random random = new Random(0);
		for (int i = 0;i<n ;i++) if(random.nextDouble()<0.3)
			for (int j = 0;j<n ;j++)  
				if (i!=j && grafo.existeArista(i, j)==false)
					grafo.agregarArista(i, j);
		return grafo;
	}
}
