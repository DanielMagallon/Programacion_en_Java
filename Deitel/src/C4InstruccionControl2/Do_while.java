package C4InstruccionControl2;

public class Do_while 
{
	
	public static void main(String[] args) 
	{
		int contador = 1;
		
		do
		{
			System.out.printf (" %d ",contador);
			++contador;
		} 
		
		while (contador<=10);
		
		System.out.println();
	}
}
