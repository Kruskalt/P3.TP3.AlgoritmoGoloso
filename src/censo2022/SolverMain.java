package censo2022;

import java.util.ArrayList;
public class SolverMain {

	
	public static void main(String args[]) {
		for (Censista c : listaCensistas(4)) {
			System.out.println(c.nombreYDNI());
		}
		
		SolverGoloso s0 = new SolverGoloso(grafoCon6Vertices(), listaCensistas(6));
		SolverGoloso s1 = new SolverGoloso(grafoCon16Vertices(), listaCensistas(6));
		
		System.out.println("SOLVER CON 6 VERTICES");
		System.out.println(s0.resolver().getCensistas());
		
		System.out.println("\n");
		
		System.out.println("SOLVER CON 16 VERTICES");
		System.out.println(s1.resolver().getCensistas());	
		
		System.out.println("\n");
		
		System.out.println("PRUEBA RadioCensal");
		
		
		RadioCensal r = RadioCensal.crearRadioCensal(grafoCon6Vertices(), listaCensistas(6));
		r.censar();
		
		System.out.println(r.censistasToString());
		System.out.println(r.ciudadToString());
	}
	
	private static ArrayList<Censista> listaCensistas(int n){
		ArrayList<Censista> cen = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			cen.add(new Censista(i, "" + i));
		}
		
		return cen;
	}
	private static Ciudad grafoCon6Vertices() {
		Ciudad ret = new Ciudad(6);
		ret.agregarArista(0, 1);
		ret.agregarArista(1, 2);
		ret.agregarArista(2, 3);
		ret.agregarArista(2, 4);
		ret.agregarArista(2, 5);
		
		return ret;
	}

	public static Ciudad grafoCon16Vertices() {
		Ciudad ret = new Ciudad(16);
		ret.agregarArista(0, 1);
		ret.agregarArista(0, 4);
		
		ret.agregarArista(1, 2);
		ret.agregarArista(1, 5);
		
		ret.agregarArista(2, 3);
		ret.agregarArista(2, 6);
		
		ret.agregarArista(3, 7);
		
		ret.agregarArista(4, 5);
		ret.agregarArista(4, 8);
		
		ret.agregarArista(5, 6);
		ret.agregarArista(5, 9);
		
		ret.agregarArista(6, 7);
		ret.agregarArista(6, 10);
		
		ret.agregarArista(7, 11);
		
		ret.agregarArista(8, 9);
		ret.agregarArista(8, 12);
		
		ret.agregarArista(9, 10);
		ret.agregarArista(9, 13);
		
		ret.agregarArista(10, 11);
		ret.agregarArista(10, 14);
		
		ret.agregarArista(11, 15);
		
		ret.agregarArista(12, 13);
		
		ret.agregarArista(13, 14);
		
		ret.agregarArista(14, 15);
		
		return ret;
	}
}
