package C10Excepciones;

import java.util.Scanner;

public class CatchMultiple
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		String cadena;
		int numero=0,numero2=0;
		
		
		try
		{
		System.out.print("Introduzca un numero: ");
		cadena=lc.next();
		 numero = -Integer.parseInt(cadena);
		 
		 System.out.print("Introduzca un segundo numero: ");
		 cadena=lc.next();
		 numero2 = -Integer.parseInt(cadena);
		 
		 int div=numero/numero2;
		 
		}
		catch (ArithmeticException  | NumberFormatException e)
		{
			System.err.printf ("Excepcion: %s",e);
		}
		finally {
			System.out.println("Hubo error");
		}
	}
}
