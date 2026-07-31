package hi;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		JavaStudent javaStudent = new JavaStudent();
		LazyStudent lazyStudent = new LazyStudent();
		student.study();
		javaStudent.study();
		lazyStudent.study();

	}
	
	//1 задание - расширяющий метод
	public static class JavaStudent extends Student {
		
		public JavaStudent() {
			super();
		}
		
		public void study() {
			System.out.println("Я очень занят. Прохожу курс по Java.");
		}
	}
	
	//2 задание - расширяющий метод с @Override
	public static class LazyStudent extends Student{
		
		public LazyStudent() {
			super();
		}
		@Override
		public void study() {
			System.out.println("Сегодня не учусь, мне лень.");
		}
	}

}
