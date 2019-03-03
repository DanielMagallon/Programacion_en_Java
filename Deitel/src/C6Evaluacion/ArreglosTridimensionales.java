package C6Evaluacion;

import java.util.Random;

public class ArreglosTridimensionales
{
	public static void main(String[] args)
	{
		Random lb = new Random();
		
		int arregloTridimensional [][][] = new int [3][3][4];
		
		for (int i=0; i<arregloTridimensional.length; i++)
		{
			for (int j=0; j<arregloTridimensional[i].length; j++)
			{
				for (int k=0; k<arregloTridimensional[i][j].length; k++)
				{
					arregloTridimensional[i][j][k]=lb.nextInt(20) + 1;
				}
			}
		}
		
		for (int i=0; i<arregloTridimensional.length; i++)
		{
			for (int j=0; j<arregloTridimensional[i].length; j++)
			{
				for (int k=0; k<arregloTridimensional[i][j].length; k++)
				{
					System.out.printf ("%5d ",arregloTridimensional[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		for (int i=0; i<arregloTridimensional.length; i++)
		{
			for (int j=0; j<arregloTridimensional[i].length; j++)
			{
				for (int k=0; k<arregloTridimensional[i][j].length; k++)
				{
					System.out.printf ("arreglo [%d][%d][%d] = %2d   ",i,j,k,arregloTridimensional[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
