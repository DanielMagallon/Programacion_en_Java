package C5Evaluacion;

import java.util.Scanner;

public class NumerosPrimos
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		char opc;
		
		do
		{
		System.out.print (" Intrduzca un numero: ");
		int num=lc.nextInt();
		numeroPrimo(num);
		
		System.out.println("\n\n Desea avanzar a lo siguiente?");
		opc = lc.next().charAt(0);
		}
		while (opc != 'S' && opc != 's');
		
		numerosPrimos ();
	}
	
	public static void numeroPrimo (int num)
	{
		int primo=0;
		boolean pnum=false;
		
		
		if (num == 4)
			System.out.printf("\n El numero %d no es un numero primo.",num);
		
		else 
			if (num<=3)
				System.out.printf ("\n El numero %d es un numero primo.",num);
		else 
		{
		for (int i=3; i<num;i++)
		{
			primo = num%i;
			
			if ( primo != 0)
			{
				pnum=true;
			}
			else if ( primo == 0)
			{
				pnum=false;
		
			if (pnum==false)
				break;
			}
		}
		if ( pnum==true)
			System.out.printf ("\n El numero %d es un numero primo.",num);
		
		else 
			System.out.printf("\n El numero %d no es un numero primo.",num);
		}
		
		
	}
	
	public static void numerosPrimos ()
	{
		
		System.out.println("Numeros primos del 1 al 10000:\n");
		
		for (int num=1; num<=10000; num++)
		{
			int primo=0;
			boolean pnum=false;
			
				
			
					if (num<=3)
					System.out.printf ("%d\n",num);
				
					else if (num==4)
					System.out.print("");
			else 
			{
			for (int i=3; i<num; i++)
			{
				primo = num%i;
				
				if ( primo != 0)
				{
					pnum=true;
				}
				else if ( primo == 0)
				{
					pnum=false;
			
				if (pnum==false)
					break;
				}
			}
			
			if ( pnum==true)
				System.out.printf ("%d\n",num);
			
			
			}
		}
	}

}
