package C4Evaluacion;

public class TriangulosAsteriscos
{
	public static void main(String[] args)
	{
		
		System.out.println("A)\n");
		
		for (int r=1; r<=10; r++)
		{
			for (int ast=r; ast>0; ast--)
				System.out.print ("*");
				
				System.out.println();
		}
		
		System.out.println();		
		
		System.out.println("B)\n");
		
		for (int r=10; r>0; r--)
		{
			for (int ast=r; ast>0; ast--)
				
				System.out.print ("*");
				
				System.out.println();
		}
		
		System.out.println();		
		
		System.out.println("C)\n");
		
		for (int v=10; v>=1; v--)
		{
			for (int espacio=v; espacio<10; espacio++)
			{
				System.out.print (" ");
			}
			
			for (int r=1; r<=v; r++)
				System.out.print ("*");
			
			System.out.println();
		}
		
		
		System.out.println();		
		
		System.out.println("D)\n");
		
		for (int v=1; v<=10; v++)
		{
			for (int espacio=v; espacio<10; espacio++)
			
				System.out.print (" ");
			
			
			for (int r=1; r<=v; r++)
				System.out.print ("*");
			
			System.out.println();
		}
	}
}
