package radiocensal;

import java.util.ArrayList;

public class Censista {
	int dni;
	boolean vetado=false;
	private ArrayList<Integer> Manzanasvisitadas;
	Censista(int dni){
		dni=dni;
		 Manzanasvisitadas = new ArrayList<Integer>();
		
	}
	public int getDni() {
		return dni;
	}
	public void estoyvetado() {
		vetado=true;
	}
	public void AñadirManzana(int d) {
		Manzanasvisitadas.add(d);
		
	}
	public boolean yaVisite3Manzanas() {
		return Manzanasvisitadas.size() == 3;
	}
	public int getSizeManzanas() {
		return Manzanasvisitadas.size();
	}
	public boolean haylugar() {
		return Manzanasvisitadas.size()<3;
	}
	
	public boolean noVisiteNingunoTodavia() {
		return Manzanasvisitadas.size()==0;
	}
	public boolean visiteunaManzana() {
		return Manzanasvisitadas.size()==1;
	}
	public boolean visitedosManzanas() {
		return Manzanasvisitadas.size()==2;
	}
	public int Manzanavisitada1() {
		return Manzanasvisitadas.get(0);
	}
	public int dameunaManzanaVisitada(int indice) {
		return Manzanasvisitadas.get(indice);
	}
	public boolean esaManzanaYalavisite(int manzana) {
		return Manzanasvisitadas.contains(manzana);
	}
	@Override
	public String toString() {
		return "Censista [Manzanasvisitadas=" + Manzanasvisitadas + "]";
	}
	

}
