package C6ArreglosArrayList;

import java.util.Scanner;

public class PedirNumerosArreglos
{
	public static void main(String[] args)
	{
		
		Scanner lc = new Scanner(System.in);
		
		int a [] = new int [5]; 

		int cont=1,total=0;
		
		for (int i=0; i<a.length; i++)
		{
			
			System.out.printf (" Dame el numero %d: ",cont);
			a[i]=lc.nextInt();
			cont++;
		}
		
		System.out.println("\n Los numeros introducidos fueron:\n");
		
		for (int i=0; i<a.length; i++)
		{
			System.out.println(" " + a[i]);
			total += a[i];
		}
		
		System.out.printf ("\n El total de la suma de los numeros es: %d",total);
	}
}
