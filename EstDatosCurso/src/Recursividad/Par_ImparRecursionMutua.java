package Recursividad;

import java.util.Scanner;

public class Par_ImparRecursionMutua
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.print("Introduzca un numero: ");
		int n1=lc.nextInt();
		
		System.out.printf ("%d = %b\nPor lo tanto %d es un numero %s",n1,par(n1),n1,par(n1)==true ? "par" : "impar");
	}
	
	static boolean impar(int n)
	{
		if (n==0)
			return false;
		
		else
			return par(n-1);
	}
	
	static boolean par(int n)
	{
		if (n==0)
			return true;
		
		else
			return impar(n-1);
	}
}	
