package hi;

public class Person {
	private String firstName;
	private String lastName;
	
	Person(String fn, String ln) {
		this.firstName = fn;
		this.lastName = ln;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
}
