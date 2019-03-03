package C6ArreglosArrayList;

import java.util.Random;
import java.util.Scanner;

public class ArreglosBidimensionales
{
	public static Random lb = new Random();
	
	public static boolean a=false;
	
	public static void main(String[] args)
	{
		
		Scanner lc = new Scanner(System.in);
		
		int num,fila,columna;
		
		System.out.print("Introduzca el numero de filas de la matriz: ");
		fila=lc.nextInt();
		
		System.out.print("\nIntroduzca el numero de columnas de la matriz: ");
		columna=lc.nextInt();
		
		do
		{
		System.out.print ("\nDame un numero entre 1-50: ");
	    num=lc.nextInt();
		
	    System.out.println();
	    
		if (num<=0 || num >=51)
			System.out.print ("El numero escrito no esta en el rango pedido.\n");
		
		else
			generarArreglos(num,fila,columna);
			
		}
		while (num<=0 || num >=51);
		
	}
	
	public static void generarArreglos (int n, int f, int col)
	{
		 int[][] b = new int [f] [col]; 
		
		 
		/*b [0] [0] = lb.nextInt(40) + 1;
		b [0] [1] = lb.nextInt(30) + 1;
		b [0] [2] = lb.nextInt(10) + 1;
		b [1] [0] = lb.nextInt(20) + 1;
		b [1] [1] = lb.nextInt(10) + 1;
		b [1] [2] = lb.nextInt(50) + 1;
		*/

		
		for ( int i=0; i<b.length; i++)
		{
			for ( int j=0; j<b[i].length; j++)
			{
				b [i] [j] = lb.nextInt(50) + 1;
				System.out.printf ("%4d ",b[i][j]);
				
				
			}
			System.out.println();
		}
		
		for ( int i=0; i<b.length; i++)
		{
			for ( int j=0; j<b[i].length; j++)
			{
				//System.out.printf ("Arreglo [%d] [%d] = %d\n",i,j,b[i][j]);
				
				if (a==false)
				{
					if (n==b[i][j])
					{
						a=true;
						System.out.printf ("\nEl numero %d se encuentra en el arreglo\n",n);
						System.out.printf ("\n\tPosicion: [%d][%d] ",i,j);
					}
				}
				
				else
				{
					if (n==b[i][j])
					{
						System.out.printf ("\n\tPosicion: [%d][%d] ",i,j);
					}
				}
				
			}
		}
		
		System.out.println(b[0][3]);
	}
	
}
