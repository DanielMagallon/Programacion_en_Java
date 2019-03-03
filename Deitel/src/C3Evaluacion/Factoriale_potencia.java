package C3Evaluacion;

import java.util.Scanner;

public class Factoriale_potencia 
{
	public static void main(String[] args) 
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.println(" Calcular el valor de 'e' con la formula e = 1 + x^a/n!.... dependiendo\n "
				+ "de los terminos introudcidos por el usuario\n");
		
		System.out.print (" Introduzca el numero de terminos a calcular: ");
		int term=lc.nextInt();
		
		determinarE(term);
	} 
	
	public static void determinarE (int n)
	{
		double e = 0;
		int cont=1;
		int expX=1;
		int i=1;
		int base=1;
		
		while (cont<=n)
		{
			if (cont==1)
			{
				e = 1 + expX/valorE(cont);
				expX++;
				base++;
				cont++;
			}
			
			else
			{
				while (i<cont)
				{
					base *= expX;
					i++;
				}
				
					
				e += (base/valorE(cont));
				expX++;
				base=expX;
				i=1;
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
