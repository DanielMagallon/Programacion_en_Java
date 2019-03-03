package C11ATM;

public class BalanceInquiry extends Transaction
{
		public BalanceInquiry(int userAccountNumber,Screen atmScreen,
							  BankDatabase atmBankDatabase)
		{
			super(userAccountNumber, atmScreen, atmBankDatabase);
		}
		
		@Override
		public void execute()
		{
			BankDatabase bD = getBankDatabase();
			Screen sc = getScreen();
			
			double availableBalance = bD.getavailableBalance(getAccountNumber());
			
			double totalBalance = bD.getTotalBalance(getAccountNumber());
			
			sc.displayMessageLine("\nBalance Information:");
			sc.displayMessage(" - Available balance: ");
			sc.displayDollarAmount(availableBalance);
			sc.displayMessage("\n - Total Balance: ");
			sc.displayDollarAmount(totalBalance);
			sc.displayMessageLine("");
		}
}
