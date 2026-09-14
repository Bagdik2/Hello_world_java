package hi;

import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		//Старая версия ввода, нужно было вручную переводить пробел
//		try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
//			System.out.println("Введите продажи работника в формате: \"Имя сумма\" (каждая запись с новой строки)");
//			System.out.println("Для завершения ввода нажмите Ctrl+D (Unix) или Ctrl+Z (Windows)");
//			
//			Map<String, Long> salesMap = getSalesMap(consoleReader);
//			
//            System.out.println("\nИтоговые продажи:");
//            for (Map.Entry<String, Long> entry : salesMap.entrySet()) {
//                System.out.println(entry.getKey() + " = " + entry.getValue());
//            }
//		} catch (IOException e) {
//			System.err.println("Ошибка ввода-вывода: " + e.getMessage());
//		}
		//Создаём сканнер для считывания из консоли
		Scanner scanner = new Scanner(System.in);
		//Описываем работу программы в консоли для удобства
		System.out.println("Введите данные как в примере:");
		System.out.println("Алексей 3000 / Дмитрий 9000 / Антон 3000 / Алексей 7000");
		//Записываем данные из сканнера в строковую переменную после первого перевода на новую строку и закрываем сканнер
		String input = scanner.nextLine();
		scanner.close();
		//Добавляем регулярные выражения для раздела строки, как в примере через слеш, в том числе с пробелами, все слеши заменяем на 
		String data = input.replaceAll("\\s*/\\s*", "\n");
		
		try (StringReader reader = new StringReader(data)) {
			//Создаём мап с ключём/значением из ридера, созданного из строки что мы взяли из консоли выше
			Map<String, Long> salesMap = getSalesMap(reader);
			
			System.out.println("/nИтоговые продажи:");
			//При помощи тернарного оператора построчно выводим сумму заработтанных продавцами денег
			for (Map.Entry<String, Long> entry : salesMap.entrySet()) {
				System.out.println(entry.getKey() + " = " + entry.getValue());
			}
			
		} catch (IOException e) { //просто выводим ошибку, если с вводом/выводом что-то не так
			// TODO: handle exception
			System.err.println("Ошибка обработки данных:" + e.getMessage());
		}
	}
	
	public static Map<String, Long> getSalesMap(Reader reader) throws IOException {
		
		BufferedReader bufferReader = new BufferedReader(reader);
		
		Map<String, Long> salesMap = new HashMap<>();
		
		String line;
		while((line = bufferReader.readLine()) != null) {
			String trimmedLine = line.trim();
			
			if (trimmedLine.isEmpty()) {
				continue;
			}
			//
			String[] parts = trimmedLine.split("\\s+");
			if (parts.length != 2) {
				continue;
			}
			
			String name = parts[0];
			long amount;
			try {
				amount = Long.parseLong(parts[1]);
			} catch (NumberFormatException e) {
				continue;
			}
			
			salesMap.merge(name, amount, Long::sum);
			
		}
		
		return salesMap;
	}

}
