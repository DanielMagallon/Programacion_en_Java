package C6Evaluacion;

import java.util.Scanner;

public class PaseDelCaballo
{
	private int [][] tablero = new int [8][8];
	private int [] horizontal = {2,1,-1,-2,-2,-1,1,2};
	private int [] vertical = {-1,-2,-2,-1,1,2,2,1};
	Scanner lc = new Scanner(System.in);
	
	private void moverCaballo ()
	{
		System.out.println();
		
		char caballo='C'; 
		
		for (int i=0; i<horizontal.length; i++)
		{
			System.out.print("\t\t");
			System.out.printf ("Horizontal [%2d] = %2d    ",i,horizontal[i]);
			System.out.printf ("Vertical [%2d] = %2d\n",i,vertical[i]);
		}
		
		System.out.println("\n\n");
		
		for (int i=0; i<tablero.length; i++)
		{
				System.out.print("\t\t\t");
				
				
			for (int j=0; j<tablero[i].length; j++)
			{
				if (j==0 && i==0)
				System.out.print (caballo + " ");
				
				else
				System.out.printf ("%d ",tablero[i][j]);
			}
			System.out.println();
		}
		
		char caracter;
		int v=0,h=0;
		
		System.out.println("\n\nIntroduce una 'v' si desea empezar con un movimento vertical\nO "
				+ "introduzca un a 'h' si desea empezar con un moviemiento horizontal: ");
		caracter=lc.next().charAt(0);
		
		System.out.println();
		
		if (caracter=='v' || caracter=='V')
		{
			System.out.print ("Introduzca el numero (0-7) de posiciones verticales a avanzar: ");
			 v=lc.nextInt();
			
			System.out.print ("Introduzca el numero (0-7) de posiciones horizontales a avanzar: ");
			 h=lc.nextInt();
		}
		else
			if (caracter=='H' || caracter=='h')
			{
				System.out.print ("Introduzca el numero (0-7) de posiciones horizontales a avanzar: ");
				 h=lc.nextInt();
				
				System.out.print ("Introduzca el numero (0-7) de posiciones verticales a avanzar: ");
				 v=lc.nextInt();
			}
		
		
		
		System.out.printf ("\nEl caballo avanzara %d posiciones horizontales",horizontal[h]);
		System.out.printf ("\nEl caballo avanzara %d posiciones verticales",vertical[v]);
		
		System.out.println("\n");
				
		
		
	}
	
	void moverPosicionCaballo ()
	{
		
	}
	
	public static void main(String[] args)
	{
		PaseDelCaballo pdc = new PaseDelCaballo();

		
		pdc.moverCaballo();
	}
}
