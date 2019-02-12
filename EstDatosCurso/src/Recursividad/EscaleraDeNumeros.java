package Recursividad;

import java.util.Scanner;

public class EscaleraDeNumeros
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.print ("Introduzca una altura: ");
		int alt=lc.nextInt();
		
		System.out.println("\n" + imprimirEscaleraDecrementa(alt));
	}
	
	static String imprimirEscaleraDecrementa(int altura)
	{
		String alt=Integer.toString(altura);
		int cont=1;
		
		if (altura==1)
		{
			return "1";
		}
		
		else
		{
			while (cont<altura)
			{
				alt += alt=Integer.toString(altura);
				cont++;
			}
			
			return  alt + "\n" + imprimirEscaleraDecrementa(altura-1);
		}
	}
}
