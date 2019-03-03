package C3Evaluacion;

import java.util.Scanner;

public class DosNumeromayor 
{
	
	public static void main(String[] args) 
		{
		Scanner input = new Scanner(System.in);
		
		int cont,num,mayor1=0,mayor2=0;
		cont=1;
		
		while (cont<=10)
			{		
			
			System.out.print ("Escribe un numero: ");
			num=input.nextInt();
			
			if (cont==1)
			{
				mayor1=num;
			}
				
			else
			{
				if (num>mayor1)
				{
					mayor2=mayor1;
					mayor1=num;
				}
				if(num<mayor1 && num>mayor2)
					mayor2=num;
			}
					
					 cont++;
				}
		System.out.println();
		System.out.printf ("Los numeros mayores son: %d y %d\n",mayor1,mayor2);
	}
}

