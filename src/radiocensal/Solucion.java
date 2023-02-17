package radiocensal;

import java.util.ArrayList;

public class Solucion {
	private ArrayList<Censista> censistas;;
	public Solucion( ArrayList<Censista> ce) {
		censistas = ce; 
	}
	public String ManzanasdelCensista(int censista) {
		System.out.println("censista="+censista);
		return censistas.get(censista).toString();
	}
			
}
