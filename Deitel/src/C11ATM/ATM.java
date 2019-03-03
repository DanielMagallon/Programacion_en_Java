package C11ATM;

public class ATM
{
	private boolean userAuthenticated;
	private int currentAcountNumber;
	private Screen screen;
	private KeyPad keypad;
	private CashDispenser cashDispenser;
	private DepositSlot depositSlot;
	private BankDatabase bankDatabase;
	
	private static final int BALANCE_INQUIRY = 1;
	private static final int WITHDRAWAL = 2;
	private static final int DEPOSIT = 3;
	private static final int EXIT = 4;
	
	public ATM()
	{
		userAuthenticated=false;
		currentAcountNumber=0;
		screen = new Screen();
		keypad = new KeyPad();
		cashDispenser = new CashDispenser();
		depositSlot = new DepositSlot();
		bankDatabase = new BankDatabase();
	}
	
	void run()
	{
		while (true)
		{
			while (!userAuthenticated)
			{
				screen.displayMessageLine("\nWelcome!");
				authenticateUser();
			}
			
			performTransactions();
			userAuthenticated=false;
			currentAcountNumber=0;
			screen.displayMessageLine("\nThank you. Good Bye!");
		}
	}
	
	private void authenticateUser()
	{
		screen.displayMessage("\nPlease enter your account number: ");
		int accountNumber = keypad.getInput();
		screen.displayMessage("\nEnter your PIN: ");
		int pin = keypad.getInput();
		
		userAuthenticated = bankDatabase.authenticateUser(accountNumber,pin);
		
		if (userAuthenticated)
		{
			currentAcountNumber = accountNumber;
		}
		
		else
		{
			screen.displayMessageLine("Invalid account number or PIN. Please try again");
		}
	}
	
	private void performTransactions()
	{
		Transaction current=null;
		
		boolean user=false;
		
		while (!user)
		{
			int mainMenuS=displayMenu();
			
			switch (mainMenuS)
			{
				case BALANCE_INQUIRY:
				case WITHDRAWAL:
				case DEPOSIT:
					current=createTransaction(mainMenuS);
					current.execute();
					break;
					
				case EXIT:
					screen.displayMessageLine( "\nExiting the system..." );
					 user= true; //
					 break;
					
				default: 
					 screen.displayMessageLine(
					"\nYou did not enter a valid selection. Try again." );
					break;
			}
		}
	}
	
	private int displayMenu()
	{
		screen.displayMessageLine( "\nMain menu:" );
		screen.displayMessageLine( "1 - View my balance" );
		screen.displayMessageLine( "2 - Withdraw cash" );
		screen.displayMessageLine( "3 - Deposit funds" );
		screen.displayMessageLine( "4 - Exit\n" );
		screen.displayMessage( "Enter a choice: " );
		return keypad.getInput();
	}
	
	private Transaction createTransaction( int type )
	 {
		Transaction temp = null;
		
		switch ( type )
		{
		case BALANCE_INQUIRY: 
			temp = new BalanceInquiry(
			currentAcountNumber, screen, bankDatabase );
			break;
		
		case WITHDRAWAL: 
			temp = new Withdrawal( currentAcountNumber, screen,
				bankDatabase, keypad, cashDispenser );
			break;
		
		case DEPOSIT: 
			temp = new Deposit( currentAcountNumber, screen,
			bankDatabase, keypad, depositSlot );
			break;
		} 
		
		return temp; 
	 }
}
