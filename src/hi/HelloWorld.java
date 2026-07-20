package hi;

public class HelloWorld {
    //3 задача, главный класс
	public static class Robot {
		//turnLeft(), turnRight(), stepForward(), getX(), getY(), getDirection()
		enum Direction {
			RIGHT, LEFT, UP, DOWN
		}
		//3 задача, главный метод
		public static void moveRobot(Robot robot, int toX, int toY) {
			
		}
	}
	
	//Класс Cat 1-й задачи
	public static class Cat {
		public void sayHello() {
			System.out.println("Мяу!");
		}

	}
	//Класс Dog 1-й задачи
	public static class Dog {
		public void sayHello() {
			System.out.println("Ав!");
		}
		public void catchCat(Cat cat) {
			Dog dog = new Dog();
			System.out.println("Кошка поймана");
			dog.sayHello();
			cat.sayHello();
		}

	}
	
	//Enum 2-й задачи
	enum Day {
		  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
		  }
	
	//1-й метод 2 задачи
	public static boolean isWeekend(Day day) {
		if(day == Day.SATURDAY || day == Day.SUNDAY) {
			return true;
		} else {
			return false;
		}
	}
	
	//2-й метод 2 задачи
	public static String getRusName(Day day) {
		String returnString;
		switch(day) {
			case MONDAY:
				returnString  = "Понедельник";
				break;
			case TUESDAY:
				returnString  = "Вторник";
				break;
			case WEDNESDAY:
				returnString  = "Среда";
				break;
			case THURSDAY:
				returnString  = "Четверг";
				break;
			case FRIDAY:
				returnString  = "Пятница";
				break;
			case SATURDAY:
				returnString  = "Суббота";
				break;
			case SUNDAY:
				returnString  = "Воскресенье";
				break;
			default:
				returnString  = "Другой день";
				break;
		}
		return returnString;
	}

	public static void main(String[] args) {
		//Выполнение 1-й задачи
		Dog dog = new Dog();
		Cat cat = new Cat();
		System.out.println("Задача 1:");
		dog.catchCat(cat);
		//Выполнение 2-й задачи
		Day isWeekendDay1 = Day.MONDAY;
		Day isWeekendDay2 = Day.SUNDAY;
		System.out.println("Задача 2, метод 1:");
		System.out.println("Понедельник выходной?");
		System.out.println(isWeekend(isWeekendDay1));
		System.out.println("Воскресенье выходной?");
		System.out.println(isWeekend(isWeekendDay2));
		System.out.println("Задача 2, метод 2:");
		System.out.println("MONDAY это что за день?");
		System.out.println(getRusName(isWeekendDay1));
		System.out.println("SUNDAY это что за день?");
		System.out.println(getRusName(isWeekendDay2));
		//Выполнение 3-й задачи
		System.out.println("Задача 3, метод 1:");
	}

}
