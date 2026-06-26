package hi;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("%c \n", charExpression(5));
		System.out.printf("%d \n", getAgeDiff(Byte.parseByte("5"), (byte) 3));

	}
	
	public static char charExpression(int a) {
		char base = 'a';
		return (char) (base + a);
	}

	public static byte getAgeDiff(byte age1, byte age2) {
		if(age1 > age2) {
			return (byte) (age1 % age2);
		}
		else if(age1 < age2) {
			return (byte) (age2 % age1);
		}
		else if (age1 == age2) {
			return (byte) (0);
		}else {
			return (byte) (0);
		}
	}
}
