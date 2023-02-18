package solverFuerzaBruta;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

import censo2022.Ciudad;
import testsCenso2022.Assert;

public class AuxiliaresTest {
	Ciudad grafoprueba;
	List<Integer> grupoActualprueba;
	
	@Test
	public void SinConexionesNigrupo () {
		grafoprueba = new Ciudad(5);
		grupoActualprueba = new ArrayList<>();
		
		assertFalse(Auxiliares.esTernaValida(grafoprueba, grupoActualprueba));
	}
	
	@Test
	public void   ElduoNoestaconectado() {
		grafoprueba = new Ciudad(5);
		grupoActualprueba = new ArrayList<>();
		grupoActualprueba.add(1);
		grupoActualprueba.add(2);
		assertFalse(Auxiliares.esTernaValida(grafoprueba, grupoActualprueba));;
	}
	
	@Test
	public void   ElduoEstaconectadoYesvalido() {
		grafoprueba = new Ciudad(5);
		grafoprueba.agregarArista(1, 2);
		
		grupoActualprueba = new ArrayList<>();
		grupoActualprueba.add(1);
		grupoActualprueba.add(2);
		
		assertTrue(Auxiliares.esTernaValida(grafoprueba, grupoActualprueba));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void   ElduosobrepasaAlgrafo() {
		grafoprueba = new Ciudad(2);
		
		
		grupoActualprueba = new ArrayList<>();
		grupoActualprueba.add(3);
		grupoActualprueba.add(4);
		
		assertFalse(Auxiliares.esTernaValida(grafoprueba, grupoActualprueba));
	}
	
	@Test
	public void   ternaValida_Elprimero_EnOrden_EsVecino_DeLosOtrosDos() {
		grafoprueba = new Ciudad(5);
		grafoprueba.agregarArista(1, 2);
		grafoprueba.agregarArista(1, 3);
		
		grupoActualprueba = new ArrayList<>();
		grupoActualprueba.add(1);
		grupoActualprueba.add(2);
		grupoActualprueba.add(3);
	
		
		assertTrue(Auxiliares.esTernaValida(grafoprueba, grupoActualprueba));
	}
	
	@Test
	public void   ternaValida_Elsegundo_EnOrden_EsVecino_DeLosOtrosDos() {
		grafoprueba = new Ciudad(5);
		grafoprueba.agregarArista(2, 1);
		grafoprueba.agregarArista(2, 3);
		
		grupoActualprueba = new ArrayList<>();
		grupoActualprueba.add(1);
		grupoActualprueba.add(2);
		grupoActualprueba.add(3);
	
		
		assertTrue(Auxiliares.esTernaValida(grafoprueba, grupoActualprueba));
	}
	
	@Test
	public void   ternaValida_Eltercero_EnOrden_EsVecino_DeLosOtrosDos() {
		grafoprueba = new Ciudad(5);
		grafoprueba.agregarArista(3, 1);
		grafoprueba.agregarArista(3, 2);
		
		grupoActualprueba = new ArrayList<>();
		grupoActualprueba.add(1);
		grupoActualprueba.add(2);
		grupoActualprueba.add(3);
	
		
		assertTrue(Auxiliares.esTernaValida(grafoprueba, grupoActualprueba));
	}

	
	//tests para  obtenerGruposDeTresElementos(Set<GrupoDeVertices> conjuntoDeGrupos)
	
	@Test
	public void   obtenerGrupotriple_deunaListaVacia() {
		Set<GrupoDeVertices> conjuntoDeGrupos = new HashSet<GrupoDeVertices>();
		
			assertEquals(0,Auxiliares.obtenerGruposDeTresElementos(conjuntoDeGrupos).size());
	}
	
	@Test
	public void   obtenerGrupoDetriples_ultimos2() {
		Set<GrupoDeVertices> conjuntoDeGrupos = new HashSet<GrupoDeVertices>();
		
		GrupoDeVertices grupo1 = new GrupoDeVertices();
		grupo1.agregarVertice(1);
		
		GrupoDeVertices grupo2 = new GrupoDeVertices();
		grupo2.agregarVertice(1);
		grupo2.agregarVertice(2);
		grupo2.agregarVertice(3);
		
		GrupoDeVertices grupo3= new GrupoDeVertices();
		grupo3.agregarVertice(4);
		grupo3.agregarVertice(5);
		grupo3.agregarVertice(6);
		
		conjuntoDeGrupos.add(grupo1);
		conjuntoDeGrupos.add(grupo2);
		conjuntoDeGrupos.add(grupo3);
		
		List<GrupoDeVertices> ret = Auxiliares.obtenerGruposDeTresElementos(conjuntoDeGrupos);
		
		
		int[] esperado = {4,5,6};
		int[] esperado2 = {1,2,3};
		
//		ret.get(1).getList().stream().forEach(e->System.out.println(e));
		
//		ret.get(1).getList().stream().forEach(e -> esperado.contains(e));
	Assert.iguales(esperado2, ret.get(0).getList() );
	Assert.iguales(esperado, ret.get(1).getList() );
	}
	
	@Test
	public void   obtenerGrupoDetriples_primerPosYultima() {
		Set<GrupoDeVertices> conjuntoDeGrupos = new HashSet<GrupoDeVertices>();
		
		GrupoDeVertices grupo1 = new GrupoDeVertices();
		grupo1.agregarVertice(1);
		grupo1.agregarVertice(2);
		grupo1.agregarVertice(3);
		
		GrupoDeVertices grupo2 = new GrupoDeVertices();
		grupo2.agregarVertice(1);
		
		GrupoDeVertices grupo3= new GrupoDeVertices();
		grupo3.agregarVertice(4);
		grupo3.agregarVertice(5);
		grupo3.agregarVertice(6);
		
		conjuntoDeGrupos.add(grupo1);
		conjuntoDeGrupos.add(grupo2);
		conjuntoDeGrupos.add(grupo3);
		
		List<GrupoDeVertices> ret = Auxiliares.obtenerGruposDeTresElementos(conjuntoDeGrupos);
		
		System.out.println(ret);
		
		int[] esperado = {1,2,3};
		int[] esperado2 = {4,5,6};
		

		Assert.iguales(esperado, ret.get(1).getList() );
		Assert.iguales(esperado2, ret.get(0).getList() );
	}
	
	
}
