package C1IntroduccionAplicaciones;
// Compara enteros utilizando instrucciones if, operadores relacionales y de igualdad.
import java.util.Scanner;

public class Bienvenido6_Comparacion 
	{
		public static void main(String[] args) 
			{
			
			Scanner input=new Scanner (System.in);
			
			int numero1, // Primer numero a comparar
				numero2; // Segundo numero a comparar
			
			System.out.print ("Escriba el primer entero: ");
				numero1=input.nextInt(); 
				
			System.out.print ("Escriba el primer entero: ");
				numero2=input.nextInt(); 
				
			if (numero1 == numero2)
				System.out.printf ("%d == %d\n", numero1, numero2);
			
			if (numero1 != numero2)
				System.out.printf ("%d != %d\n", numero1, numero2);
			
			if (numero1 < numero2)
				System.out.printf ("%d < %d\n", numero1, numero2);
			
			if (numero1 > numero2)
				System.out.printf ("%d > %d\n", numero1, numero2);
			
			if (numero1 <= numero2)
				System.out.printf ("%d <= %d\n", numero1, numero2);
			
			if (numero1 >= numero2)
				System.out.printf ("%d >= %d\n", numero1, numero2);
			
			}
	}
