package C6ArreglosArrayList;

import java.util.Random;

public class NumeroMayorArreglos 
{
	public static void main(String[] args)
	{
		
		int [] x = new int [5];
		
		Random lc = new Random();
		
		for (int i=0; i<x.length; i++)
		{
			x [i] = lc.nextInt(10);
			System.out.println(x[i]);
		}
		
		int mayor = x [0];
		
		for (int i=0; i<x.length; i++)
		{
			if (mayor < x[i])
			{
				mayor=x[i];
			}
		}
		System.out.printf ("\n El numero mayor es: %d",mayor);
	}
}
