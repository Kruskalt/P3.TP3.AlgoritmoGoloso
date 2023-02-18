package testsCenso2022;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import censo2022.Censista;

public class CensistaTest {
	public Censista censista;

	//(expected = IllegalArgumentException.class)
	@Test
	public void asignarManzanaAcensistaSInManzanas() {
		censista.asignarManzana(2);
		assertEquals(1, censista.cantManzanas());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void asignarLamismaManzanaAcensista() {
		censista.asignarManzana(2);
		censista.asignarManzana(2);
		
	}
	
	@Test
	public void asignar3ManzanasAcensista() {
		censista.asignarManzana(2);
		censista.asignarManzana(1);
		censista.asignarManzana(3);
		assertEquals(3, censista.cantManzanas());
	}
	@Test
	public void asignarManzanasCorrectamente() {
		censista.asignarManzana(2);
		censista.asignarManzana(1);
		censista.asignarManzana(3);
		int[] esperado = {2,1,3};;
		assertTrue( sonIguales(esperado, censista.getManzanasACensar()));
	}
	@Test
	public void asignarManzanasMalAproposito() {
		censista.asignarManzana(2);
		censista.asignarManzana(1);
		
		int[] esperado = {2,1,3};
		assertFalse( sonIguales(esperado, censista.getManzanasACensar()));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void limiteManzanasSobrepasado() {
		censista.asignarManzana(2);
		censista.asignarManzana(1);
		censista.asignarManzana(3);
		censista.asignarManzana(4);
		
	}
	
	public boolean sonIguales(int[] esperado, ArrayList<Integer> arrojado) {
		if(!(esperado.length==arrojado.size()))
			return false;
		for(int i=0; i<esperado.length;i++)
			if(!(esperado[i]==arrojado.get(i)))
				return false;
		return true;
		
	}
	@Before
	public void iniciarCensista() {
		censista=new Censista(1, "Naza");
	}

}
