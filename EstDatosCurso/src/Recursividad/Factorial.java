package Recursividad;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial 
{
	public static void main(String[] args) 
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.print ("Introduzca un numero a calcular su factorial: ");
		int f=lc.nextInt();
		
		System.out.printf ("Factorail de %d = %d\n",f,factorial(f));
		
	}
	
	static long factorial(long n)
	{
		if (n<0)
		{
			return 0;
		}
		
		else
			if (n==0)
			{
				return 1;
			}
		
		else
		{
			return n * factorial(n-1);
		}
	}
	
}