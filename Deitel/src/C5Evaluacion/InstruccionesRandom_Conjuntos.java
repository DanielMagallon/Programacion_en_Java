package C5Evaluacion;

import java.util.Random;

public class InstruccionesRandom_Conjuntos
{
	public static void main(String[] args)
	{
		
		Random num = new Random ();
		int numero;
		
		
	    System.out.println(" Imprimir numeros aleatorios del conjunto de los numeros: 2-4-6-8-10");
		System.out.println();
			
			for (int i=1; i<=5; i++)
			{
				numero = 2 + 2 * num.nextInt(5);
				System.out.println(numero);
			}
	
		System.out.println();
		
		System.out.println(" Imprimir numeros aleatorios del conjunto de los numeros: 3-5-7-9-11");
		System.out.println();
			
			for (int i=1; i<=5; i++)
			{
				numero = 3 + 2 * num.nextInt(5);
			System.out.println(numero);
			}
			
		System.out.println();
		
		System.out.println(" Imprimir numeros aleatorios del conjunto de los numeros: 6-10-14-18-22");
		System.out.println();
				
			for (int i=1; i<=5; i++)
			{
				numero = 6 + 4 * num.nextInt(5);
				System.out.println(numero);
			}
	}
}
