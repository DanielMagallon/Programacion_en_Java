package C3Evaluacion;

import java.util.Scanner;

public class Triangulo 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		int lado1,lado2,lado3;
		
		System.out.print (" ---Introducir tres lados, para determinar si se\n puede construir un triangulo equilatero---");
		System.out.println("\n");
		
		System.out.print ("Introduce el lado del triangulo: ");
		lado1=input.nextInt();
		
		System.out.println();
		
		System.out.print ("Introduce el segundo lado del triangulo: ");
		lado2=input.nextInt();
		
		System.out.println();
		
		System.out.print ("Introduce el tercer lado del triangulo: ");
		lado3=input.nextInt();
		
		System.out.println();
		
		
		if (lado1==lado2 && lado1==lado3 && lado2 == lado3)
			
			System.out.println(" Los lados introducidos pueden representar las medidas\n de un triangulo equilatero");
	}
}

