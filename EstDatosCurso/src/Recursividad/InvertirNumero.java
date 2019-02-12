package Recursividad;

import java.util.Scanner;

public class InvertirNumero 
{
	//static int total=0;
	
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		int base=1;
		int digitos=1;
		String num;
		
		System.out.print ("Introduzca un numero: ");
		num=lc.next();
		
		while (digitos<num.length())
		{
			base *= 10;
			digitos++;
		}
		
		int numero=Integer.parseInt(num);
		
		System.out.printf ("Numero invertido: %d",invertirNumero(numero,base));
	}
	
	static int invertirNumero(int n,int b)
	{
		
		if (n<10)
		{
			return n;
		}
		
		else
		{
			return ((n%10)*b) + invertirNumero(n/10,b /= 10);
		}
	}
}
