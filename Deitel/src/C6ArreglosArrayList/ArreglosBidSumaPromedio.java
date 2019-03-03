package C6ArreglosArrayList;

import java.util.Random;
import java.util.Scanner;

public class ArreglosBidSumaPromedio
{
	public static void main(String[] args)
	{
		Random lb = new Random();
		
		Scanner lc = new Scanner(System.in);
		
		int fila,columna;
		
		System.out.print ("Introduzca el numero de filas de la matriz: ");
		fila=lc.nextInt();
		
		System.out.print ("Introduzca el numero de columnas de la matriz: ");
		columna=lc.nextInt();
		
		System.out.println();
		
		
		int matriz [][] = new int [fila][columna];
		
		for (int i=0; i<matriz.length; i++)
		{
			for (int j=0; j<matriz[i].length; j++)
				matriz [i][j] = lb.nextInt(10)+1;
		}
		
		for (int i=0; i<matriz.length; i++)
		{
			for (int j=0; j<matriz[i].length; j++)
				System.out.printf ("%4d ",matriz[i][j]);
			
		System.out.println();
		}
		
		/*for (int i=0; i<matriz.length; i++)
		{
			int suma=ObtenerSumaFilas (matriz[i]); 
			System.out.println();
			System.out.printf ("La suma de la fila %d es: %d\n",i+1,suma);
		}*/
		
		int sumaF=0,sumC=0;
		
		for (int i=0; i<matriz.length; i++)
		{
			for (int j=0; j<matriz[i].length; j++)
			{
				sumaF += matriz[i][j]; 
			}
			System.out.println();
			System.out.printf ("La suma de la fila %d es: %d\n",i+1,sumaF);
			sumaF=0;
		}
		
		for (int i=0; i<matriz[0].length; i++) // matriz(0).lenght lo utilize para obtener nro colu.
		{
			for (int j=0; j<matriz.length; j++)
			{
				sumC += matriz[j][i]; 
			}
			System.out.println();
			System.out.printf ("La suma de la columna %d es: %d\n",i+1,sumC);
			sumC=0;
		}
		
	}
	
}
