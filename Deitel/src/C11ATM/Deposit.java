package C11ATM;

public class Deposit extends Transaction
{
	private double amount;
	private KeyPad kp;
	private DepositSlot dps;
	private final static int CANCELED=0;
	
	public Deposit(int userAccountNumber, Screen atmScreen,
			BankDatabase atmBankDatabase, KeyPad kp,DepositSlot ds)
	{
		super(userAccountNumber, atmScreen, atmBankDatabase);
		 
		this.kp=kp;
		dps=ds;
	}

	@Override
	public void execute()
	{
		BankDatabase dD = getBankDatabase();
		Screen sc = getScreen();
		
		amount=promptForDepositAmount();
		
		if (amount != CANCELED)
		{
			sc.displayMessage("\nPlease insert a deposit enevelope containing");
			sc.displayDollarAmount(amount);
			sc.displayMessageLine(".");
			
			boolean enveloped = dps.isEnvelopeReceived();
			
			if (enveloped)
			{
				sc.displayMessageLine("\nYour envelope has been " +
						"received.\nNOTE: The money just deposited will not " +
						"be available until we verify the amount of any " +
						"enclosed cash and your checks clear.");
				
				dD.credit(getAccountNumber(), amount);
			}
			else
			{
				sc.displayMessageLine("\nYou did not insert an " +
						"envelope, so the ATM has canceled your transaction.");
			}
		}
		
		else
		{
			sc.displayMessageLine( "\nCanceling transaction..." );
		}
	}
	
	private double promptForDepositAmount()
	{
		Screen sc = getScreen();
		
		sc.displayMessage( "\nPlease enter a deposit amount in " +
				"CENTS (or 0 to cancel): " );
		
		int input = kp.getInput();
		
		if (input==CANCELED)
			return CANCELED;
		
		else
			return (double) input/100;
		
		
	}
}
