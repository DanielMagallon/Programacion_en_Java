package C4Evaluacion;

import java.util.Scanner;

public class Rombo
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		int numesp=5;
		int ast=1;
		int filas;
		
		for (int v=1; v<=5; v++)
		{
			for (int i=1; i<numesp; i++)
			{
				System.out.print (" ");
			}
			
			for (int r=ast; r>0; r--)
			{
				System.out.print ("*");
			}
			
			numesp--;
			ast += 2;
			System.out.println();
		}
		
		ast=7; numesp=1;
		
		for (int v=1; v<=4; v++)
		{
			for (int i=numesp; i>0; i--)
				System.out.print (" ");
			
			for (int r=ast; r>0; r--)
				System.out.print ("*");
			
			ast -= 2; 
			numesp++;
			System.out.println();
		}
		
		System.out.println();
		do
		{
		System.out.println("\n Dame un numero impar del 1 al 19: ");
		filas=lc.nextInt();
		
		if (filas<=0 || filas >=20)
			System.out.println("\n El numero introducido no pertenece al rango pedido. Introduzcalo de nuevo\n");
		
		else
			if (filas%2==0)
				System.out.println("\n El numero introducido es un numero par. Introduzcalo de nuevo\n");
		
		
		else
			if (filas%2 != 0)
		{
				int l=filas/2 + 1;
				numesp=l;
				 ast=1;
				
				for ( int v=1; v<=l; v++)
				{
					for (int i=1; i<numesp; i++)
					{
						System.out.print (" ");
					}
					
					for (int r=ast; r>0; r--)
					{
						System.out.print ("*");
					}
					
					numesp--;
					ast += 2;
					System.out.println();
				}
				
			l=filas-l;
			ast=filas-2; numesp=1;
				
				for (int v=1; v<=l; v++)
				{
					for (int i=numesp; i>0; i--)
						System.out.print (" ");
					
					for (int r=ast; r>0; r--)
						System.out.print ("*");
					
					ast -= 2; 
					numesp++;
					System.out.println();
				} 
		}
		
		}
		while (filas>=20 || filas <=0 || filas%2==0);
	}
}
