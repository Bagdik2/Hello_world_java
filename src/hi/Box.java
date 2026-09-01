package hi;

public class Box<T> {
	private T object;
	
	public Box() {}
	
	public void put(T object) {
		this.object = object;
	}
	
	public static <T> Box<T> getBox() {
		return new Box<T>();
	}
	
	public T get() {
		return object;
	}
}