package testsCenso2022;

import java.util.ArrayList;

import censo2022.Censista;
import censo2022.Ciudad;
import censo2022.SolverGoloso;

public class MetodosAuxiliares {

	public static int cantManzanasCensadas(Ciudad g) {
		int ret = 0;
		for(int i = 0; i < g.getTamanio(); i++) {
			if (g.fueCensada(i)) {
				ret ++;
			}
		}
		return ret;
	}
	
	public static ArrayList<Censista> listaCensistas(int n){
		ArrayList<Censista> ret = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			ret.add(new Censista(i+1, (i+1)+""));
		}
		
		return ret;
	}
	
	static SolverGoloso crearSolver(Ciudad g, ArrayList<Censista> L) {
		return new SolverGoloso(g, L);
	}
	
	static Ciudad grafoConAntenas() {
		Ciudad ret = new Ciudad(6);
		
		ret.agregarArista(0, 1);
		ret.agregarArista(1, 2);
		ret.agregarArista(2, 3);
		ret.agregarArista(2, 4);
		ret.agregarArista(2, 5);
		
		return ret;
	}
	
	static Ciudad grafoNoConexo() {
		Ciudad ret = new Ciudad(7);
		
		ret.agregarArista(0, 1);
		ret.agregarArista(1, 2);
		
		ret.agregarArista(2, 5);
		ret.agregarArista(2, 6);
		
		return ret;
	}
	
	static Ciudad grafoDeTresVertices() {
		Ciudad ret = new Ciudad(3);
		
		ret.agregarArista(0, 1);
		ret.agregarArista(1, 2);
		
		return ret;
	}
	
	static Ciudad grafoUnaManzana() {
		Ciudad ret = new Ciudad(1);
		
		return ret;
	}
}
