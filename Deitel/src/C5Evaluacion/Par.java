package C5Evaluacion;

import java.io.IOException;
import java.util.Scanner;

public class Par
{
	public static void main(String[] args) throws IOException
	{
		System.out.println(" El siguiente programa tomara el numero leido por el usuario.\n "
				+ "Si el numero es par el valor devuelto sera true, "
				+ " \n de lo contrario devolvera false");
		
		Scanner lc=new Scanner(System.in);
		
		int numero;
		char continuar;
		
		do 
		{		
		
		System.out.print ("\n Introduzca un numero enetero: ");
		numero=lc.nextInt();
		
		System.out.printf ("\n El valor es %b\n",esPar(numero));
		
		System.out.println ("\n Desea volver a ejecutar el programa?");
		continuar = (char)System.in.read( ); 
		}
		while (continuar != 'N' && continuar != 'n');
	}
	
	public static boolean esPar(int numero)
	{
		if (numero % 2 == 0)
			return true;
		
		else 
			return false;
	}
}
