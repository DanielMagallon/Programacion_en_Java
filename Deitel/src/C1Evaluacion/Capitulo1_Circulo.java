package C1Evaluacion;

// Obetener el diametro, circunferencia y area de un ciruclo.

import java.util.Scanner;

public class Capitulo1_Circulo 
	{
		public static void main(String[] args) 
			{
			
			Scanner input=new Scanner (System.in);
			
			int radio;
			
			System.out.print ("Introduce el radio del circulo: ");
			radio=input.nextInt();
			
			System.out.printf("El diametro del circulo es: %d\n",(2*radio));
			 
			System.out.printf("La circunferencia del circulo es: %f\n", (2*Math.PI*radio));
			
			System.out.printf("El area del circulo es: %f\n", (Math.PI*radio*radio));
			}
	}
