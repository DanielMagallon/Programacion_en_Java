package C15Files;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;

import myjava.ScannerRead;

public class CreateSequentialFile extends ScannerRead
{
	private ObjectOutputStream output;

	public void openFile()
	{
		try
		{
			output = new ObjectOutputStream(new FileOutputStream("clients2"));
		} 
		catch (IOException io)
		{
			System.err.println("Error opening file.");
		}
	}

	public void addRecords()
	{
		AccountRecordSerializable record;
		int accountNumber = 0;
		String firstName;
		String lastName;
		double balance;
		
		
		System.out.printf( "%s\n%s\n%s\n%s\n\n",
				 "To terminate input, type the end-of-file indicator ",
				"when you are prompted to enter input.",
				 "On UNIX/Linux/Mac OS X type <ctrl> d then press Enter",
				 "On Windows type <ctrl> z then press Enter" );
				
		System.out.printf( "%s\n%s",
				 "Enter account number (> 0), first name, last name and balance.",
				 "? and add: " );
		
		while(read.hasNext())
		{
			try
			{
				accountNumber=getInputInt();
				firstName=getInputString();
				lastName=getInputString();
				balance=getInputDouble();
				
				record = new AccountRecordSerializable(
						accountNumber, firstName, lastName, balance);
				
				if(accountNumber > 0 )
				{
					/*record = new AccountRecordSerializable(
							accountNumber, firstName, lastName, balance);
					System.out.println(record.arr);*/
					record.arr.add(firstName);
					System.out.println(record.arr.size());
					System.out.println(record.arr);
					
					
					output.writeObject(record);
				}
				else
				{
					System.out.println("Account number must be greater than 0." );
				}
			}
			catch (IOException e)
			{
				System.err.println( "Error writing to file." );
				return;
			}
			catch (NoSuchElementException e)
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
		try
		{
			if (output != null)
			{
				output.close();
			}
		}
		catch (IOException e)
		{
			System.err.println( "Error closing file." );
			System.exit(1);
		}
	}
}
