package C1Evaluacion;

// Imprimir dos numeros, y determinar si es multiplo.

import java.util.Scanner;

public class Capitulo1_Multiplo 
	{
		public static void main(String[] args) 
			{
			
			Scanner input=new Scanner (System.in);
			
			int n1, n2,mul;
			
			System.out.print ("Introduce el primer numero: ");
			n1=input.nextInt();
			
			System.out.print ("Introduce el segundo numero: ");
			n2=input.nextInt();
			
			mul=n1%n2;
				
				if (mul==0)
					System.out.print("Los numeros introducidos son multilpos entre sí");
				
				if (mul!=0)
					System.out.print("Los numeros introducidos no son multilpos entre sí");
			
			}
	}	

