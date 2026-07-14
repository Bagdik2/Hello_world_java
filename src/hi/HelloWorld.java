package hi;

public class HelloWorld {

	public static void main(String[] args) {
		//Выполнение первой задачи
		String name = "Bogdan";
		System.out.println(name);
		//Выполнение второй задачи
		parseAndPrintNumber("64");
		parseAndPrintNumber("111");
		//Выполнение третьей задачи
		isPalindrome("Was it a cat I saw?");

	}
	public static void parseAndPrintNumber(String number) {
		int returnNumber = Integer.parseInt(number) / 2;
		System.out.println(returnNumber);
	}
	
	public static void isPalindrome(String text) {
		StringBuilder sb = new StringBuilder();
		sb.append(text);
		sb.reverse();
		String textBackflip = sb.toString();
		System.out.println(textBackflip);
		System.out.println(text.equalsIgnoreCase(textBackflip));
	}
}

