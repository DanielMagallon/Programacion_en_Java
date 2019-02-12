package Ayuda;

import java.util.Random;

public class Matriz
{
	int matriz[][];
	
	public Matriz(int filas, int col)
	{
		matriz = new int[filas][col];
		
		llenar();
	}
	
	
	Random lb = new Random();
	int pares;
	
	private void llenar()
	{
		for(int i=0; i<matriz.length; i++)
		{
			for(int j=0; j<matriz[i].length; j++)
			{
				matriz[i][j] = lb.nextInt(101)+100;
				
				if(matriz[i][j]%2==0)
					pares++;
			}
		}
	}
	
	public void mostrarMatriz()
	{
		for(int i=0; i<matriz.length; i++)
		{
			for(int j=0; j<matriz[i].length; j++)
			{
				System.out.print(matriz[i][j]+" ");
			}
			
			System.out.println();
		}
		
	}
	
	
	public int[] vectorPares()
	{
		int vec[] = new int[pares];
		int ind=0;
		
		for(int i=0; i<matriz.length; i++)
		{
			for(int j=0; j<matriz[i].length; j++)
			{
				if(matriz[i][j]%2==0)
				{
					vec[ind] = matriz[i][j];
					ind++;
				}
			}
		}
		
		return vec;
	}
	
	public static void main(String[] args)
	{
		Matriz m = new Matriz(4, 3);
		
		m.mostrarMatriz();
		
		int vec[] = m.vectorPares();
		
		System.out.println("Elementos pares:");
		
		for(int i=0; i<vec.length; i++)
			System.out.println(vec[i]);
	}
}
