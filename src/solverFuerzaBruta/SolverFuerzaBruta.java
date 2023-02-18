package solverFuerzaBruta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import censo2022.BFS;
import censo2022.Censista;
import censo2022.Ciudad;
import censo2022.Solucion;

public class SolverFuerzaBruta {
	
	private Ciudad grafo;
	private List<Integer> vertices;
	
	private GrupoDeVertices grupoActual;
	private Set<GrupoDeVertices> conjuntoDeGrupos;
	
	private List<Censista> censistas;
	
	private SolucionGeneral solucionOptima;
	
	public SolverFuerzaBruta(Ciudad g) {
		if (!BFS.esConexo(g))
			throw new RuntimeException("El grafo no es conexo.");
		
		grafo = g;
		vertices = grafo.getVertices();
		conjuntoDeGrupos = new HashSet<GrupoDeVertices>();
		solucionOptima = new SolucionGeneral();
	}
	
	public SolverFuerzaBruta(Ciudad g, List<Censista> L) {
		if (!BFS.esConexo(g))
			throw new RuntimeException("El grafo no es conexo.");
		if (L == null || L.isEmpty()) {
			throw new RuntimeException("Te olvidaste de añadir censistas");
		}
		
		grafo = g;
		vertices = grafo.getVertices();
		conjuntoDeGrupos = new HashSet<GrupoDeVertices>();
		solucionOptima = new SolucionGeneral();
		censistas = L;
	}
	
	public Solucion resolver() {
		generarSolucionOptima();
	
		for (GrupoDeVertices grupo: solucionOptima.getSet()) {
			if (!todosCensistasOcupados()) {
				censistas.get(0).asignarManzanas(grupo.getList());
				for (Integer vertice : grupo.getList()) {
					grafo.censar(vertice);
				}
			}
			else {
				break;
			}
		}
		
		return new Solucion(grafo, new ArrayList<Censista>(censistas));
	}
	
	private boolean todosCensistasOcupados() {
		Collections.sort(censistas, (p,q) -> p.cantManzanas() - q.cantManzanas()); //O(c . log (c))
		return censistas.get(0).censaManzanas(); //O(1)
	}
	
	Set<GrupoDeVertices> generarSolucionOptima(){
		if (vertices.size() == 2) {
			solucionTrivial();
		}
		grupoActual = new GrupoDeVertices();
		generarDesde(0);
		buscarMejorSolucion();
		
		return solucionOptima.getSet();
	}

	// Implementa la recursión
	private void generarDesde(int indice){
		if (indice == grafo.getTamanio()){
			
			// Caso base
			if	(Auxiliares.esTernaValida(grafo, grupoActual.getList())) 
				conjuntoDeGrupos.add(Auxiliares.clonar(grupoActual.getList()));
		}
		else{
			
			// Caso recursivo
			grupoActual.agregarVertice(vertices.get(indice));
			generarDesde(indice+1);
			
			grupoActual.removerVertice(vertices.get(indice));
			generarDesde(indice+1);
		}
	}

	private void buscarMejorSolucion() {
		List<GrupoDeVertices> gruposDe3vertices = Auxiliares.obtenerGruposDeTresElementos(conjuntoDeGrupos);
		
		for (int i = 0; i < gruposDe3vertices.size(); i++) {
			List<Integer> verticesPorRecorrer = new ArrayList<Integer> (vertices.size());
			
			SolucionParticular solucionParticular = new SolucionParticular(gruposDe3vertices.get(i));
			for (Integer vertice: gruposDe3vertices.get(i).getList()) {
				verticesPorRecorrer.add(vertice);
			}
			
			int gruposDe = 3;
			
			// recorro los grupos de 3 vertices
			while (gruposDe > 0) {
				for (GrupoDeVertices grupo: conjuntoDeGrupos) {
					boolean ret = true;
					if (grupo.size() == gruposDe) {
						//compruebo que la terna tiene todos los vertices sin recorrer.
						for (Integer v: grupo.getList()) 
							ret = ret && !verticesPorRecorrer.contains(v);
						
						if (ret) {
							//luego marco los vertices
							for (Integer v: grupo.getList())
								verticesPorRecorrer.add(v);
							//luego añado la terna al conjunto solucion
							solucionParticular.add(grupo);
						}
					}
				}
				gruposDe--;
			}
			
			if (solucionOptima.size() == 0 || solucionOptima.size() > solucionParticular.size()) {
				//System.out.println(conjuntoSolucionOptima.toString() + " -> " + conjuntoSolucionParticular.toString());
				solucionOptima.cambiarConjunto(solucionParticular.getSet());
			}
		}
	}
	
	private void solucionTrivial() {
		GrupoDeVertices grupoTrivial = new GrupoDeVertices();
		grupoTrivial.agregarVertice(0);
		grupoTrivial.agregarVertice(1);
		
		SolucionParticular sp = new SolucionParticular();
		sp.add(grupoTrivial);
		
		solucionOptima.cambiarConjunto(sp.getSet());
	}
}
