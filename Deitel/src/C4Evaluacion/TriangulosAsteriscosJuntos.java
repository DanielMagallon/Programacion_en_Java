package C4Evaluacion;

public class TriangulosAsteriscosJuntos
{
	public static void main(String[] args)
	{
		
		for (int v=1; v<=10; v++ )
		{
			for (int r=v; r>0; r--)
				System.out.print ("*");
			
			System.out.println();
		}
	}
}
