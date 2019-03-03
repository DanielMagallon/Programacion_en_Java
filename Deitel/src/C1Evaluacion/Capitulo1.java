package C1Evaluacion;
// Calcular el producto de 3 enteros
import java.util.Scanner;

public class Capitulo1 
	{
		public static void main(String[] args) 
			{
			Scanner input=new Scanner (System.in);
				
			int x,y,z,resultado;
			
			System.out.print ("Escriba el primer entero: ");
			x=input.nextInt ();
			
			System.out.print ("Escriba el segundo entero: ");
			y=input.nextInt ();
			
			System.out.print ("Escriba el tercer entero: ");
			z=input.nextInt ();
			
			resultado=x*y*z;
			
			System.out.printf ("El producto es %d\n", resultado);
			}
	}
