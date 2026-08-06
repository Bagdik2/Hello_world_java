package hi;

class MyNewException extends Exception{
	private String alert = "Ооой, делаааа";
	
	public MyNewException(String alert) {
		super(alert);
		this.alert = alert;
	}
	
	public void getAlert (){
		System.out.println(alert);
	}
	
	public void setAlert (String alerted) {
		this.alert = alerted;
	}
	
	public void alerting(String alerta) throws MyNewException {
		throw new MyNewException(alerta); 
	}
}
