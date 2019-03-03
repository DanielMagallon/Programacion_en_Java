package C7Evalucion;

import java.util.Scanner;

public class PruebaRectangulo
{
	public static void main(String[] args)
	{
		ClaseRectangulo rectangulo = new ClaseRectangulo();
		boolean excepcion=false;
		
		try
		{
			ClaseRectangulo.establecerLongitud(54.5);
		}
		
		catch (IllegalArgumentException e)
		{
			System.out.printf ("Excepcion: IllegalArgumentException\n%s",e.getMessage());
		}
		
		try
		{
			ClaseRectangulo.establecerAnchura(40);
		}
		catch (IllegalArgumentException e)
		{
			System.out.printf ("Excepcion: IllegalArgumentException\n%s",e.getMessage());
		}
		
		System.out.printf ("La longitud del rectangulo es: %.2f\n",ClaseRectangulo.obtenerLongitud());
		System.out.printf ("La base del rectangulo es: %.2f\n\n",ClaseRectangulo.obtenerAnchura());
		
		
		System.out.println(rectangulo);
		
		
		Scanner lc = new Scanner(System.in);
		
		System.out.println();
		
		do
		{
			try
			{
				System.out.print ("Introduzca la altura del rectangulo: ");
				double altura=lc.nextDouble();
		
				excepcion=ClaseRectangulo.establecerLongitud(altura);
			}
			
			catch (IllegalArgumentException e)
			{
				System.out.printf ("\nExcepcion: IllegalArgumentException\n%s",e.getMessage());
				lc.nextLine();
			}
		}
		while (excepcion==false);
		
		excepcion=false;
		
	   do
		{
			try
			{
				System.out.print ("Introduzca la base del rectangulo: ");
				double base=lc.nextDouble();
		
				excepcion=ClaseRectangulo.establecerAnchura(base);
			}
			
		catch (IllegalArgumentException e)
			{
			
				System.out.printf ("\nExcepcion: IllegalArgumentException\n%s",e.getMessage());
				lc.nextLine();
			}
		
		}
		while (excepcion==false);
	   
	   System.out.println("\n"+rectangulo);
	}
}
