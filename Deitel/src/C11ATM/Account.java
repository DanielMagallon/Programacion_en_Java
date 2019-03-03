package C11ATM;

public class Account
{
	private int acountNumber;
	private int pin;
	private double availableBalance;
	private double totalBalance;
	
	public Account(int theAccountNumber, int thePIN, double theAvailableBalance,
					double theTotalBalance)
	{
		
		acountNumber=theAccountNumber;
		pin=thePIN;
		availableBalance=theAvailableBalance;
		totalBalance=theTotalBalance;
	}
	
	boolean validatePIN(int userPIN)
	{
		if (userPIN==pin)
			return true;
		
		else
			return false;
	}
	
	double getAvailableBalance()
	{
		return availableBalance;
	}
	
	double getTotalBalance()
	{
		return totalBalance;
	}
	
	void credit(double amount)
	{
		totalBalance+=amount;
	}
	
	void debit(double amount)
	{
		availableBalance-=amount;
		totalBalance -= amount;
	}
	
	int getAccountNumber()
	{
		return acountNumber;
	}
}
