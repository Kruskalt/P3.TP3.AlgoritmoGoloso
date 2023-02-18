package censo2022;

public class StressTestMain {

	public static void main(String[] args) {
		StressTest s = new StressTest(10, 5);
		
		System.out.println(s.stressTestGoloso());
		
		System.out.println("\n" + "SOLVER FUERZA BRUTA");
		
		System.out.println(s.stressTestFuerzaBruta());
	}

}
