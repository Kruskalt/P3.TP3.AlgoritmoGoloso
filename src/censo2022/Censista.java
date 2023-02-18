package censo2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Censista {
	
	private int dni;
	private String nombre;
	private ArrayList<Integer> manzanasACensar;

	public Censista(int dni, String nombre) {
		excepcionesConstructor(dni, nombre);
		
		this.dni = dni;
		this.nombre = nombre;
		manzanasACensar = new ArrayList<Integer>(3);
	}

	public void asignarManzana(Integer m) {
		excepcionesAsignarManzana(m);
		manzanasACensar.add(m);
		
	}
	
	public void asignarManzanas(List<Integer> m) {
		asignarManzanasExcepciones(m);
		
		manzanasACensar.addAll(m);
	}

	public ArrayList<Integer> getManzanasACensar() {
		ArrayList<Integer> manzanas = new ArrayList<Integer>();
		for(Integer manza: manzanasACensar)
			manzanas.add(manza);
		return manzanas;
		
	}
	public String nombre() {
		return nombre;
	}
	
	public int dni() {
		return dni;
	}
	
	public int cantManzanas() {
		return manzanasACensar.size();
	}
	
	public boolean censaManzanas() {
		return cantManzanas() != 0;
	}
	
	public boolean puedeCensar() {
		return cantManzanas() < 3;
	}
	
	public void resetManzanas() {
		manzanasACensar = new ArrayList<Integer>();
	}
	
	public String toString() {
		StringBuilder ret = new StringBuilder();
		
		ret.append("\n");
		
		ret.append("Nombre: ").append(nombre).append("\n");
		ret.append("DNI: ").append(dni).append("\n");
		if (manzanasACensar.isEmpty()) {
			ret.append("El censista no fue asignado a ninguna manzana").append("\n");
		}
		else {
			ret.append("Manzanas a censar: ").append("\n");
			
			for (Integer integer : manzanasACensar) {
				ret.append("Manzana numero: ").append(integer).append("\n");
			}
		}
		
		return ret.toString();
		
	}
	
	public String nombreYDNI() {
		StringBuilder ret = new StringBuilder();
		
		ret.append("Nombre: ").append(nombre);
		ret.append("\n");
		ret.append("DNI: ").append(dni);
		
		return ret.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Censista other = (Censista) obj;
		return dni == other.dni;
	}

	private void excepcionesAsignarManzana(Integer m) {
		if (manzanasACensar.contains(m)) {
			throw new IllegalArgumentException("La manzana ya ha sido agregada");
		}
		if (manzanasACensar.size() == 3) {
			throw new IllegalArgumentException("Este censista alcanzo la cantidad maxima de manzanas!");
		}
	}

	private void excepcionesConstructor(int dni, String nombre) {
		if (dni <= 0) {
			throw new IllegalArgumentException("El dni no puede ser negativo ni cero: " + dni);
		}
		if (nombre == null || nombre.equals("")) {
			throw new IllegalArgumentException("Te olvidaste de poner el nombre!");
		}
	}

	private void asignarManzanasExcepciones(List<Integer> m) {
		if (m == null || m.isEmpty()) {
			throw new IllegalArgumentException("La lista esta vacia");
		}
		if (!puedeCensar()) {
			throw new IllegalArgumentException("Este censista ya no puede censar mas manzanas!");
		}
		if (m.size() > 3) {
			throw new IllegalArgumentException("No puede censar esa cantidad de manzanas ya que ya tiene manzanas por censar");
		}
	}
	

}
