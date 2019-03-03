package C1Evaluacion;
// Imprimir la suma, producto, diferencia, residuos y cociente (division) de dos numeros.

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Set;

public class Capitulo1_Aritmetica 
	{
		public static void main(String[] args) 
			{
			Scanner input=new Scanner (System.in);
			
			int num1, num2,suma, producto,resta;
			float division=0;
			float n1=5,n2=8;
			char car;
			division = n1/n2;
			
			
			BigDecimal div = new BigDecimal(division);
			
	
			
			System.out.println(div.setScale(4));
			
			System.out.println();
			do
			{
			System.out.println("Introduce el primer numero: ");
			num1=input.nextInt();
			
			System.out.println("Introduce el segundo numero: ");
			num2=input.nextInt();
			
			    suma = num1 + num2;
			producto = num1 * num2;
			int cociente = num1 / num2;
			   resta = num1 - num2;
			int residuo = num1 % num2;
			 
			System.out.printf("La suma de los dos numeros es: %d\n",suma); 
			System.out.printf("La diferencia de los dos numeros es: %d\n",resta);
			System.out.printf("La producto de los dos numeros es: %d\n",producto); 
			System.out.printf("El cociente de los dos numeros es: %d\n",cociente); 
			System.out.printf("El residuo de los dos numeros es:  %d\n",residuo); 
			
			System.out.println("\n Desea repetir?");
			car=input.next().charAt(0);
			}
			while (car != 'n' && car != 'N');
			
			}
		
	}
