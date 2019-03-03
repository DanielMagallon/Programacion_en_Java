package C10Excepciones;

import java.util.Scanner;

public class Excepcion_NumberFormat
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		String cadena,cadena2;
		boolean ciclo=true;
		int n1=0,n2=0;
		
		do
		{
			try
			{
			System.out.printf ("Introduce una cadena de numeros: ");
			cadena=lc.next();
			n1=Integer.parseInt(cadena);
		
			System.out.printf ("Introduce otra cadena de numeros: ");
			cadena2=lc.next();
			n2=Integer.parseInt(cadena2);
			
			ciclo=false;
			}
			
			catch (NumberFormatException e)
			{
				System.err.printf ("\nExcepcion: %s\n",e);
				lc.nextLine();
				System.out.println("Debe introducir solo cadenas de numeros\n");
			}
		}
		while (ciclo);
		
		System.out.printf ("\nSuma: %d + %d = %d",n1,n2,n1+n2);
	}
}
