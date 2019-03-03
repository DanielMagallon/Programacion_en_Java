package C4InstruccionControl2;

public class Expresionesaritmeticas_for 
{
	public static void main(String[] args) 
	{
		int x=2,y=10;
		
		for (int j = x; j <= 4 * x * y; j += y / x)
			System.out.printf (" %d ",j);
		
		System.out.println();
		
		// es igual a:
		for (int j = 2; j <= 80; j += 5)
			System.out.printf (" %d ",j);
	}
}
