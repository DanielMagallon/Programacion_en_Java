package C5Evaluacion;

import java.util.Scanner;

public class NumerosPerfectos
{
	public static Scanner lc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		
		
		char car;
		
		System.out.print (" Dame un numero entero: ");
		int num=lc.nextInt();
		
		esPerfecto(num);
		
		System.out.println("\n\n Desea ejecutar los numeros del 1 al 1000, para que usted pueda determinar\n cuales son los"
				+ "numeros perfectos, o desea salir del programa?");
		
		System.out.println (" \n Para ejecutar los numeros oprima la letra: R/r");
		System.out.println (" \n Para salir del programa oprima la letra S/s");
		car = lc.next().charAt(0);
		
		if (car == 'R' || car == 'r')
			esPerfecto2 ();
		
		else if (car == 'S' || car == 's')
			System.exit(0);
	}	
	
	public static void  esPerfecto (int num)
	{
		int total=0,numP=0;
	
		for (int i=1; i<=num; i++)
		{
			if (i==num)
				break;
			
			else if (num%i == 0)
			{
				numP=i;
				total += numP;
				if (i==1)
				System.out.printf ("\n %d = %d ",num,numP);
				else
				System.out.printf ("+ %d ",numP);
			}
		}
		
		if (total == num)
			System.out.printf("\n\n El numero %d es un numero Perfecto",num);
		
		else 
			System.out.printf("\n\n El numero %d no es un numero Perfecto",num);
	}
	
	public static void esPerfecto2 ()
	{
		int numP=0;
		
		for (int j=1; j<=1000;j++)
		{
			for (int i=1; i<=j; i++)
			{
				if (i==j)
					break;
				
				else if (j%i == 0)
				{
					numP=i;
					if (i==1)
					System.out.printf ("\n %d = %d ",j,numP);
					else
					System.out.printf ("+ %d ",numP);
				}
			}
	}
		
		System.out.printf ("\n\n Los numeros perfectos son: 6, 28 y 496");
	}
}
