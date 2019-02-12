package Recursividad;

import java.util.Scanner;

public class ElevarPotencia
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.print("Introduzca un numero: ");
		int numero=lc.nextInt();
		
		System.out.print ("Introduzca la potencia: ");
		int exp=lc.nextInt();
		
		System.out.printf ("Numero elevado: %d",elevarNumero(numero,exp));
		
	}
	
	static int elevarNumero(int n,int potencia)
	{
		if (potencia==0)
		{
			return 1;
		}
		
		else
		{
			return n * elevarNumero(n, potencia-1);
		}
	}
}
