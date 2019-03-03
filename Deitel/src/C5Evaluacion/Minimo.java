package C5Evaluacion;

import java.util.Scanner;

public class Minimo
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.println (" Introduzca tres valores, ya sean enteros o flotantes: ");
		double  n1 = lc.nextFloat();
		double  n2 = lc.nextFloat();
		double  n3 = lc.nextFloat();
	
		double minimo = Minimoo(n1, n2, n3);
		
		System.out.printf ("\n El numero menor es: %.2f",minimo);
	
	}
	
	public static double Minimoo (double num1,double num2,double  num3)
	{
		return Math.min (num1,Math.min(num2, num3));
	}
}
