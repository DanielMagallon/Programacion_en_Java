package C1Evaluacion;

// Calculadora del indice de masa corporal

import java.util.Scanner;

public class Capitulo1_BMI 
	{

		public static void main(String[] args) 
			{
			
			Scanner input=new Scanner(System.in);
			
			float pesokg,alturamt,bmi;
			
			System.out.println(" Valores de BMI\n Bajo peso: Menos de 18.5\n Normal: Entre 18.5 y 24.9\n Sobrepeso: Entre 25 y 29.9\n Obeso: 30 o más");
			System.out.println();
			
			System.out.println("Inroduzca su peso: ");
			pesokg=input.nextFloat();
			
			System.out.println("Introduzca su altura (solo en centìmetros): ");
			alturamt=input.nextFloat();
			alturamt=alturamt/100;
			
			
			bmi=(pesokg)/(alturamt*alturamt);
			
			System.out.println();
			System.out.printf("Tu masa corporal es de: %f\n",bmi);
			System.out.println();
		
			if (bmi<18.5)
				System.out.println("Eres bajo de peso");
	
			
			if (bmi>=18.5)
				if (bmi<=24.9)
				System.out.println("Tu peso es normal");
			
			
			if (bmi>=25)
				if (bmi<=29.9)
				System.out.println("Tienes sobrepeso");
	
			if (bmi>=30)
				System.out.println("Eres una persona obesa");
			
			
			}
	}
