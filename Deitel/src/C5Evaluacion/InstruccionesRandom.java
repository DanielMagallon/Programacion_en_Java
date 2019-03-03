package C5Evaluacion;

import java.util.Random;

public class InstruccionesRandom
{
	public static void main(String[] args)
	{
		Random numeros =  new Random ();
		
		int n;
		
		System.out.println("Imprimir numero aleatorios en el rango 1-2");
		System.out.println();
		
		for (int cont = 1; cont <= 5; cont++)
		{
			System.out.println(n = 1 + numeros.nextInt(2));
		}
		
		System.out.println();
		
		System.out.println("Imprimir numero aleatorios en el rango 1-100");
		System.out.println();
		
		for (int cont = 1; cont <= 5; cont++)
		{
			System.out.println(numeros.nextInt(100)+1);
		}
		
		System.out.println();
		
		System.out.println("Imprimir numero aleatorios en el rango 0-9");
		System.out.println();
		
		for (int cont = 1; cont <= 5; cont++)
		{
			System.out.println(numeros.nextInt(10));
		}
		
		System.out.println();
		
		System.out.println("Imprimir numero aleatorios en el rango 1000-1112");
		System.out.println();
		
		for (int cont = 1; cont <= 5; cont++)
		{
			 System.out.println(numeros.nextInt(1112-1000+1)+1000);
		}
		
		System.out.println();
		
		System.out.println("Imprimir numero aleatorios en el rango -1 - 1");
		System.out.println();
		
		for (int cont = 1; cont <= 5; cont++)
		{
			 System.out.println(numeros.nextInt(1- -1+1)+ -1);
		}
		
		System.out.println();
		
		System.out.println("Imprimir numero aleatorios en el rango -3 - 11");
		System.out.println();
		
		for (int cont = 1; cont <= 5; cont++)
		{
			 System.out.println(numeros.nextInt(11 - -3+1)+ -3);
		}
	}
}
