package hi;

public interface BankWorker {
	boolean checkClientForCredit(BankClient client)
			throws BadCreditHistoryException, ProblemWithLawException;
}
