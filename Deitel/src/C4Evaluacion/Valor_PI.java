package C4Evaluacion;

import java.util.Scanner;

public class Valor_PI 
{
	public static void main(String[] args) 
	{
		
		Scanner nc =  new Scanner(System.in);
		
		double pi=0,divisor=1;
		int termino;
		
		System.out.print (" Introduce el numero de terminos a calcular: ");
		termino=nc.nextInt();
		
		System.out.println("\n");
		
		System.out.print ("PI: ");
		for (int i=1; i<=termino; i++)
		{
			if (i%2==0)
			{
				pi -= 4/divisor;
				
				System.out.printf (" - 4/%d",(int) divisor);
			}
			
			else
			{
				pi += 4/divisor;
					if (i==1)
				System.out.printf (" 4/%d",(int) divisor);
					
					else
						System.out.printf (" + 4/%d",(int) divisor);
			}
			
			divisor += 2;	
		}
		System.out.printf ("\n\nValor de PI: %f ",pi);
	}
}
