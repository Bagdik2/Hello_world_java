package hi;

import java.math.BigInteger;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(5));

	}
	
	public static boolean isWeekend(String weekday) {

		switch (weekday) {
		    case "Saturday":
		    case "Sunday":
		        System.out.println("Выходной!");
		        return true;

		    case "Monday":
		    case "Tuesday":
		    case "Wednesday":
		    case "Thursday":
		    case "Friday":
		        System.out.println("Рабочий день");
		        return false;

		    default:
		        System.out.println("Другой день");
		        return false;
		}
	}
	
	public static boolean isWeekend(int weekDayNumber) {
		if (weekDayNumber <= 5) {
			return false;
		}
		if (weekDayNumber > 5 && weekDayNumber < 8) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String checkWeekend(String weekday) {
		boolean isWeekend = weekday.equals("Saturday") || weekday.equals("Sunday");
		String message = isWeekend ? "Ура, выходной!" : "Надо ещё поработать";
		return message;
	}
	
	public int determineGroup(int age) {
		if (age >= 7 && age <= 14) {
			return 1;
		} else if (age >= 15 && age <= 17) {
			return 2;
		} else if (age >= 18 && age <= 65) {
			return 3;
		} else {
			return -1;
		}
	}
	
	public static BigInteger factorial(int value) {
		BigInteger output = BigInteger.valueOf(1);
		for(int i = 1; i < value; i++) {
			output = output.multiply(BigInteger.valueOf(i))  ; 
		}
		return output;
	}

}
