package hi;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		JavaStudent javaStudent = new JavaStudent();
		student.study();
		javaStudent.study();

	}
	
	public static class JavaStudent extends Student {
		
		public JavaStudent() {
			super();
		}
		
		public void study() {
			System.out.println("Я очень занят. Прохожу курс по Java.");
		}
	}

}
