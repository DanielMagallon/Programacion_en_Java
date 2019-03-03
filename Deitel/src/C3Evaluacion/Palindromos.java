package C3Evaluacion;

import java.util.Scanner;

public class Palindromos 
{
	public static void main(String[] args) 
	{
			Scanner input=new Scanner(System.in);	
			
			int num,num1=0,num2,num3=0,num4=0,dig;
			
			System.out.print ("Introduzca el numero de 5 digistos: ");
			num=input.nextInt();
			System.out.println();
			
			dig=num/10000;
			
			if (dig>=1 && dig<=9)
			{
			System.out.printf ("%d ", (num/10000));
			num1=num%10000;
			System.out.printf("%d ",num1/1000);
			num2=num%1000;
			System.out.printf("%d ",num2/100);
			num3=num%100;
			System.out.printf("%d ", num3/10);
			num4=num%10;
			System.out.printf("%d\n ",num4/1);
			
			System.out.println();
			
			if ( num/10000==num4/1 && num1/1000== num3/10 )
				System.out.println("El numero es un palindromo");	
			}
			
			else
				System.out.println("Error: Puede que la cantidad de digitos intruucidos sea menor o exceda de la cantidad de digitos pedidos\nVuelve a introducirlo");
				System.out.println();
			
			while ( num/10000 != num4/1 || num1/1000 != num3/10 || dig < 1 || dig>9 )
			{
				
				System.out.print ("Introduzca el numero de 5 digistos: ");
				num=input.nextInt();
				System.out.println();
				
				dig=num/10000;
				
				if (dig>=1 && dig<=9)
				{
				System.out.printf ("%d ", (num/10000));
				num1=num%10000;
				System.out.printf("%d ",num1/1000);
				num2=num%1000;
				System.out.printf("%d ",num2/100);
				num3=num%100;
				System.out.printf("%d ", num3/10);
				num4=num%10;
				System.out.printf("%d\n ",num4/1);
				
				System.out.println();
				
				if ( num/10000==num4/1 && num1/1000 == num3/10 )
					System.out.println("El numero es un palindromo");	
				
				}
				else
					System.out.println("Error: Puede que la cantidad de digitos intruucidos sea menor o exceda de la cantidad de digitos pedidos\nVuelve a introducirlo");
					System.out.println();
			}
	}
}
