package C15Files;

public class ReadTextFileApp
{
	public static void main(String[] args)
	{
		ReadTextFile file = new ReadTextFile();
		
		file.openFile();
		file.readRecords();
		file.closeFile();
	}
}
