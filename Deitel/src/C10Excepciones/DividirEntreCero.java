package C10Excepciones;

import java.util.Scanner;

public class DividirEntreCero
{
	static int cociente (int numerador, int denominador)
	{
		return numerador / denominador;
	}
	
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.print("Introduzca un numerador entero: ");
		int num = lc.nextInt();
		System.out.print("\nIntroduzca un denominador entero: ");
		int den=lc.nextInt();
		
		int resultado = cociente(num, den);
		
		System.out.printf ("\nResultado: %d / %d = %d",num,den,resultado);
	}
}
