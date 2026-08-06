package hi;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		testExp();

	}
	
	public static void testExp() {
		String expTxt1 = "Ой бедааааа!";
		String expTxt2 = "Вот так вот, да!";
		MyNewException exception = new MyNewException(expTxt1);
		exception.getAlert();
		exception.setAlert(expTxt2);
		exception.getAlert();
		System.out.println(exception);
	}

}
