package C6Evaluacion;

import java.util.Scanner;

public class VentaTotales
{
	
    static int [] [] ventas = new int [4][5];
	static int sumaCadaProdcutos=0;
	static int sumaTodosProductoXVendedor=0;
	
	public static void main(String[] args)
	{
		
		Scanner lc = new Scanner(System.in);

		
		for (int i=0; i<ventas.length; i++)
		{
			for (int j=0; j<ventas[i].length;j++)
			{
				System.out.printf ("\nVendedor %d\n",i+1);
				System.out.printf ("Introduzca la cantidad vendida del producto %d: ",j+1);
				ventas[i][j]=lc.nextInt();
			}
		}
		
		System.out.println("\n");
		
		for (int columna=0; columna<4; columna++) 
				System.out.printf ("%23s %d","Vendedor",columna+1);
		
		System.out.println("\n");
		
		for (int i=0; i<5; i++)
		{
			System.out.printf ("ProduCto %d",i+1);
			
			for (int j=0; j<4;j++)
			{
				System.out.printf ("%14d          ",ventas[j][i]);
				
			}
			
			System.out.println();
		}
		
		//imprmirResultados();
	}
		
		
	public static void imprmirResultados ()
	{
		
		System.out.printf ("\nTotal Vendedor: ");
		
		for (int i=0; i<ventas.length; i++)
		{
			for (int j=0; j<ventas[0].length;j++)
			{
				sumaTodosProductoXVendedor += ventas [i][j];
			}
			
			System.out.printf ("    %5s%d ","$",sumaTodosProductoXVendedor);
			sumaTodosProductoXVendedor=0;
		}

		
		
		for (int i=0; i<5; i++)
		{
			for (int j=0; j<4;j++)
			{
				sumaCadaProdcutos += ventas [j][i];
			}
			System.out.printf ("%d\n",sumaCadaProdcutos);
			sumaCadaProdcutos=0;
		}
	}
}
