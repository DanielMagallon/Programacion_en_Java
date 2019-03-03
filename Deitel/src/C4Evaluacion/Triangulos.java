package C4Evaluacion;

import java.util.Scanner;

public class Triangulos
{
	public static void main(String[] args)
	{
		
		Scanner lc = new Scanner (System.in);
		
		
		int ast=1;
		
		System.out.print ("Altura del triangulo: ");
		int altura=lc.nextInt ();
		
		System.out.println();
		
		int numesp=altura;
		
		for (int v=1; v<=altura; v++)
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
		
		System.out.println("\n");
		System.out.println("\n Triangulo inverso: \n\n");
		
		ast=altura*2-1; numesp=0;
		
		for (int v=1; v<=altura; v++)
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
