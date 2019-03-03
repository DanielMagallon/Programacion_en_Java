package C1Evaluacion;

// Determinar si el numero introducido es par o impar.

import java.util.Scanner;

public class Capitulo1_Parimpar 
	{
			public static void main(String[] args) 
				{
				
				Scanner input=new Scanner (System.in);
				
				int num,p;
				
				System.out.print("Introduce un numero: ");
				num=input.nextInt();
				
				p=num%2;
				
				if (p==0)
					System.out.print ("El numero introducido es un numero par");
				
				if (p!=0)
					System.out.print ("El numero introducido es un numero impar");
				
				}
	}	
