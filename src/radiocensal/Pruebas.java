package radiocensal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;

class Pruebas {

	@Test
	void prueba() {
//		Grafo  aux = new Grafo(10);
		Grafo  aux = grafoCon6Vertices();
//		aux.agregarArista(0, 5, 0.0);
//		aux.agregarArista(5, 2,  0.0);
//		aux.agregarArista(2, 4, 0.0);
//		aux.agregarArista(1, 4,  0.0);
//		aux.agregarArista(9, 1,  0.0);
//		aux.agregarArista(9, 6,  0.0);
//		aux.agregarArista(6, 3,  0.0);
//		aux.agregarArista(3, 8,  0.0);
//		aux.agregarArista(8, 7,  0.0);
		Instancia in = new Instancia(aux);
		System.out.println("red sensal");
		System.out.println(aux.toString());
		
		System.out.println("censistas");
		Censista c1= new Censista(1);
		Censista c2= new Censista(2);
		Censista c3= new Censista(3);
		Censista c4= new Censista(4);
		Censista c5= new Censista(5);
		Censista c6= new Censista(6);
		Censista c7= new Censista(7);
		Censista c8= new Censista(8);
		Censista c9= new Censista(9);
		Censista c10= new Censista(10);
		
		
		
		ArrayList<Censista> censistas = new ArrayList<Censista>();
		
		
		censistas.add(c1);
		censistas.add(c2);
		censistas.add(c3);
		censistas.add(c4);
		censistas.add(c5);
		censistas.add(c6);
		censistas.add(c7);
		censistas.add(c8);
		censistas.add(c9);
		censistas.add(c10);
		System.out.println("censistas");
		
		
		SolverGoloso solver= new SolverGoloso(in, censistas);
		
	Solucion ret = solver.resolver2();
	
	System.out.println(ret.ManzanasdelCensista(0));
	System.out.println(ret.ManzanasdelCensista(1));
	System.out.println(ret.ManzanasdelCensista(2));
		System.out.println(ret.ManzanasdelCensista(3));
		System.out.println(ret.ManzanasdelCensista(4));
		System.out.println(ret.ManzanasdelCensista(5));
		System.out.println(ret.ManzanasdelCensista(6));
		System.out.println(ret.ManzanasdelCensista(7));
	System.out.println(ret.ManzanasdelCensista(8));
	System.out.println(ret.ManzanasdelCensista(9));

	
	
	
	}
	
	private static Grafo aleatorio(int n) {
		Grafo  grafo = new Grafo (n) ;
		Random random = new Random();	
		for (int i = 0;i<n ;i++) if(random.nextDouble()<0.4)
			for (int j = 0;j<n ;j++)  {
				if (i!=j && grafo.existeArista(i, j)==false) {
					grafo.agregarArista(i, j, random.nextDouble());
				}
			}		
		return grafo;	
		
	}
	
	private static Grafo grafoCon6Vertices() {
		Grafo ret = new Grafo(6);
		ret.agregarArista(0, 1,0.0);
		ret.agregarArista(1, 2,0.0);
		ret.agregarArista(2, 3,0.0);
		ret.agregarArista(2, 4,0.0);
		ret.agregarArista(2, 5,0.0);
		
		return ret;
	}

}
