
public abstract class Account implements IBaseRate{
	//list common properties for saving and checking
	private String name;
	private static int index = 1000;
	private String sSN;
	private double balance;
	protected String accountNumber;
	protected double rate;
	
	
	//constructor
	public Account(String name,String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		balance = initDeposit;
		this.accountNumber = setAccountNumber();
		index++;
		
		setRate();
		//compound();
	}
	
	//set the interest base rate
	public abstract void setRate();
	
	
	//set account number
	private String setAccountNumber() {
		int uniqueID = index;
		int randomNumber = (int)(Math.random() * Math.pow(10, 3));
		String lastTwoSSN = sSN.substring(sSN.length()-2, sSN.length());
		return lastTwoSSN + uniqueID + randomNumber;
	}
	
	//compound interest implementation
	public void compound() {
		double accrueInterest = balance * rate/100;
		balance = balance + accrueInterest;
		System.out.println("Accrue Interest $"+ accrueInterest);
		printBalance();
	}
	
	//implementing common method transactions...
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $"+ amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing $"+amount);
		printBalance();
	}
	
	public void transfer(String toDestination, double amount) {
		System.out.println("Tranfering $"+amount+" to "+ toDestination);
		printBalance();
	}
	
	//print balance after transactions
	public void printBalance() {
		System.out.println("Your balance is $"+balance);
	}
	
	public void showInfo() {
		System.out.println("Name : "+name+
				"\nAccount Number : "+accountNumber
				+"\nBalance "+ balance
				+"\nRate : " +rate + "%");
	}
}
