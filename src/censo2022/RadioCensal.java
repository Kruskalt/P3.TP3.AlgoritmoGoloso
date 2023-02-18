package censo2022;


import java.util.ArrayList;

public class RadioCensal {
	
	private Ciudad ciudad;
	private ArrayList<Censista> censistas;
	
	public RadioCensal(int cantManzanas) {
		excepcionesConstructor(cantManzanas);
		ciudad = new Ciudad(cantManzanas);
		censistas = new ArrayList<>();
	}

	//Factory method
	public static RadioCensal crearRadioCensal(Ciudad g, ArrayList<Censista> L) {
		RadioCensal ret = new RadioCensal(g.getTamanio());
		ret.asignarGrafo(g);
		
		for (Censista censista : L) {
			ret.agregarCensista(censista.nombre(), censista.dni());
		}
		return ret;
	}
	
	public void agregarConexionEntreManzanas(int manzana1, int manzana2) {
		ciudad.agregarArista(manzana1, manzana2);
	}
	
	
	public void agregarCensista(String nombre, int dni) {
		excepcionesAgregarCensista(nombre, dni);
		censistas.add(new Censista(dni, nombre));
	}
	
	public void censar() {
		resetCensistas();
		resetGrafo();
		
		SolverGoloso s = new SolverGoloso(ciudad, censistas);
		Solucion sol = s.resolver();
		
		ciudad = sol.getCiudad();
		censistas = sol.getCensistas();
	}
	
	public int cantDeCensistasAsignados() {
		int ret = 0;
		
		for (Censista censista : censistas) {
			if (censista.censaManzanas()) {
				ret++;
			}
		}
		
		return ret;
	}
	
	public int cantDeManzanasCensadas() {
		int ret = 0;
		
		for (int i = 0; i<ciudad.getTamanio(); i++) {
			if (ciudad.fueCensada(i)) {
				ret++;
			}
		}
		
		return ret;
	}
	
	public String censistasNombreYDNI() {
		StringBuilder ret = new StringBuilder();
		
		for (Censista censista : censistas) {
			ret.append(censista.nombreYDNI()).append("\n");
			ret.append("\n");
		}
		
		return ret.toString();
	}
	
	public String censistasToString() {
		StringBuilder ret = new StringBuilder();
		
		for (Censista censista : censistas) {
			ret.append(censista);
		}
		
		return ret.toString();
	}
	
	public String ciudadToString() {
		return ciudad.toString();
	}
	
	public int getCantidadManzanas() {
		return ciudad.getTamanio();
	}
	
	public int cantCensistas() {
		return censistas.size();
	}
	
	public boolean estanConectadas() {
		return BFS.esConexo(ciudad);
	}
	
	public boolean hayCensistas() {
		return censistas.size() > 0;
	}

	private boolean yaFueRegistrado(int dni) {
		for (Censista censista : censistas) {
			if (censista.dni() == dni) {
				return true;
			}
		}
		return false;
	}

	private void asignarGrafo(Ciudad g) {
		this.ciudad = g;
	}

	private void resetGrafo() {
		for (int i = 0; i<ciudad.getTamanio(); i++) {
			ciudad.desCensar(i);
		}
	}

	private void resetCensistas() {
		for (Censista censista : censistas) {
			censista.resetManzanas();
		}
		
	}

	private void excepcionesConstructor(int cantManzanas) {
		if (cantManzanas < 2) {
			throw new IllegalArgumentException("La cantidad de manzanas tiene que ser mayor a 1");
		}
	}

	private void excepcionesAgregarCensista(String nombre,int dni) {
		if (yaFueRegistrado(dni)) {
			throw new IllegalArgumentException("El censista con el DNI: " + dni + " ya fue registrado!");
		}
	}
}
