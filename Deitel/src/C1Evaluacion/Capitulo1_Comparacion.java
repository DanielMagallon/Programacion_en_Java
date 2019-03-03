package C1Evaluacion;
import java.util.Scanner;
// Comparar dos enteros

public class Capitulo1_Comparacion 
	{
		public static void main(String[] args) 
			{
				
				Scanner input=new Scanner (System.in);
				
				int num1, num2;
				
				System.out.print ("Escriba el primer numero: ");
				num1=input.nextInt();
				
				System.out.print ("Escriba el segundo numero: ");
				num2=input.nextInt();
				
				if (num1>num2)
					System.out.printf ("%d es mas grande que %d",num1,num2);
				
				if (num2>num1)
					System.out.printf ("%d es mas grande que %d",num2,num1);
				
				if (num1==num2)
					System.out.print ("Estos numeros son iguales");
				
			}
	}
