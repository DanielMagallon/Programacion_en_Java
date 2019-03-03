package myjava;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerRead implements ScannerKeyBoard,ScannerFiles 
{
	public static Scanner read = new Scanner(System.in);
	public static Scanner inputFile;
	
	public String getInputString()
	{
		return read.next();
	}
	
	public Object getInputObject()
	{
		return read.next();
	}
	
	public String getInputStringLine()
	{
		return read.nextLine();
	}
	
	public  int getInputInt()
	{
		return read.nextInt();
	}
	
	public double getInputDouble()
	{
		return read.nextDouble();
	}

	public String getInputStringFile()
	{
		return inputFile.next();
	}

	public int getInputIntFile()
	{
		return inputFile.nextInt();
	}
	
	public double getInputDoubleFile()
	{
		return inputFile.nextDouble();
	}
	
	public void createInputFile(String file) throws FileNotFoundException 
	{
		inputFile = new Scanner(new File(file));
	}
	
	
}
 
