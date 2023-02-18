package censo2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Ciudad {

	private int vertices;
	private Manzana[] manzanas;

	public Ciudad(int vertices) {
		this.vertices = vertices;
		manzanas = new Manzana[this.vertices];

		for (int i = 0; i < manzanas.length; i++) {
			manzanas[i] = new Manzana(i);
		}
	}

	public void agregarArista(int origen, int destino) {

		verificarVertice(origen);
		verificarVertice(destino);
		verificarDistintos(origen, destino);
		verificarAristaCreada(origen, destino);

		manzanas[origen].añadirArista(manzanas[destino]);
		manzanas[destino].añadirArista(manzanas[origen]);

	}

	public boolean existeArista(int origen, int destino) {
		verificarVertice(origen);
		verificarVertice(destino);
		verificarDistintos(origen, destino);

		return manzanas[origen].existeArista(destino) && manzanas[destino].existeArista(origen);
	}

	public boolean fueCensada(int i) {
		verificarVertice(i);

		return manzanas[i].fueCensada();
	}

	public void censar(int i) {
		verificarVertice(i);

		manzanas[i].censar();
	}

	public void desCensar(int i) {
		verificarVertice(i);

		manzanas[i].desCensar();
	}

	public Set<Integer> vecinos(int i) {
		verificarVertice(i);

		return manzanas[i].vecinos();
	}

	public ArrayList<Integer> vecinosList(int i) {
		verificarVertice(i);

		return manzanas[i].vecinosList();
	}

	public int getTamanio() {
		return vertices;
	}

	public List<Integer> getVertices() {
		List<Integer> lista = new ArrayList<Integer>(vertices);

		for (int i = 0; i < vertices; i++) {
			lista.add(manzanas[i].getID());
		}

		return lista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(manzanas);
		result = prime * result + Objects.hash(vertices);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudad other = (Ciudad) obj;
		return Arrays.equals(manzanas, other.manzanas) && vertices == other.vertices;
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();

		for (Manzana manzana : manzanas) {
			ret.append(manzana);
			ret.append("\n");
			ret.append("\n");
		}

		return ret.toString();
	}

	private void verificarAristaCreada(int origen, int destino) {
		if (existeArista(origen, destino)) {
			throw new IllegalArgumentException("Las manzanas: " + origen + " - " + destino + " ya estan conectadas!");
		}
	}

	private void verificarDistintos(int i, int j) {
		if (i == j)
			throw new IllegalArgumentException(
					"Una manzana no puede estar conectada con ella misma! : (" + i + ", " + j + ")");
	}

	private void verificarVertice(int i) {
		if (i < 0 || i >= manzanas.length)
			throw new IllegalArgumentException("Los ID de las manzanas estan entre 0 y " + (this.getTamanio() - 1)
					+ ". El ID: " + i + " no existe!");
	}

}
