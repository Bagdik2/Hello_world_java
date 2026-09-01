package hi;

public class HelloWorld {

	public static void main(String[] args) {
		//Вывод содержимого пустого Box по заданию
		Box<String> emptyBox = Box.getBox();
        System.out.println("Box пустой: " + emptyBox.get());
		
		// Использование с разными типами
		Box<String> stringBox = Box.getBox();
		stringBox.put("hello");
		System.out.println("Box с числом: " + stringBox.get());
        
		Box<Integer> intBox = Box.getBox();
		intBox.put(42);
		System.out.println("Box с числом: " + intBox.get());

	}

}
