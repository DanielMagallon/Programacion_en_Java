package C15Files;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

import myjava.ScannerRead;

public class CreateTextFile extends ScannerRead
{
	private Formatter output;

	public void openFile()
	{
		try
		{
			output = new Formatter("eje.txt");
		} 
		catch (SecurityException sty)
		{
			System.err.println("You do not have write access to this file.");
		} 
		catch (FileNotFoundException file)
		{
			System.err.println("Error opening or creating file.");
			System.exit(1);
		}
	}

	public void addRecords()
	{
		AccountRecord record = new AccountRecord();

		System.out.printf("%s\n%s\n%s\n%s\n\n", "To terminate input, type the end-of-file indicator ",
				"when you are prompted to enter input.", 
				"On UNIX/Linux/Mac OS X type <ctrl> d then press Enter",
				"On Windows type <ctrl> z then press Enter");

		System.out.printf("%s\n%s",
				"Enter account number (> 0), first name, last name and balance.",
				"?");
		
		while(read.hasNext())
		{
			try
			{
				record.setAccount(getInputInt());
				record.setFirstName(getInputString());
				record.setLastName(getInputString());
				record.setBalance(getInputDouble());
				
				if(record.getAccount() > 0)
				{
					output.format("%d %s %s %.2f%n", record.getAccount(),
							record.getFirstName(),record.getLastName(),
							record.getBalance());
				}
				else
				{
					System.out.println("Account number must be greater than 0." );
				}
			}
			catch (FormatterClosedException fCl)
			{
				System.err.println( "Error writing to file." );
				return;
			}
			catch(NoSuchElementException nS)
			{
				System.err.println( "Invalid input. Please try again." );
				read.nextLine();
			}
			
			System.out.printf( "%s %s\n%s", "Enter account number (>0),",
					"first name, last name and balance.", "? " );
		}
	}
	
	public void closeFile()
	{
		if(output!=null)
			output.close();
	}
}
