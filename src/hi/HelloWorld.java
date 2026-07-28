package hi;

public class HelloWorld {
    
	enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	//3 задача, главный класс
	public static class Robot {
		
		int posX;
		int posY;
		Direction lookingAt;
		
		public Robot() {
			this.posX = 0;
			this.posY = 0;
			this.lookingAt = Direction.UP;
		}
		
		public Robot(int xxx, int yyy) {
			this.posX = xxx;
			this.posY = yyy;
			this.lookingAt = Direction.UP;
		}
		
		public Robot(int xxx, int yyy, Direction look) {
			this.posX = xxx;
			this.posY = yyy;
			this.lookingAt = Direction.UP;
		}
		
		private void turnLeft() {
			switch(this.lookingAt) {
			case UP:
				this.lookingAt = Direction.LEFT;
				break;
			case RIGHT:
				this.lookingAt = Direction.UP;
				break;
			case DOWN:
				this.lookingAt = Direction.RIGHT;
				break;
			case LEFT:
				this.lookingAt = Direction.DOWN;
				break;
			default:
				break;
			}
			System.out.println("Turned left");
		}
		
		private void turnRight() {
			switch(this.lookingAt) {
			case UP:
				this.lookingAt = Direction.RIGHT;
				break;
			case RIGHT:
				this.lookingAt = Direction.DOWN;
				break;
			case DOWN:
				this.lookingAt = Direction.LEFT;
				break;
			case LEFT:
				this.lookingAt = Direction.UP;
				break;
			default:
				break;
			}
			System.out.println("Turned right");
		}
		
		private void stepForward() {
			switch (this.lookingAt) {
			case UP:
				this.posY++;
				break;
			case DOWN:
				this.posY--;
				break;
			case LEFT:
				this.posX--;
				break;
			case RIGHT:
				this.posX++;
				break;

			default:
				break;
			}
			System.out.println("Stepped forward");
		}
		
		private int getX() {
			return this.posX;
		}
		
		private int getY() {
			return this.posY;
		}
		
		private Direction getDirection() {
			return this.lookingAt;
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
	
	//3 задача, главный метод
	public static void moveRobot(Robot robot, int toX, int toY) {
		//robot.turnLeft();
		int currentX = robot.getX();
		int currentY = robot.getY();
		Direction dir = robot.getDirection();
		
		if(robot.getX() < toX) {
			while(robot.getDirection() != Direction.RIGHT) {
				robot.turnRight();
			}
			while(robot.getX() < toX) {
				robot.stepForward();
			}
		}
		
		if(robot.getX() > toX) {
			while(robot.getDirection() != Direction.LEFT) {
				robot.turnLeft();
			}
			while(robot.getX() > toX) {
				robot.stepForward();
			}
		}
		
		if(robot.getY() < toY) {
			while(robot.getDirection() != Direction.UP) {
				robot.turnRight();
			}
			while(robot.getY() < toY) {
				robot.stepForward();
			}
		}
		
		if(robot.getY() > toY) {
			while(robot.getDirection() != Direction.DOWN) {
				robot.turnLeft();
			}
			while(robot.getY() > toY) {
				robot.stepForward();
			}
		}
		
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
		System.out.println("Задача 3:");
		//Инициализация объектов и переменных 3 задачи
		Robot robert = new Robot();
		System.out.println("Создан робот, x робота: " + robert.getX() + "; y робота:" + robert.getY());
		moveRobot(robert, 3, 0);
		System.out.println("x робота: " + robert.getX() + "; y робота:" + robert.getY());
		Robot robert1 = new Robot(-3, 7);
		System.out.println("Создан робот, x робота: " + robert1.getX() + "; y робота:" + robert1.getY());
		moveRobot(robert1, -1, 6);
		System.out.println("x робота: " + robert1.getX() + "; y робота:" + robert1.getY());
	}

}
