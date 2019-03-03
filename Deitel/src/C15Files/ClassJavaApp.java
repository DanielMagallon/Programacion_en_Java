package C15Files;

public class ClassJavaApp
{
	public static void main(String[] args)
	{
		CreateClassJava c = new CreateClassJava();
		
		c.openFile();
		c.addRecords();
		c.closeFile();
	}
}
