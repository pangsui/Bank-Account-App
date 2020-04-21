
public class Checking extends Account {
	//list properties specific to checking account
	private int debitCardNumber;
	private int debitCardPin;
	//call constructor 
	public Checking(String name,String sSN, double initDeposit) {
		super(name,sSN, initDeposit);
		accountNumber = "2" + accountNumber;	
		setDebitCard();
	}
	
	@Override
	public void setRate() {
	rate = 0.15 * getBaseRate();	
	}
	
	//method specific only to checking acount
	private void setDebitCard() {
		debitCardNumber = (int)(Math.random() * Math.pow(10, 12));
		debitCardPin = (int)(Math.random() * Math.pow(10, 4));
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Checking Account features\n"
				+ "Debit Card Number is "+ debitCardNumber
				+"\nDebit Card PIN is "+ debitCardPin);
	}
}
