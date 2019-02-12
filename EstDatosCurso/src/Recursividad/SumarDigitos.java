package Recursividad;

import java.util.Scanner;

public class SumarDigitos
{
	public static void main(String[] args)
	{
		Scanner lc= new Scanner(System.in);
		
		System.out.print("Introduzca un numero: ");
		int num=lc.nextInt();
		
		System.out.printf ("Suma de los digitos: %d",sumarDigitos(num));
	}
	
	static int sumarDigitos(int n)
	{
		if (n!=0)
		{
		return n%10 + sumarDigitos(n/10);
		}
		
		else
		{
			return n;
		}
	}
}
