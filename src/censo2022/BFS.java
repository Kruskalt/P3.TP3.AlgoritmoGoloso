package censo2022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class BFS 
{
	protected static ArrayList<Integer> ListaPendientes;
	protected static boolean[] marcados;

		protected static void inicializar(Ciudad g, int origen) {
		ListaPendientes = new ArrayList<Integer>();
		ListaPendientes.add(origen);
		marcados = new boolean [g.getTamanio()];
	}
	
	public static Set<Integer> alcanzables(Ciudad g, int origen) {
		//conjunto que va a retornar, puede cambiar dependiendo lo que se quiera hacer
		Set<Integer> ret = new HashSet<Integer>();
		
		//inicializa el constructor
		inicializar(g, origen);
		
		//mientras que haya vecinos para analizar...
		while (ListaPendientes.size() > 0) {
			int i = seleccionarYMarcarVertice(ret); //agrega el vertice al set y lo marca
			agregarVecinosNoMarcados(g,i); //recoge los vecinos no marcados del vertice siendo analizado 
											//mientras que no pertenezcan a L y no hayan sido marcados
			
			removerSeleccionado(); 		//remueve el vertice de L para que se analice el resto
		}
		
		return ret;
	}
	
	private static int seleccionarYMarcarVertice(Set<Integer> ret) {
		int i = ListaPendientes.get(0);
		marcados[i] = true;
		ret.add(i);
		return i;
	}


	private static void agregarVecinosNoMarcados(Ciudad g, int i) {
		for (int vecino: g.vecinos(i)) {
			if (!marcados[vecino] && !ListaPendientes.contains(vecino))
				ListaPendientes.add(vecino);
		}
	}

	protected static void removerSeleccionado() {
		ListaPendientes.remove(0);
	}

	public static List<Integer> alcanzablesList(Ciudad g, int origen) {
		List<Integer> ret = new ArrayList<Integer>();
		inicializar(g, origen);
		
		while (ListaPendientes.size() > 0) {
			
			int i = seleccionarYMarcarVertice(ret);
			agregarVecinosNoMarcados(g,i);
			removerSeleccionado();
		}
		
		return ret;
	}
	
	
	public static boolean esConexo(Ciudad g) {
		if (g==null)
			throw new IllegalArgumentException("El grafo no puede ser nulo!");
		if (g.getTamanio()==0)
			return true;
		return alcanzables(g,0).size() == g.getTamanio();
	}


	private static int seleccionarYMarcarVertice(List<Integer> ret) {
		int i = ListaPendientes.get(0);
		marcados[i] = true;
		ret.add(i);
		return i;
	}

	
	
	
	
	
	
}
