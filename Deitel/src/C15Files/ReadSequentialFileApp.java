package C15Files;

public class ReadSequentialFileApp
{
	public static void main(String[] args)
	{
		ReadSequentialFile file = new ReadSequentialFile();
		
		file.openFile();
		file.readRecords();
		file.closeFile();
	}
}//751
