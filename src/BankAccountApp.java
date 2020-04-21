import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {

		List<Account> accounts = new LinkedList<Account>();
		
		String file = "C:\\Users\\win\\eclipse-workspace\\Files\\company.txt";

		try {
		List<String[]> accountHolders = utilities.CSV.read(file);
		for(String[] accountHolder:accountHolders) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			//System.out.println(name +" "+ sSN +" "+accountType+" $"+ initDeposit);
			
			if( accountType.equals("savings")) {
			     accounts.add(new Savings(name,sSN,initDeposit));
			}
			else if( accountType.equals("checking")) {
				accounts.add(new Checking(name,sSN,initDeposit));
			}
			else System.out.println("NO ACCOUNT TYPE FOUND");
		}	
		} 
		catch(Exception e) {
			System.out.println("Could not read file");
		}
		
		for(Account account:accounts) {
			System.out.println("\n************");
			account.showInfo();
		}
	}

}
