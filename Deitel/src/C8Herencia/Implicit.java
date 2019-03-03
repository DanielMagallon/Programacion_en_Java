package C8Herencia;

public class Implicit
{
	private static int l;
	
	static
	{
		System.out.println("Me llame implicitamenete ");
		l=34;
	}
	
	int f;
	
	{
		f=2;
	}
	
	public int emp()
	{
		System.out.println("\nHola");
		return l ^ 4;
	}
	
	public int fg()
	{
		return f;
	}
	
}
