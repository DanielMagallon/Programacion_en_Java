package C15Files;

public class CreateTextFileApp 
{
	public static void main(String[] args)
	{
		CreateTextFile file = new CreateTextFile();
		
		file.openFile();
		file.addRecords();
		file.closeFile();
	}
}
