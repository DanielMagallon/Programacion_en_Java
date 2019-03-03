package C3Evaluacion;

import java.util.Scanner;

public class Factorialconstantee 
{
	
	public static void main(String[] args) 
	{
		Scanner lc = new Scanner(System.in);
		
		
		System.out.println(" Calcular el valor de 'e' con la formula e = 1 + 1/n!.... dependiendo\n "
				+ "de los terminos introudcidos por el usuario\n");
		System.out.print (" Introduzca el numero de terminos a calcular: ");
		int n=lc.nextInt();
		
		determinarE(n);
	}
	
	public static void determinarE (int n)
	{
		
		double e=0;
		int cont=1;
		
		while (cont<=n)
		{
			if (cont==1)
			{
			
				e = 1 + 1/valorE(cont);
				cont++;
			}
			
			else 
			{
				e +=  (1/valorE(cont));
				cont++;
				
			}
		}
		
		System.out.printf ("\n e = %f ",e);
	}
	
	public static double valorE (int cont)
	{
		int factorial=1;
		
			for (int i=cont; i>0; i--)
			{
				factorial *= i;	
			}
		 
			
		 return factorial;
	}
}
