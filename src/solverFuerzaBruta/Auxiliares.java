package solverFuerzaBruta;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import censo2022.Ciudad;

public class Auxiliares {


	public static boolean esTernaValida(Ciudad grafo, List<Integer> grupoActual) {
		boolean ret = true;
		
		if (grupoActual.size() == 1)
				return ret;
		
		else if (grupoActual.size() == 2) {
			for(Integer i: grupoActual)
				for(Integer j: grupoActual)
					if (i!=j)
						ret = ret && grafo.existeArista(i, j);
//					else
//						ret=false;
		}
		
		else if (grupoActual.size() == 3) {
			for(Integer i: grupoActual)
				for(Integer j: grupoActual)
					for (Integer k: grupoActual)
						if (i!=j  &&  j!=k  &&  i!=k) {
							ret = ret && (grafo.existeArista(i, j)|| grafo.existeArista(i, k));
							ret = ret && (grafo.existeArista(j, k)|| grafo.existeArista(j, i));
							ret = ret && (grafo.existeArista(k, i)|| grafo.existeArista(k, j));
						}
		}
		else 
			return !ret;
		
		return ret;
	}
	
	public static GrupoDeVertices clonar (List<Integer> grupo) {
		return new GrupoDeVertices(grupo);
	}
	
	public static List<GrupoDeVertices> obtenerGruposDeTresElementos(Set<GrupoDeVertices> conjuntoDeGrupos){
		List<GrupoDeVertices> gruposDe3Elementos = new LinkedList<GrupoDeVertices>();
		
		for (GrupoDeVertices grupo : conjuntoDeGrupos) {
			if (grupo.size() == 3)
				gruposDe3Elementos.add(grupo);
		}
		return gruposDe3Elementos;
	}
	


}
