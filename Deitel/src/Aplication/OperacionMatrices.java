package Aplication;

import java.util.Random;

public class OperacionMatrices
{
	int matrizA[][];
	int matrizB[][];
	private int matrizC[][];
	private Random lb = new Random();
	
	public OperacionMatrices(int[][] matrizA, int matrizB[][])
	{
		this.matrizA=matrizA;
		this.matrizB=matrizB;
		determinarOperacion();
	}
	
	private void determinarOperacion()
	{
		incializateMatrizOf(matrizA);
		incializateMatrizOf(matrizB);
		
		if(getRowsOfMatriz(matrizA) == getRowsOfMatriz(matrizB)
		&& getColumnsOfMatriz(matrizA) == getColumnsOfMatriz(matrizB))
		{
			matrizC = new int [matrizA.length][matrizA[0].length];
			//sumaMatriz();
			restarMatriz();
		}
		
		else if (getColumnsOfMatriz(matrizA) == getRowsOfMatriz(matrizB))
		{
			matrizC = new int [matrizA.length][matrizB[0].length];
			multiplicarMatriz();
		}
			
	}

	private void incializateMatrizOf(int matriz[][])
	{
		for (int i=0; i<matriz.length; i++)
		  for (int j=0; j<matriz[i].length; j++)
			  matriz[i][j]=lb.nextInt(10);
	}
	
	private void sumaMatriz()
	{
		System.out.println("Matriz A: ");
		showMatrizOf(matrizA);
		
		System.out.println("\nMatriz B: ");
		showMatrizOf(matrizB);
		
		for (int i=0; i<matrizA.length; i++)
			for (int j=0; j<matrizA[i].length; j++)
				matrizC[i][j] = matrizA[i][j] + matrizB[i][j];
		
		
		System.out.println("\nMatriz C: ");
		showMatrizOf(matrizC);
	}
	
	private void restarMatriz()
	{
		System.out.println("Matriz A: ");
		showMatrizOf(matrizA);
		
		System.out.println("\nMatriz B: ");
		showMatrizOf(matrizB);
		
		for (int i=0; i<matrizA.length; i++)
			for (int j=0; j<matrizA[i].length; j++)
				matrizC[i][j] = matrizA[i][j] - matrizB[i][j];
		
		
		System.out.println("\nMatriz C: ");
		showMatrizOf(matrizC);
	}
	
	private void multiplicarMatriz()
	{
		System.out.println("\nMatriz A: ");
		showMatrizOf(matrizA);
		System.out.println("\nMatriz B: ");
		showMatrizOf(matrizB);
		
		for (int i=0; i<matrizC.length; i++)
		{
			for (int j=0; j<matrizC[i].length; j++)
			{
				matrizC[i][j] =  getValorColumnC(i,j);
			}
		}
		
		System.out.println("\nMatriz C: ");
		showMatrizOf(matrizC);
	}
	
	private int getValorColumnC(int fila,int column)
	{
		int valor=0;
		
		System.out.println("Entro\n");
		
		for (int i=0; i<matrizB.length; i++)
		{
			//System.out.printf ("Matriz[%d][%d] = "+matrizA[fila][i]+ "*"+matrizB[i][column]+"\n",fila,i);
			valor += matrizA[fila][i] * matrizB[i][column];
		}

		System.out.println("\nSalgo\n");
		
		return valor;
	}
	
	private void showMatrizOf(int[][] matriz)
	{
		for(int [] mI : matriz)
		{
			for (int mJ : mI)
				System.out.printf ("%5d ",mJ);

			System.out.println();
		}
	}
	
	public void newMatriz(int[][] matrizA, int matrizB[][])
	{
		
	}
	
	private int getRowsOfMatriz(int[][] matriz)
	{
		return matriz.length;
	}
	
	private int getColumnsOfMatriz(int[][] matriz)
	{
		return matriz[0].length;
	}
	
	public static void main(String[] args)
	{
		int mA[][] = new int [5][3];
		int mB[][] = new int [3][4];
		
		new OperacionMatrices(mA, mB);
	}
}
