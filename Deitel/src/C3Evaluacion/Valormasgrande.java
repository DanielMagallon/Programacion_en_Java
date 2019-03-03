package C3Evaluacion;

import java.util.Scanner;

public class Valormasgrande 	
{
	public static void main(String[] args) 
		{
			Scanner input = new Scanner(System.in);
		
			int num,cont,mayor=0;
			cont=1;
			
			
			
			
			while (cont<=10)
				{	
					
					System.out.print ("Escribe un numero: ");
					num=input.nextInt();
					
					if (num>mayor)
					{
						mayor=num;
					}
					cont++;

					
				}
			System.out.println();
			System.out.printf ("El numero mayor es: %d\n",mayor);
		}
}
