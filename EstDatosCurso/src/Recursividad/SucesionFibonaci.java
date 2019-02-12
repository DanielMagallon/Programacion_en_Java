package Recursividad;

import java.util.Scanner;

public class SucesionFibonaci 
{
	public static void main(String[] args) 
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.printf("La sucesion Fibonaci de 6 mediante recursividad es: %d",
				fibonaciRecursivo(6));
	}
	
	static int fibonaciRecursivo(int n)
	{
	
		if (n==0)
		{
			return 0;
		}
		
		else
		  if (n==1 || n==2)
		{
			return 1; // caso base
		}
		
		else
		{
			return fibonaciRecursivo(n-1) + fibonaciRecursivo(n-2);
		}
	}
}
