package HelpClass;

public class GenericoApp
{
	
	public static void main(String[] args)
	{
		Generico<Integer> rs = new Generico<>();
		
		rs.add(5);
		rs.add(3);
		rs.add(8);
		rs.add(11);
		
		rs.getAll();
	}
}
