package C6ArreglosArrayList;

import java.util.Random;

public class PromedioArreglos
{
	public static void main(String[] args)
	{
		
		Random lb = new Random();
		
		int [] a = new int [5];
		
		double suma=0;
		double prom;
		
		for (int i=0; i<a.length; i++)
		{
			a [i] = lb.nextInt(11);
		}
		
		System.out.println(" Los numeros generados son:\n");
		
		for (int i=0; i<a.length; i++)
		{
			System.out.printf ("  %d ",a[i]);
		}
		
		for (int i=0; i<a.length; i++)
		{
			suma += a [i];
		}
		
		prom=suma/a.length;
		
		System.out.printf ("\n\n El promedio es %.2f",prom);
	}
}
