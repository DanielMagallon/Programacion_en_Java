package C6Evaluacion;

import java.util.Random;

public class Instrucciones2
{
	public static void main(String[] args)
	{
		
		System.out.println("1.- Asignar el valor de 0 a los 10 elementos del arreglo cuenta\n");
		
		int [] cuenta = new int [10];
		
		for (int i=0; i<cuenta.length; i++)
			cuenta[i]=0;
		
		for (int i=0; i<cuenta.length; i++)
			System.out.printf ("cuenta [%d] = %d\n",i,cuenta[i]);
		
		
		System.out.println("\n2.- Sumar uno a cada uno de los 15 elementos del arreglo bono de tipo entero \n");
		
		int [] bono= new int [15];
		
		for (int i=0; i<bono.length; i++)
			bono [i] = i + 1;
		
		for (int i=0; i<bono.length; i++)
			System.out.printf ("bono [%2d] + 1 = %3d\n",i,bono[i]);
		
		
		System.out.println("\n3.- Imprimir los 5 valores del arreglo mejoresPuntuaciones en columnas\n");
		
		int [] mejoresPuntuaciones = new int [5];
		
		Random lb = new Random();
		
		for (int i=0; i<mejoresPuntuaciones.length; i++)
			mejoresPuntuaciones[i] = lb.nextInt(10) + 1;
		
		for (int i=0; i<mejoresPuntuaciones.length; i++)
				System.out.printf ("%3d\n",mejoresPuntuaciones[i]);
	}
}
