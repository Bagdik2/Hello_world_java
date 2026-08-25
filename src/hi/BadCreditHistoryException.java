package hi;

public class BadCreditHistoryException extends Exception {

	public BadCreditHistoryException() {
		super("Плохая кредитная история");
	}
	
	public BadCreditHistoryException(String message) {
		super(message);
	}
}
