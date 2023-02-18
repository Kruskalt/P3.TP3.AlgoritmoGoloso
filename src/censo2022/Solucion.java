package censo2022;

import java.util.ArrayList;

public class Solucion {
	
	private Ciudad g;
	private ArrayList<Censista> censistas;
	
	public Solucion(Ciudad g, ArrayList<Censista> censistas) {
		this.g = g;
		this.censistas = censistas;
	}
	
	public Ciudad getCiudad() {
		return g;
	}
	
	public ArrayList<Censista> getCensistas() {
		return censistas;
	}
	
}
