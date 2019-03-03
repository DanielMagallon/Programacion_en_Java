package C11ATM;

public class BankDatabase
{
	private Account[] accounts;
	
	public BankDatabase()
	{
		accounts=new Account[2];
		
		accounts[0] =  new Account(12345, 54321, 1000.0, 1200.0);
		accounts[1] =  new Account(98765, 56789, 200.0, 200.0);
	}
	
	private Account getAccount(int accountNumber)
	{
		for (Account currentAcount : accounts)
		{
			if (currentAcount.getAccountNumber() == accountNumber)
				return currentAcount;
		}
		return null; // si no encuetra la cuenta, retorna null
	}
	
	boolean authenticateUser(int usserAccountNumber, int userPIN)
	{
		Account userAcount = getAccount(usserAccountNumber);
		
		if (userAcount!=null)
		{
			return userAcount.validatePIN(userPIN);
		}
		
		else
			return false;
	}
	
	double getavailableBalance(int userAccountNumber)
	{
		return getAccount(userAccountNumber).getTotalBalance();
	}
	
	double getTotalBalance(int userAccountNumber)
	{
		return getAccount(userAccountNumber).getTotalBalance();
	}
	
	void credit (int userAccountNumber, double amount)
	{
		getAccount(userAccountNumber).credit(amount);
	}
	
	void debit (int userAccountNumber, double amount)
	{
		getAccount(userAccountNumber).debit(amount);
	}
}
