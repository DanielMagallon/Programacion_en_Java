package C6ArreglosArrayList;

import java.util.Random;

public class ArregloBidimensionalDiagonal
{
	public static void main(String[] args)
	{
		int [] [] arreglo = new int [5] [5];
		
		Random lb = new Random();
		
		for (int i=0; i<arreglo.length; i++)
		{
			for (int j=0; j<arreglo[i].length; j++)
			{
				arreglo [i][j] = lb.nextInt(99) + 1;
			}
		}
		
		for (int i=0; i<arreglo.length; i++)
		{
			for (int j=0; j<arreglo[i].length; j++)
			{
				System.out.printf ("%4d ",arreglo[i][j]);
			}
			
			System.out.println();
		}
		
		System.out.println("\n Los numeros en diagonal de la posicion [0][0] a la [4][4] son:\n");
		
		for (int i=0; i<arreglo.length; i++)
		{
			for (int j=0; j<arreglo[i].length; j++)
			{
				if(i==j)
					System.out.print(" " + arreglo[i][j] + "   ");
			}
		}
	}
}
