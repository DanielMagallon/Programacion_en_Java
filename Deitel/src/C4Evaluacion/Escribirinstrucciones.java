package C4Evaluacion;

import java.util.Scanner;



public class Escribirinstrucciones 
{
	public static void main(String[] args) 
	{
		System.out.println( "----Suamr los enteros impares entre 1 y 99-----" );
		System.out.println();
		
		int suma=0,cuenta;
		
			for (cuenta=1; cuenta<=99; cuenta += 2)
			{
				System.out.printf ( "%d ",cuenta );
				suma += cuenta;
			}
			
			System.out.println();
			System.out.printf ( "\nLa suma de los numeros impares es: %d",suma );
			
			System.out.println();
			System.out.println("---------------------------------------------------------");
			System.out.println();
			
			System.out.println("----Calcular el de 2.5 elevado a la potencia de 3----");
			System.out.println();
			
			System.out.printf (" El valor de 2.5 elevado a la potencia de 3 es: %.3f",Math.pow(2.5, 3));
			
			System.out.println();
			System.out.println("---------------------------------------------------------");
			System.out.println();
			
			System.out.println("----Imprimir los enteros del 1 al 20, imprimiendo 5 enteros por linea----");
			System.out.println();
			
			int i=1;
			
			while (i <= 20)
			{
				
				System.out.printf ("%d",i);
				
				if (i % 5 == 0)
				
					System.out.println();
				
				else
					System.out.print ('\t');
				
				i++;
			}
			
			System.out.println();
			System.out.println("---------------------------------------------------------");
			System.out.println();
			
			System.out.println("----Imprimir los enteros del 1 al 20, imprimiendo 5 enteros por linea,usando 'for'----");
			System.out.println();

			
			for (i = 1; i<=20; i++ )
			{
				System.out.printf ("%d",i);
				

				if (i % 5 == 0)
				
					System.out.println();
				
				else
					System.out.print ('\t');
			}
			
			
	}
}
