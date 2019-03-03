package C15Files;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import myjava.ScannerRead;

public class CreditInquiry extends ScannerRead
{
	private MenuOption accountType;
	private final static MenuOption[] choices =
		{MenuOption.ZERO_BALANCE, MenuOption.CREDIT_BALANCE,
		 MenuOption.DEBIT_BALANCE, MenuOption.END};
	
	private void readRecords()
	{
		AccountRecord record = new AccountRecord();
		
		try
		{
			createInputFile("clients.txt");
			
			while(inputFile.hasNext())
			{
				record.setAccount(getInputIntFile());
				record.setFirstName(getInputStringFile());
				record.setLastName(getInputStringFile());
				record.setBalance(getInputDoubleFile());
				
				if ( shouldDisplay (record.getBalance()))
					System.out.printf( "%-10d%-12s%-12s%10.2f\n",
					record.getAccount(), record.getFirstName(),
					record.getLastName(), record.getBalance() );				
			}
		}
		catch (FileNotFoundException e){}
		
		catch (NoSuchElementException nS)
		{
			System.err.println( "File improperly formed." );
			inputFile.close();
			System.exit(1);
		}
		catch (IllegalStateException ilS)
		{
			System.err.println( "Error reading from file." );
			System.exit(1);
		}
		
		finally
		{
			if(inputFile!=null)
				inputFile.close();
		}
	}

	private boolean shouldDisplay(double balance)
	{
		if (accountType == MenuOption.CREDIT_BALANCE && balance<0)
			return true;
		
		else if (accountType == MenuOption.DEBIT_BALANCE && balance > 0)
			return true;
		
		else if (accountType == MenuOption.ZERO_BALANCE && balance == 0)
			return true;
		
		return false;
	}

	private MenuOption getRequest()
	{
		int request=1;
		
		System.out.printf( "\n%s\n%s\n%s\n%s\n%s\n",
				"Enter request", " 1 - List accounts with zero balances",
				" 2 - List accounts with credit balances",
				" 3 - List accounts with debit balances", " 4 - End of run" );
		
		try
		{
			do
			{
				System.out.print ("\n?");
				request=getInputInt();
			}
			while(request < 1 || request>4);
		}
		catch(NoSuchElementException ex )
		{
			System.err.println( "Invalid input." );
			System.exit(1);
		}
		
		return choices[request-1];
	}
	
	public void processRequests()
	{
		accountType=getRequest();
		
		while(accountType != MenuOption.END)
		{
			switch (accountType)
			{
				case ZERO_BALANCE:
					System.out.println( "\nAccounts with zero balances:\n" );
					break;
				
				case CREDIT_BALANCE:
					System.out.println( "\nAccounts with credit balances:\n" );
					break;
					
				case DEBIT_BALANCE:
					System.out.println( "\nAccounts with debit balances:\n" );
					break;
			}
			
			readRecords();
			accountType=getRequest();
		}
	}
}
