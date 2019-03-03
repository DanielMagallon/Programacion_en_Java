package HelpClass;

import java.util.Scanner;

public class Imprimir_asteriscos 
{
	
	private static int num;
	private static int cont,i,i2,i3,i4,i5;
	
	
	
	public static void main (String args[])
	 {
		
			Scanner lc=new Scanner (System.in);
		while (cont<5)
		{
			
			System.out.print (" Dame un numero entre el 1-30: ");
			int	num=lc.nextInt();
			
			cont++;
			
			if (cont==1)
			{
				i=num;
			}
			
			if (cont==2)
			{
				 i2 = num;
			}
			
			if (cont==3)
			{
				i3=num;
			}
		
			if (cont==4)
			{
				i4=num;
			}
			
			if (cont==5)
			{
				i5=num;
			}
			
			
			
		}
			
			System.out.println();
		
			for (int ast1 = 1; ast1 <=i; ast1++)
			{
				System.out.print ("* ");
			}
			
			System.out.println();
			
			for (int ast2 = 1; ast2 <= i2; ast2++)
			{
				System.out.print ("* ");
			}
			
			System.out.println();
			
			for (int ast3 = 1; ast3 <=i3; ast3++)
			{
				System.out.print ("* ");
			}
			
			System.out.println();
			
			for (int ast4 = 1; ast4 <=i4; ast4++)
			{
				System.out.print ("* ");
			}
			
			System.out.println();
			
			for (int ast5 = 1; ast5 <=i5; ast5++)
			{
				System.out.print ("* ");
			}
			
			System.out.println();
	}
}
