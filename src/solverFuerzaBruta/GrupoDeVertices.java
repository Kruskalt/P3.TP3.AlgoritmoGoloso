package solverFuerzaBruta;

import java.util.LinkedList;
import java.util.List;

public class GrupoDeVertices {

	private List<Integer> grupoDeVertices;
	
	public GrupoDeVertices() {
		grupoDeVertices = new LinkedList<Integer> ();
	}

	public GrupoDeVertices(List<Integer> grupoDeVertices) {
		this.grupoDeVertices = new LinkedList<Integer> (grupoDeVertices);
	}

	public void agregarVertice(Integer integer) {
		grupoDeVertices.add(integer);
	}

	public void removerVertice(Integer integer) {
		grupoDeVertices.remove(integer);
	}

	public int size() {
		return grupoDeVertices.size();
	}

	public List<Integer> getList() {
		return grupoDeVertices;
	}
	
	@Override
	public String toString() {
		return grupoDeVertices.toString();
	}
}
