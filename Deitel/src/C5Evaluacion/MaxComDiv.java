package C5Evaluacion;

import java.util.Scanner;

public class MaxComDiv
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		int n1,n2;
		
		System.out.print (" Escriba el primer numero: ");
		n1=lc.nextInt();

		System.out.print (" Escriba el segundo numero: ");
		n2=lc.nextInt();
		
		maximoDivisor(n1, n2);
		
	}
	
	public static void maximoDivisor (int x,int y)
	{
		
		System.out.printf ("\nDivisores del %d\n\n",x);
		
		for (int i=1; i<=x; i++)
		{
			if (x%i==0)
			{
				System.out.printf ("Divisor: %d\n",i);
			}
		}
		
		System.out.println("\n");
		
		System.out.printf ("Divisores del %d\n\n",y);
		
		for (int i=1; i<=y; i++)
		{
			if (y%i==0)
			{
				System.out.printf ("Divisor: %d\n",i);
			}
		}
		
		System.out.println("\n");
		
		int i,a;
		int mcd=0;
		
		for (i=1; i<=x; i++)
		{
			for (a=1; a<=y; a++)
			{
				if (y%a==0 && x%i==0)
				{
					if (i==a)
					{
						mcd=i;
					}
				}
			
			}
		}
		
		System.out.printf ("El maximo comun divisor es: %d\n",mcd);
		
	}
	
}
