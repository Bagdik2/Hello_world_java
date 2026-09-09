package hi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class HelloWorld {

	public static void main(String[] args) {
		try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Введите продажи работника в формате: \"Имя сумма\" (каждая запись с новой строки)");
			System.out.println("Для завершения ввода нажмите Ctrl+D (Unix) или Ctrl+Z (Windows)");
			
			Map<String, Long> salesMap = getSalesMap(consoleReader);
			
            System.out.println("\nИтоговые продажи:");
            for (Map.Entry<String, Long> entry : salesMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
		} catch (IOException e) {
			System.err.println("Ошибка ввода-вывода: " + e.getMessage());
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
