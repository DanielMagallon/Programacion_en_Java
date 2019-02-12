package Recursividad;

import java.util.Scanner;

public class Multiplicar
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.print("Introduzca un numero: ");
		int n1=lc.nextInt();
		
		System.out.print ("Introduzca el segundo numero: ");
		int n2=lc.nextInt();
		
		System.out.printf ("%d x %d = %d",n1,n2,multiplicar(n1, n2));
	}
	
	static int multiplicar(int a, int b)
	{
		if (b==1)
		{
			return a;
		}
		
		else
		{
			return a + multiplicar(a, b-1);
		}
	}
}
