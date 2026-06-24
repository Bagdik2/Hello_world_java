package hi;

public class HelloWorld {

	public static void main(String[] args) {
		
		//Экземпляр класса Praktika_1_2_5 для использования методов
		Praktika_1_2_5 sample = new Praktika_1_2_5();
		
		//Экземпляр метода вычисления количества свободных мониторов
		int result = sample.drawsMonitorsCounter(10, 3);
		//Экземпляр метода вычисления цены
		double price = sample.priceCalculation(8.50, 2);
		
		System.out.println(result);
		System.out.println(price);
		//Статичный метод вычисления радиуса, не требует экземпляра класа, используется внутри класса
		Praktika_1_2_5.calcCircleRadius(123);

	}

}
