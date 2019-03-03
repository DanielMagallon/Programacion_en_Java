package C15Files;

public class CreateSequentialFileApp
{
	public static void main(String[] args)
	{
		CreateSequentialFile file = new CreateSequentialFile();
		
		file.openFile();
		file.addRecords();
		file.closeFile();
	}
}
