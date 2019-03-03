package C15Files;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

import myjava.ScannerRead;

public class CreateClassJava extends ScannerRead
{
	private Formatter output;
	
	public void openFile()
	{
		try
		{
			output = new Formatter("ejemplo.java");
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
		String leer;
		
		try{
		while(read.hasNext())
		{
			leer=getInputStringLine();
			
			output.format("%s ", leer);
			
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
	}

	public void closeFile()
	{
		if(output!=null)
			output.close();
	}
}
