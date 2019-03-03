package C5Evaluacion;

import java.util.Scanner;

public class MostrarCuadradoCaracter
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		int tamano;
		char c;
		
		do
		{
		System.out.print ("\n Introduzca el tamaño del cuadrado: ");
		tamano = lc.nextInt();
		
		System.out.print (" \n Introduzca el caracter con que dese imprimirlo: ");
		char car = lc.next().charAt(0);
		
		System.out.println();
		
		cuadradoAsteriscos(tamano,car);
		
		System.out.println("\n Desea continuar?");
		c = lc.next().charAt (0);
		}
		while (c != 'N' && c != 'n');
	}
	
	public static void cuadradoAsteriscos (int tamano, char car)
	{
		for (int h=1;h<=tamano;h++)
		{
			for (int v=1;v<=tamano;v++)
				System.out.print(" " + car);

			System.out.println();
		}	
	}
}
