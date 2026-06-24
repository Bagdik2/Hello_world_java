package hi;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Инициализация переменных
		byte varByte = 5;
		short varShort = 4;
		int varInt = 3;
		long varLong = 999999L; 
		float varFloat = 6.9f;
		double varDouble = 3.333d;
		boolean varBoolean = true;
		char varChar = '\u006A';
		
		//Инициализация списка для переменных
		List<Object> primitiveList = new ArrayList<>();
		
		//Добавление переменных в список
		primitiveList.add(varByte   );
		primitiveList.add(varShort  );
		primitiveList.add(varInt    );
		primitiveList.add(varLong   );
		primitiveList.add(varFloat  );
		primitiveList.add(varDouble );
		primitiveList.add(varBoolean);
		primitiveList.add(varChar   );
		
		//Вывод списка переменных для наглядности
		for(Object element : primitiveList) {
			System.out.println("Значение: " + element + " \t| Тип: " + element.getClass().getSimpleName());
		}
	}

}
