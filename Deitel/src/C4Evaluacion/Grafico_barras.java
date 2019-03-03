package C4Evaluacion;

import java.util.Scanner;

public class Grafico_barras 
{
	private static int num;
	private static int i,i2,i3,i4,i5;
	
	
	public static void main(String[] args) 
	{
		Scanner lc = new Scanner(System.in);
		
		int cont=1;
		
		while (cont<=5)
		{
			do
			{
				System.out.print (" Dame un numero entre el 1-30: ");
				num=lc.nextInt();
				System.out.println();
				
				
				if (num>=1 && num<=30)
				{
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
				
					
					cont++;
				}
			
				else 
				{
					if (num<1 || num>30)
					System.out.println(" Numero no valido.\n Vuelva a introducirlo");
					System.out.println();
				}
			}
			while (num<1 || num>30);
		}
	
		System.out.println();
		
		for (int ast = 1; ast <=i; ast++)
		{
			System.out.print ("* ");
		}
		
		System.out.println();
		
		for (int ast = 1; ast <= i2; ast++)
		{
			System.out.print ("* ");
		}
		
		System.out.println();
		
		for (int ast = 1; ast <=i3; ast++)
		{
			System.out.print ("* ");
		}
		
		System.out.println();
		
		for (int ast = 1; ast <=i4; ast++)
		{
			System.out.print ("* ");
		}
		
		System.out.println();
		
		for (int ast = 1; ast <=i5; ast++)
		{
			System.out.print ("* ");
		}
		
		System.out.println();
		
		
	}
	}
	
	
