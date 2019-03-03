package C10Excepciones;

import java.util.Scanner;

public class Excepcion_Arithmetic
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		int numerador=0,dominador=0,division=0;
		boolean ciclo=true;
		
		do
		{
		try 
		{
			System.out.print ("Introduzca un numerador: ");
			numerador=lc.nextInt();
			
			System.out.print ("Introduzca un denominador: ");
			dominador=lc.nextInt();
			
			division=numerador/dominador;
			ciclo=false;
		}
		
		catch (ArithmeticException e)
		{
			System.err.printf ("\nExcepcion: %s\n",e);
			lc.nextLine();
			System.out.println("No puede dividirse entre 0\n");
		}
		}
		while (ciclo);
		
		System.out.printf ("\n%d / %d = %d",numerador,dominador,division);
	}
}
