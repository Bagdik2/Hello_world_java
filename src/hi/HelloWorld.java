package hi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorld {

	public static void main(String[] args) {
		//Выполнение 1-й задачи
		System.out.println("Задача 1");
		String name = "Bogdan";
		System.out.println(name);
		//Выполнение 2-й задачи
		System.out.println("Задача 2");
		parseAndPrintNumber("64");
		parseAndPrintNumber("111");
		//Выполнение 3-й задачи
		System.out.println("Задача 3");
		isPalindrome("Was it a cat I saw?");
		isPalindrome("По ТОП");
		isPalindrome("Топ?ОТ!");
		isPalindrome("Регулярное выражение");
		//Выполнение 4-й задачи
		System.out.println("Задача 4");
		System.out.println(isGmailOrOutlook("SayGex322@gmail.com"));
		System.out.println(isGmailOrOutlook("SesbianLex228@outlook.com"));
		System.out.println(isGmailOrOutlook("helloworld@yandex.ru"));
		System.out.println(isGmailOrOutlook("helloworld"));
		System.out.println(isGmailOrOutlook("@gmail.com"));

	}
	
	//Метод 2-й задачи
	public static void parseAndPrintNumber(String number) {
		int returnNumber = Integer.parseInt(number) / 2;
		System.out.println(returnNumber);
	}
	
	//Метод  3-й задачи
	public static void isPalindrome(String text) {
		StringBuilder sb = new StringBuilder();
		String cleanedText = text.replaceAll("\\p{P}|\\s", "");
		sb.append(cleanedText);
		sb.reverse();
		String textBackflip = sb.toString();
		//System.out.println(textBackflip);
		System.out.println(cleanedText.equalsIgnoreCase(textBackflip));
	}
	
	//Метод  4-й задачи
	public static boolean isGmailOrOutlook(String email) {
		//regex = regular expression = Регулярное выражение
		String regex = "^[a-zA-Z0-9+_.-]+(@gmail\\.com|@outlook\\.com)$";
		//Паттерн с флагом на неосприимчиость к регистру
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		
		Matcher matcher = p.matcher(email);
		
		return matcher.matches();
	}
}

