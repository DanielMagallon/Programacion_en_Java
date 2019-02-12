package Unidad1;

import java.util.Random;

public class DireccionMemoriaBid {

	static int matriz[][] = new int[3][4];
	
	static Random lb = new Random();
	
	static int dirMemoria;
	static int dirInicial = 2825;
	
	//demonios en java
	
	static void llenar()
	{
		for(int i=0; i<matriz.length; i++)
		{
			for(int j=0; j<matriz[i].length; j++)
			{
				matriz[i][j] = lb.nextInt(101);
				System.out.printf("%2s \t",matriz[i][j]);
			}
			
			System.out.println();
		}
	}
	
	static void calculoXRenglon()
	{
		System.out.println("Direccion Memoria x renglon (Ultimo rebglon): ");
		
		for(int j=0; j<matriz[0].length; j++)
		{
			//dirInicial + (numero de columnas array*posIndRenglon+posIndCol)*tamañoBytes-
			dirMemoria = dirInicial + (matriz[0].length*(matriz.length-1) + j) * 4;
			System.out.printf ("%d \t",dirMemoria);
		}
	}
	
	static void calculoXColumna()
	{
		System.out.println("\n\nDireccion Memoria x columna (Ultimo rebglon): ");
		for(int j=0; j<matriz[0].length; j++)
		{
			//dirInicial + (numero de rengons array*posIndCol+posIndRen)*tamañoBytes-
			dirMemoria = dirInicial + (matriz.length*j + matriz.length-1) * 4;
			System.out.printf ("%d \t",dirMemoria);
		}
	}
	
	public static void main(String[] args) 
	{
//		llenar();
//		calculoXRenglon();
//		calculoXColumna();
		
//		double x = 3456.123;
//	
//		Bina
	}
}
