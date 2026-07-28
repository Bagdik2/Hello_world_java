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
	
	//свой метод для DRY из задания
	public static int myDay(String[] days, boolean bool) {
		int dayCounter = 0;
		
		for (int i = 0; i < days.length; i++) {
			if (isWeekend(days[i]) == bool) {
				dayCounter++;
			}
		}
		
		return dayCounter;
	}
	
	//2-й метод из задания
	public static int weekendCount(String[] days) {
		int weekendCounter = myDay(days, true);
		
		return weekendCounter;
	}
	
	//3-й метод из задания
	public static int weekdayCount(String[] days) {
		int allowedDaysCount = 0;
		for (int i = 0; i < days.length; i++) {
			switch (days[i]) {
			case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday":
				allowedDaysCount++;
				break;
				
			default:
				break;
			}
		}
//		String[] allowedDays = new String[allowedDaysCount];
//		for (int i = 0; i < days.length; i++) {
//			//if( "Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
//		}
		
		int weekdayCounter = myDay(days, false);
		
		return weekdayCounter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		String[] sevenFridays = new String[7];
		String[] dirt = {"Картофель", "Tuesday", "Wednesday", "Яичница", "Friday", "Saturday", "Сапог"};
		Arrays.fill(sevenFridays, "Friday"); 
		System.out.println("Выходных в неделе:" + weekendCount(week));
		System.out.println("Рабочих дней в неделе:" + weekdayCount(week));
		System.out.println("Рабочих дней в семи пятницах:" + weekdayCount(sevenFridays));
		System.out.println("Выходных в семи пятницах:" + weekendCount(sevenFridays));
	}

}
