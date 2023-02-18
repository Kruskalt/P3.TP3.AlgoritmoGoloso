package censo2022;

import java.util.ArrayList;
import java.util.Collections;

public class SolverGoloso {

	private Ciudad g;
	private ArrayList<Censista> censistas;
	
	private int ultimaManzana;
	
	public SolverGoloso(Ciudad g2, ArrayList<Censista> LCens) {
		excepcionesConstructor(g2, LCens);
		this.censistas = LCens;
		this.g = g2;
		this.ultimaManzana = 0;
	}

	public Solucion resolver() {
		while (!todosCensistasOcupados() && hayManzanasSinCensar()) {
			asignarCensista();
		}
		return new Solucion(g, censistas);
	}

	private boolean todosCensistasOcupados() {
		Collections.sort(censistas, (p,q) -> p.cantManzanas() - q.cantManzanas()); //O(c . log (c))
		return censistas.get(0).censaManzanas(); //O(1)
	}

	private boolean hayManzanasSinCensar() {
		for (int i = 0; i < g.getTamanio(); i++) { //O(v)
			if (!g.fueCensada(i)) {
				return true;
			}
		}
		return false;
	}

	private void asignarCensista() {
		if (!censistas.get(0).censaManzanas()) {
			cambiarManzana();
			censarManzanas();
		}
	}

	private void cambiarManzana() {
		while(g.fueCensada(ultimaManzana)) {
			ultimaManzana = g.vecinosList(ultimaManzana).get(0); //O1
		}
	}

	private void censarManzanas() {
		while (censistas.get(0).puedeCensar() && !g.fueCensada(ultimaManzana)) {
			censistas.get(0).asignarManzana(ultimaManzana);
			g.censar(ultimaManzana);
			ArrayList<Integer> vecinos = g.vecinosList(ultimaManzana);
			if (!vecinos.isEmpty()) {
				ultimaManzana = vecinos.get(0);
			}
		}
	}

	private void excepcionesConstructor(Ciudad g2, ArrayList<Censista> censistas) {
		if (!BFS.esConexo(g2)) {
			throw new IllegalArgumentException("Todas las manzanas deben estar conectadas antes de asignar los censistas!");
		}
		if (censistas == null || censistas.isEmpty()) {
			throw new IllegalArgumentException("Te olvidaste de añadir censistas!");
		}
	}
	
	
}
