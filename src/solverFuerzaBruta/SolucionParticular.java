package solverFuerzaBruta;

import java.util.HashSet;
import java.util.Set;

public class SolucionParticular {
	
	private Set<GrupoDeVertices> solucionParticular;
	
	public SolucionParticular () {
		solucionParticular = new HashSet<GrupoDeVertices>();
	}

	public SolucionParticular(GrupoDeVertices grupoDeVertices) {
		solucionParticular = new HashSet<GrupoDeVertices>();
		solucionParticular.add(grupoDeVertices);
	}

	public void add(GrupoDeVertices grupoDeVertices) {
		solucionParticular.add(grupoDeVertices);
	}

	public int size() {
		return solucionParticular.size();
	}

	public Set<GrupoDeVertices> getSet() {
		return new HashSet<GrupoDeVertices>(solucionParticular);
	}

}
