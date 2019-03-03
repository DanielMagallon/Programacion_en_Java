package C10Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionManejoException
{
	static int cociente (int numerador, int denominador)
			throws ArithmeticException
	{
		return numerador / denominador;
	}
	
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		boolean continuarCiclo=true; // determina si se necesitan mas datos de entrada
		
		do
		{
			try
			{
		System.out.print("Introduzca un numerador entero: ");
		int num = lc.nextInt();
		System.out.print("\nIntroduzca un denominador entero: ");
		int den=lc.nextInt();
		
		int resultado = cociente(num, den);
		
		System.out.printf ("\nResultado: %d / %d = %d",num,den,resultado);
		continuarCiclo=false; // entraa existosa, termina el ciclo
			}
			
			catch (InputMismatchException e)
			{
				System.err.printf ("Excepcion: %s\n",e);
				lc.nextLine();
				
				System.out.println("Debe introducir enteros.\nIntente de nuevo");
			}
			
			catch (ArithmeticException e)
			{
				System.err.printf ("Excepcion: %s\n",e);
				lc.nextLine();
				
				System.out.println("Cero es un denominador invalido.\nIntente de nuevo\n");
			}
			
		}
		while(continuarCiclo);
	}
}
