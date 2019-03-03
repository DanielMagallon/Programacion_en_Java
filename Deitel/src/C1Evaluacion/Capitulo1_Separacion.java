package C1Evaluacion;

// Separar digitos de un entero

import java.util.Scanner;

public class Capitulo1_Separacion 
	{
		
		public static void main(String[] args) 
			{
				
			Scanner input=new Scanner(System.in);
			
			int num,dig;
			
			System.out.print("Introduce un valor de 5 digitos: ");
			num=input.nextInt();
			
			
			dig=num/10000;
			
			if (dig==1)
			{
			System.out.printf ("%d ", (num/10000));
			
			num=num%10000;
			System.out.printf("%d ",num/1000);
			
			num=num%1000;
			System.out.printf("%d ",num/100);}
			
			num=num%100;
			System.out.printf("%d ", num/10);
			
			num=num%10;
			System.out.printf("%d ",num/1);
			
			num=num%1;
			
			System.out.println("--------------------------");
			
			int dig1,dig2,dig3,dig4,dig5;
			
			System.out.print ("Introduzca el numero de 5 digistos: ");
			num=input.nextInt();
			System.out.println();

			dig1=num/10000;
			
			dig2=num%10000;
			dig2=dig2/1000;
			
			dig3=num%1000;
			dig3=dig3/100;
			
			dig4=num%100;
			dig4=dig4/10;
			
			dig5=num%10;
			dig5=dig5/1;
			
			System.out.printf("%d\n%d\n%d\n%d\n%d\n", dig1, dig2, dig3, dig4, dig5);
			
			}
		
		
			
			//		System.out.print (num/10000 + " ");
			//		num=num%10000;
			//		System.out.print(num/1000 + " ");
			//		num=num%1000;
			//		System.out.print(num/100 + " ");
			//		num=num%100;
			//		System.out.print(num/10 + " ");
			//		num=num%10;
			//		System.out.print(num/1 + " ");
			//		num=num%1;
			
			}

