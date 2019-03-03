package C3Evaluacion;

import java.util.Scanner;

public class FactorialN 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		int num, fact=0,cont;
		cont=1;

		System.out.print (" Dame un numero: ");
		num=input.nextInt();
		
			while (cont<num)
				{
				if (cont==1)
					{
						fact= num * (num-cont);
						cont++;
					}
			
				else 		
					{
					fact= fact * (num-cont);
					cont++;
					}
			
				}
			System.out.println();
			System.out.printf (" El factorial de %d es: %d",num,fact);
	}
}

