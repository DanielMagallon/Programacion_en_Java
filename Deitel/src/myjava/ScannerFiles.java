package myjava;

import java.io.FileNotFoundException;

public interface ScannerFiles
{
	public String getInputStringFile();

	public int getInputIntFile();
	
	public double getInputDoubleFile();
	
	public  void createInputFile(String file) throws FileNotFoundException;
}
