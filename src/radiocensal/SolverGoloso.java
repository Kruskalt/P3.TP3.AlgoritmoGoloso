package radiocensal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SolverGoloso {
	private Instancia instancia;
	private ArrayList<Censista> censistas;
	SolverGoloso(Instancia in, ArrayList<Censista> ce){
		instancia =in;
		censistas= ce;
		
		
	}
	public Solucion resolver() {  
		Solucion ret = new Solucion(censistas);   
		
//		ArrayList<Integer>Manzanasusadas = new ArrayList<>();
		
		for(int manza=0; manza<instancia.getSize(); manza++) {
			
			for(int censis=0; censis<censistas.size() ; censis++) {
				
				
				if(censistaTienelugar(censis)  && CensistaSinManzanas(censis)) { // && censistas.get(censis).vetado==false
					
					censistas.get(censis).AñadirManzana(manza);  //censis va a visitar la primera manzana;
					censis = censistas.size();
					
					
				}else  if(censistaTienelugar(censis) && censistaVisitouna(censis) ){
					if(instancia.manzanasVecinas(manza, censistas.get(censis).Manzanavisitada1()) ) { // primero veamos si son vecinas con existeArista;
						censistas.get(censis).AñadirManzana(manza);
						censis = censistas.size();
					}
				}else if(censistaTienelugar(censis) && censistaVisitodos(censis) ) {	//censis tiene lugar? y esta por visitar la tercer manzana?
				
				
					if(existeTrinidad(censistas.get(censis).dameunaManzanaVisitada(0), censistas.get(censis).dameunaManzanaVisitada(1), manza) ){// que la segunda manzana sea vecina con las otras dos;
						censistas.get(censis).AñadirManzana(manza);
						censis = censistas.size();
					}
				}
			}
			
		}
		return ret;

		
		
	}
	public Solucion resolver2() {  
		Solucion ret = new Solucion(censistas);   
		
		boolean [] manzanasusadas = new boolean[instancia.getSize()];
		
		
		for(int censis=0; censis<censistas.size() ; censis++) {
			
			for(int manza=0; manza<instancia.getSize(); manza++) {
				
				
					
				if(censistaTienelugar(censis)  && CensistaSinManzanas(censis) && !manzanasusadas[manza]) { // && censistas.get(censis).vetado==false
					
					censistas.get(censis).AñadirManzana(manza);  //censis va a visitar la primera manzana;
					manzanasusadas[manza]=true;
//					censis = censistas.size();
					
					
					
				}else  if(censistaTienelugar(censis) && censistaVisitouna(censis)&&  !manzanasusadas[manza] ){
					if(instancia.manzanasVecinas(manza, censistas.get(censis).Manzanavisitada1()) ) { // primero veamos si son vecinas con existeArista;
						censistas.get(censis).AñadirManzana(manza);
						manzanasusadas[manza]=true;
						
					}
				}else if(censistaTienelugar(censis) && censistaVisitodos(censis)&& !manzanasusadas[manza] ) {	//censis tiene lugar? y esta por visitar la tercer manzana?
				
				
					if(existeTrinidad(censistas.get(censis).dameunaManzanaVisitada(0), censistas.get(censis).dameunaManzanaVisitada(1), manza) ){// que la segunda manzana sea vecina con las otras dos;
						censistas.get(censis).AñadirManzana(manza);
						manzanasusadas[manza]=true;
					}
					
							
					
				}
				if(censistaVisitodos(censis) && censistaTienelugar(censis)) {
					for(int i=0; i< censistas.get(censis).dameunaManzanaVisitada(1);i++) {
						if( !manzanasusadas[i] && existeTrinidad(censistas.get(censis).dameunaManzanaVisitada(0), censistas.get(censis).dameunaManzanaVisitada(1), i) && !censistas.get(censis).yaVisite3Manzanas()) {
							censistas.get(censis).AñadirManzana(i);
							manzanasusadas[i]=true;
					}
					}
			}
			}
			
		}
		return ret;

		
		
	}
	
	

		
		
	
	
	
	public boolean censistaTienelugar(int indice) {
		return censistas.get(indice).haylugar();
	}
	public boolean CensistaSinManzanas(int indice) {
		return censistas.get(indice).noVisiteNingunoTodavia();
	}
	public boolean censistaVisitouna(int indice) {
		return censistas.get(indice).visiteunaManzana();
	}
	public boolean censistaVisitodos(int indice) {
		return censistas.get(indice).visitedosManzanas();
	}
	public boolean existeTrinidad(int a, int b, int c) {
		if (instancia.manzanasVecinas(a, b) && instancia.manzanasVecinas(c, b))
			return true;
		else if(instancia.manzanasVecinas(a, b) &&  instancia.manzanasVecinas(c, a) )
			return true;
		else
			return false;
	}
	

}
