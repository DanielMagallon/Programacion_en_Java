package C15Files;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import myjava.ScannerRead;

public class ReadTextFile extends ScannerRead
{ 
	
	public void openFile()
	{
		try
		{
			createInputFile("clients.txt");
		} 
		catch (FileNotFoundException f) 
		{
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}

	public void readRecords()
	{
		AccountRecord record = new AccountRecord();
		
		System.out.printf( "%-10s%-12s%-12s%10s\n", "Account",
				"First Name", "Last Name", "Balance" );
		
		try
		{
			while(inputFile.hasNext())
			{
				record.setAccount(getInputIntFile());
				record.setFirstName(getInputStringFile());
				record.setLastName(getInputStringFile());
				record.setBalance(getInputDoubleFile());
				
				// display record contents
				System.out.printf( "%-10d%-12s%-12s%10.2f\n",
				record.getAccount(), record.getFirstName(),
				record.getLastName(), record.getBalance());
			}
		}
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
	}
	
	public void closeFile()
	{
		if(inputFile!=null)
			inputFile.close();
	}
}
