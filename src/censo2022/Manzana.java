package censo2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Manzana {
	private int ID;
	private ArrayList<Manzana> vecinos;
	
	private boolean fueCensada;
	
	public Manzana(int id) {
		ID = id;
		fueCensada = false;
		vecinos = new ArrayList<Manzana>();
	}
	
	public void añadirArista(Manzana m) {
		excepcionesAgregarArista(m);
		vecinos.add(m);
	}

	public boolean existeArista(int m) {
		excepcionExisteArista(m);
		for (Manzana manzana2 : vecinos) {
			if (manzana2.getID() == m) {
				return true;
			}
		}
		return false;
	}

	public void censar() {
		if (fueCensada()) {
			throw new IllegalArgumentException("La manzana ya fue censada");
		}
		fueCensada = true;
	}
	
	public void desCensar() {
		fueCensada = false;
	}
	
	public boolean fueCensada() {
		return fueCensada;
	}
	
	public int getID() {
		return ID;
	}
	
	public Set<Integer> vecinos(){
		HashSet<Integer> ret = new HashSet<Integer>();
		for (Manzana m :vecinos) {
			ret.add(m.getID());
		}
		
		return ret;
	}
	
	public ArrayList<Integer> vecinosList(){
		ArrayList<Integer> ret = new ArrayList<Integer>(vecinos.size());
		Collections.sort(vecinos, (p , q) -> {
			if (p.fueCensada() && !q.fueCensada()) {
				return 1;
			}
			else if (!p.fueCensada() && q.fueCensada()){
				return -1;
			}
			else {
				return 0;
			}
		});
		
		for (Manzana m :vecinos) { //O(E)
			ret.add(m.getID());
		}
		
		return ret;
	}
	
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		
		ret.append("ID: ").append(ID);
		ret.append("\n");
		
		if (vecinos.isEmpty()) {
			ret.append("La manzana no tiene conexiones con otra");
		}
		else {
			ret.append("Manzanas vecinas: ");
			for (Manzana manzana : vecinos) {
				ret.append("| ");
				ret.append(manzana.getID());
				ret.append(" |");
			}
		}
		
		ret.append("\n");
		
		if (fueCensada) {
			ret.append("La manzana fue censada");
		}
		else {
			ret.append("La manzana no fue censada");
		}
		
		return ret.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, fueCensada(), vecinos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manzana other = (Manzana) obj;
		return ID == other.ID && fueCensada() == other.fueCensada() && vecinos.equals(other.vecinos);
	}

	private void excepcionExisteArista(int m) {
		if (m == ID) {
			throw new IllegalArgumentException("Error: no puede haber una conexion entre la misma manzana: " + m);
		}
	}

	private void excepcionesAgregarArista(Manzana m) {
		if (this.equals(m)) {
			throw new IllegalArgumentException("Una manzana no puede ser vecina de ella misma!");
		}
		if (existeArista(m.getID())) {
			throw new IllegalArgumentException("La conexion entre las manzanas: " + ID + " y " + m.getID() + " ya existe");
		}
	}
	
	
}
