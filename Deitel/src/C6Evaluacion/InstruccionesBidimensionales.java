package C6Evaluacion;

import java.util.Random;
import java.util.Scanner;


public class InstruccionesBidimensionales
{
	public static void main(String[] args)
	{
		int [][] t = new int [2][3];
		
		Random lb = new Random();
		
		for (int i=0; i<t.length; i++)
		{
			for (int j=0; j<t[i].length; j++)
			{
				t[i][j]= lb.nextInt(9) + 1;
			}
		}
		
		for (int i=0; i<t.length; i++)
		{
			for (int j=0; j<t[i].length; j++)
			{
				System.out.printf ("%3d ",t[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("\nLos elementos de la fila 1 son:\n");
		
		System.out.println(t[1][0]);
		System.out.println(t[1][1]);
		System.out.println(t[1][2]);
		
		System.out.println("\nLos elementos de la columna 2 son:\n");
		
		System.out.println(t[0][2]);
		System.out.println(t[1][2]);
		
		System.out.println("\nSe asingo 0 al arreglo de la posicion [0][1]\n");
		
		t[0][1]=0;
		
		for (int i=0; i<t.length; i++)
		{
			for (int j=0; j<t[i].length; j++)
			{
				System.out.printf ("%3d ",t[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("\nSe asingo 0 a todas la posiciones\n");
		
		t[0][0]=0;
		t[0][1]=0;
		t[0][2]=0;
		t[1][0]=0;
		t[1][1]=0;
		t[1][2]=0;
		
		for (int i=0; i<t.length; i++)
		{
			for (int j=0; j<t[i].length; j++)
			{
				System.out.printf ("%3d ",t[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("\nSe asingo 0 a todas la posiciones con instrccion for anhidada\n");
		
		for (int i=0; i<t.length; i++)
		{
			for (int j=0; j<t[i].length; j++)
			{
				t[i][j]=0;
			}
		}
		
		for (int i=0; i<t.length; i++)
		{
			for (int j=0; j<t[i].length; j++)
			{
				System.out.printf ("%3d ",t[i][j]);
			}
			System.out.println();
		}
		
		
		System.out.println("\nEl usuario escribe los elementos del arreglo bidimensional\n");
		
		Scanner lc = new Scanner(System.in);
		
		for (int i=0; i<t.length; i++)
		{
			for (int j=0; j<t[i].length; j++)
			{
				System.out.print ("Escriba un valor al arreglo: ");
				t[i][j]=lc.nextInt();
				System.out.println();
			}
		}
		
		System.out.println("Los valores introducidos fueron:\n");
		
		
		for (int columna=0; columna<t[0].length; columna++)
			System.out.printf (" %15s %d","Columna",columna+1);
		
		System.out.println("\n");
		
		for (int i=0; i<t.length; i++)
		{
			System.out.printf ("Fila %d",i+1);
			
			for (int j=0; j<t[i].length; j++)
			{
				System.out.printf ("\t\t%d",t[i][j]);
			}
			System.out.println();
		}
		
		System.out.print("\nEl valor menor del arreglo es: ");
		
		int menor=t[0][0];
		
		for (int i=0; i<t.length; i++)
		{
			for (int j=0; j<t[i].length; j++)
			{
				if (menor>t[i][j])
					menor=t[i][j];
			}
		}
		System.out.println(menor);
		
		System.out.printf ("Los elementos de la primera fila son: %d %d %d\n",t[0][0],t[0][1],t[0][2]);
		
		int total=t[0][2] + t [1][2];
		
		System.out.printf ("El total de los elemntos de la tercera columna de t es: %d",total);
	}
}
