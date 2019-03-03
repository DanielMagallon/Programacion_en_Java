package C11ATM;

// Traducciones:
/*
 *  .- Withdrawal: Retiros de una cueta.
 *  .- Amount: Monto,Cantidad
 *  
 */

public class Withdrawal extends Transaction
{
	public Withdrawal(int userAccountNumber, Screen atmScreen,
			BankDatabase atmBankDatabase,KeyPad k,CashDispenser cd)
	{
		super(userAccountNumber, atmScreen, atmBankDatabase);
		
		kd=k;
		this.cd=cd;
		
	}
	
	@Override
	public void execute()
	{
		boolean cD=false;
		double availableBalance;
		
		BankDatabase bd = getBankDatabase();
		Screen sc = getScreen();
		
		do
		{
			amount=displayMenuOfAmounts();
			
			if(amount != CANCELED)
			{
				availableBalance=bd.getavailableBalance(getAccountNumber());
				
				if (amount>=availableBalance)
				{
					if (cd.isSufficientCashAvailable(amount))
					{
						bd.debit( getAccountNumber(),amount);
						cd.dispenseCash(amount);
						cD=true;
						sc.displayMessageLine("\nYour cash has been " + 
						"dispensed.Please take your cash now");
					}
					else
					{
				sc.displayMessageLine("\nInsufficient cash available in the ATM. "+
						"\n\nPlease chose a smaller amount");
					}
				}
				
				else
				{
				sc.displayMessageLine("\nInsufficient funds in your account. "+
							"\n\nPlease chose a smaller amount");
				}
			}
			else
			{
				sc.displayMessageLine("\nCanceling transaction...");
				return;
			}
		} 
		while (!cD);
	} 
	
	private int displayMenuOfAmounts()
	{
		int userChocie=0;
		
		Screen sc=getScreen();
		
		int [] amounts = {0,20,40,60,100,200};
		
		while(userChocie==0)
		{
			sc.displayMessageLine("\nWithdrawl Menu: ");
			sc.displayMessageLine("1 - $20");
			sc.displayMessageLine("2 - $40");
			sc.displayMessageLine("3 - $60");
			sc.displayMessageLine("4 - $100");
			sc.displayMessageLine("5 - $200");
			sc.displayMessageLine("6 - Cancel Transaction");
			
			int input=kd.getInput();
			
			switch (input)
			{
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
					userChocie=amounts[input];
				break;
				
				case CANCELED:
					userChocie=CANCELED;
					break;
					
				default:
					sc.displayMessageLine("\nInvalid Selection. Try Again.");
			}
		}
		
		return userChocie;
	}
	
	// atributes
	private int amount;
	private KeyPad kd;
	private CashDispenser cd;
	private static final int CANCELED=6;
}
