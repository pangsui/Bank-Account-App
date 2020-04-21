
public class Savings extends Account {
	//properties specific to saving account
	private int safetyDepositBoxID;
	private int safetyDepositKey;
	//constructors
	public Savings(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "1" + accountNumber;
		safetyDeposit();	
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() - 0.25;
	}
	
	//method specific only to savings account
	private void safetyDeposit() {
		safetyDepositBoxID = (int)(Math.random() * Math.pow(10, 3));
		safetyDepositKey = (int)(Math.random() * Math.pow(10, 4));
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Saving Account features\nSafety deposit box ID : "
				+ ""+ safetyDepositBoxID
				+"\nSafety deposit key : "+ safetyDepositKey);
		
	}

}
