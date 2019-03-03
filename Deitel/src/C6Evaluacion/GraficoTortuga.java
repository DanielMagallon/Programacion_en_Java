package C6Evaluacion;

import java.util.Random;

public class GraficoTortuga
{
	public static void trazarFigura ()
	{
		Random lb = new Random();
		
		int piso [][] = new int [10][10];
		
		for (int i=0; i<piso.length; i++)
		{
			for (int j=0; j<piso.length; j++)
			{
				piso[i][j]=lb.nextInt(2);
			}
		}
		
		for (int i=0; i<piso.length; i++)
		{
			for (int j=0; j<piso.length; j++)
			{
				System.out.printf ("%d ",piso[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
		for (int i=0; i<piso.length; i++)
		{
			for (int j=0; j<piso.length; j++)
			{
				if (piso[i][j]==0)
				{
					System.out.printf ("  ");
				}
				
				else
					if (piso[i][j]==1)
					{
						System.out.printf ("* ");
					}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		trazarFigura();
	}
}
