package Recursividad;

import java.util.Scanner;

public class NumeroPositivoRM
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.print ("Introduzca un numero: ");
		int num=lc.nextInt();
		
		System.out.printf ("%d = %b\nPor lo tanto %d es un numero %s",
							num,positivo(num),num,
							positivo(num)== true ? "positivo" : "negativo");
	}
	
	static boolean positivo(int n)
	{
		if (n>=0)
			return true;
		
		else
			return negativo(n);
	}
	
	static boolean negativo(int n)
	{
		if (n<0)
			return false;
		
		else
			return positivo(n);
	}
}
