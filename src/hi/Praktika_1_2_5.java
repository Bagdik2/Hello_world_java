package hi;

public class Praktika_1_2_5 {
	
	public int drawsMonitorsCounter(int monitors, int programmers) {
		
		int monitorsLeft = monitors % programmers;
		
		return monitorsLeft;
		
	}
	
	public double priceCalculation(double price, int count) {
		
		double total = price * count;
		
		return total;
	}
	
	public static void calcCircleRadius(double area) {
		
		double result = (Math.sqrt(area / Math.PI));
		System.out.printf("%.3f", result);
	}
}
