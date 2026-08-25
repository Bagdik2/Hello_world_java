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
		BankWorker worker = new BankWorkerBlueprint();
		
		BankClient jora = new BankClient("Георгий", "Хачапурян", 51, false);
		
		BankClient senya = new BankClient("Арсений", "Моряков", 35, false);
		
		BankClient taras = new BankClient("Тарас", "Бандиченко", 80, true);
		
		System.out.println("____________________________________");
		System.out.println("Клиенту " + jora.getFirstName() + " " + jora.getLastName() + " кредит одобрен?\n" + getCreditForClient(worker, jora));
		
		System.out.println("____________________________________");
		System.out.println("Клиенту " + senya.getFirstName() + " " + senya.getLastName() + " кредит одобрен?\n" + getCreditForClient(worker, senya));

		System.out.println("____________________________________");
		System.out.println("Клиенту " + taras.getFirstName() + " " + taras.getLastName() + " кредит одобрен?\n" + getCreditForClient(worker, taras));
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
	
//	public static interface BankWorker implements Person {
//		
//	}
	
//	boolean checkClientForCredit(BankClient client) throws BadCreditHistoryException, ProblemWithLawException {
//		return false;
//	}
	
	public static class BankWorkerBlueprint implements BankWorker {
		@Override
		public boolean checkClientForCredit(BankClient client) 
				throws BadCreditHistoryException, ProblemWithLawException {
			//Проверпяем проблемы с законом, кидаем исключение если есть
			if (client.getLawProblems()) {
				throw new ProblemWithLawException();
			}
			//Проверяем кредитную историю, если меньше 50 - выкидываем исключение
			if (client.getCreditHistory() < 50) {
				throw new BadCreditHistoryException();
			}
			//Одобряем кредит если не выскочило исключений
			return true;
		}
	}
	
	public static boolean getCreditForClient(BankWorker worker, BankClient client) {
		try {
			return worker.checkClientForCredit(client);
		} catch (BadCreditHistoryException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		} catch (ProblemWithLawException e) {
			// TODO: handle exception
			return false;
		}
	}

}
