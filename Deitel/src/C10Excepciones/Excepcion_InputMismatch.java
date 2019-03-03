package C10Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepcion_InputMismatch
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		int numero=0,numero2=0;
		
		boolean ciclo=true;
		
		do
		{
			try
			{
				System.out.print ("Introduzca un numero entero: ");
				numero=lc.nextInt();
				
				System.out.print ("Introduzca un segundo entero: ");
				numero2=lc.nextInt();
				
				
				ciclo=false;
			}
			
			catch (InputMismatchException e)
			{
				System.err.printf ("\nExcepcion: %s\n",e);
				lc.nextLine();
				System.out.println("Debe introducirse solo valores enteros\n");
			}
		}
		while (ciclo);
		
		System.out.printf ("\nSuma: %d + %d = %d",numero,numero2,numero+numero2);
	}
	
}
