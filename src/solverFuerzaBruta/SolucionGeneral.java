package solverFuerzaBruta;

import java.util.HashSet;
import java.util.Set;

public class SolucionGeneral {
	
	private Set<GrupoDeVertices> solucionGeneral;
	
	public SolucionGeneral () {
		solucionGeneral = new HashSet<GrupoDeVertices>();
	}
	
	public void cambiarConjunto (Set<GrupoDeVertices> conjunto) {
		solucionGeneral = conjunto;
	}

	public Set<GrupoDeVertices> getSet() {
		return new HashSet<GrupoDeVertices>(solucionGeneral);
	}

	public int size() {
		return solucionGeneral.size();
	}
}
