package radiocensal;

public class Instancia {
	private Grafo Manzanas;
	
	public Instancia(Grafo grafo){
		Manzanas =grafo;
		
	}
	public void AgregarManzanasContiguas(int i, int j) {
		Manzanas.agregarArista(i, j, 0.0);
	}
	public int getSize() {
		return Manzanas.getTamanio();
	}
	public boolean manzanasVecinas(int a , int b) {
		return Manzanas.existeArista(a, b);
	}
	public Grafo getManzanas() {
		return Manzanas;
	}
	
	

}
