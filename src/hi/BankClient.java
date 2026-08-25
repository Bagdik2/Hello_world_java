package hi;

public class BankClient extends Person {
	private int creditHistory;
	private boolean lawProblems;
	
	public BankClient(String fn, String ln, int cH, boolean lP) {
		super(fn, ln);
		this.creditHistory = cH;
		this.lawProblems = lP;
	}
	
	public int getCreditHistory() {
		return creditHistory;
	}
	
	public boolean getLawProblems() {
		return lawProblems;
	}
}

