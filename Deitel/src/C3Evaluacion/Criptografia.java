package C3Evaluacion;

import java.util.Scanner;

public class Criptografia 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		int num,dig1,dig2,dig3,dig4,temp1,temp2,validardig;
		
		System.out.print(" Introduce una clave que contenga 4 digitos: ");
		num=input.nextInt();
		
		validardig=num/1000;
		
		System.out.println();
	 
		if (validardig>=1 && validardig<=9)
		{
			dig1=num/1000;
		
			dig2=num%1000;
			dig2=dig2/100;
		
			dig3=num%100;
			dig3=dig3/10;
		
			dig4=num%10;
			dig4=dig4/1;
		
			dig1=(dig1+7);
			dig1=dig1%10;
		
			dig2=(dig2+7);
			dig2=dig2%10;
		
			dig3=(dig3+7);
			dig3=dig3%10;
		
			dig4=(dig4+7);
			dig4=dig4%10;
		
			temp1=dig1;
			dig1=dig3;
			dig3=temp1;
			
			temp2=dig2;
			dig2=dig4;
			dig4=temp2;
			
			System.out.printf (" Su nueva clave privada será: %d  %d  %d  %d\n",dig1,dig2,dig3,dig4);
			
		}
		
		else 
			System.out.println (" Error: La cantidad de digitos pedidos puede ser menor o exceda\n de la cantidad de digitos pedidos");
	
	
		while (validardig<1 || validardig>9)
			{
			
		System.out.println();	
		System.out.print(" Introduce una clave que contenga 4 digitos: ");
		num=input.nextInt();
			
		validardig=num/1000;
			
		System.out.println();
		 
			if (validardig>=1 && validardig<=9)
			{
				dig1=num/1000;
			
				dig2=num%1000;
				dig2=dig2/100;
			
				dig3=num%100;
				dig3=dig3/10;
			
				dig4=num%10;
				dig4=dig4/1;
			
				dig1=(dig1+7);
				dig1=dig1%10;
			
				dig2=(dig2+7);
				dig2=dig2%10;
			
				dig3=(dig3+7);
				dig3=dig3%10;
			
				dig4=(dig4+7);
				dig4=dig4%10;
			
				temp1=dig1;
				dig1=dig3;
				dig3=temp1;
				
				temp2=dig2;
				dig2=dig4;
				dig4=temp2;
				
				System.out.printf (" Su nueva clave privada será: %d%d%d%d\n",dig1,dig2,dig3,dig4);
			
			}
			
			else 
				System.out.println (" Error: La cantidad de digitos pedidos puede ser menor o exceda\n de la cantidad de digitos pedidos");
		
			}
	}
}
