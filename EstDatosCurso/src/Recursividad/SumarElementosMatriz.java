package Recursividad;

import java.util.Random;

public class SumarElementosMatriz
{
	public static void main(String[] args)
	{
		Random lb = new Random();
		
		
		int matriz[][] = new int [3][5];
		
		System.out.println(matriz[0].length);
		
		int f=matriz.length;
		int c=matriz[0].length;
		
		for (int i=0; i<matriz.length; i++)
		{
			for (int j=0; j<matriz[i].length; j++)
			{
				matriz[i][j]=lb.nextInt(10)+1;
			}
		}
		
		for (int i[] : matriz)
		{
			for (int j : i)
			{
				System.out.printf ("%3d ",j);
			}
			System.out.println();
		}
		
		SumarElementosMatriz x = new SumarElementosMatriz();
		
	//System.out.printf("La suma de los elementos de la matriz = %d",x.sumaMatriz(matriz, f, c));
	}
	
	/* int suma (int fila, int col, int orden, int mat [] [])
	    {
		if (fila == 0 && col == 0)
		    return mat [0] [0];
		else
		    if (col < 0)
			return suma (fila - 1, orden, orden, mat);
		    else
			return mat [fila] [col] + suma (fila, col - 1, orden, mat);
	    }*/
	
}
