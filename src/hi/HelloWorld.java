package hi;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		
		//1 половина задания
		
		try(Car kar = new Car();) {
			kar.drive();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//2 половина задания
		
		

	}
	
	public static class Car implements AutoCloseable {
				
		public void drive() {
			System.out.println("Машина поехала.");
		}
		
		@Override
		public void close(){
			System.out.println("Машина закрывается...");
		}
	}
	
	public static class BankClient extends Person {
		
		public BankClient(String firstName, String lastName) {
			super();
		}
	}
	
//	public static interface BankWorker implements Person {
//		
//	}
	
	boolean checkClientForCredit(BankClient client) throws BadCreditHistoryException, ProblemWithLawException {
		return false;
	}
	
	void getCreditForClient(BankWorker worker, BankClient client) {
		
	}

}
