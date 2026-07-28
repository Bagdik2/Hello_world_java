package hi;

import java.util.Arrays;

public class HelloWorld {
	
	//1-й метод из задания
	public static boolean isWeekend(String dayName) {
		return switch (dayName) {
		case "Saturday","Sunday" -> true;

		default -> false;
		};
		
	}
	
	//2-й метод из задания
	public static int weekendCount(String[] days) {
		int weekendCounter = weekdayCount(days);
		
		return days.length - weekendCounter;
	}
	
	//3-й метод из задания
	public static int weekdayCount(String[] days) {

		int dayCounter = 0;
		
		for (int i = 0; i < days.length; i++) {
			if (isWeekend(days[i]) == false) {
				dayCounter++;
			}
		}
		
		return dayCounter;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		String[] sevenFridays = new String[7];
		Arrays.fill(sevenFridays, "Friday"); 
		System.out.println("Выходных в неделе:" + weekendCount(week));
		System.out.println("Рабочих дней в неделе:" + weekdayCount(week));
		System.out.println("Рабочих дней в семи пятницах:" + weekdayCount(sevenFridays));
		System.out.println("Выходных в семи пятницах:" + weekendCount(sevenFridays));
	}

}
